package pk.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pk.project.form.AnswerForm;
import pk.project.model.Answer;
import pk.project.model.CurrentUser;
import pk.project.model.Question;
import pk.project.repository.AnswerRepository;
import pk.project.repository.QuestionRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService
{
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository)
    {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Answer> getAnswerById(long id)
    {
        return answerRepository.findOneById(id);
    }

    @Override
    public List<Answer> getAnswersByQuestionId(long questionId)
    {
        return answerRepository.findAllByQuestionId(questionId);
    }

    @Override
    public Answer newAnswer(AnswerForm answerForm, Authentication authentication)
    {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Answer answer = new Answer();
        answer.setUserId(currentUser.getId());
        answer.setUsername(currentUser.getUsername());
        answer.setAnswer(false);
        answer.setPoints(0L);
        answer.setContents(answerForm.getContents());
        answer.setDate(new Date());

        Optional<Question> question = questionRepository.findOneById(answerForm.getQuestionId());
        if(question.isPresent())
        {
            question.get().getAnswers().add(answer);
            answer.setQuestionId(question.get().getId());
            questionRepository.save(question.get());
        }

        return answer;
    }
}
