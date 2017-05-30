package pk.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import pk.project.form.QuestionForm;
import pk.project.model.CurrentUser;
import pk.project.model.Question;
import pk.project.repository.QuestionRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService
{
    private static final int PAGE_SIZE = 50;
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Question> getQuestionById(long id) {
        return questionRepository.findOneById(id);
    }

    @Override
    public Page<Question> getNewestQuestions(Integer pageNumber)
    {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "id");
        return questionRepository.findAll(pageRequest);
    }

    @Override
    public Question newQuestion(QuestionForm questionForm, Authentication authentication)
    {
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        Question question = new Question();
        question.setUserId(currentUser.getId());
        question.setUsername(currentUser.getUsername());
        question.setResolved(false);
        question.setPoints(0L);
        question.setTopic(questionForm.getTopic());
        question.setContents(questionForm.getContents());
        question.setDate(new Date());

        return questionRepository.save(question);
    }
}
