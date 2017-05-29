package pk.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.project.form.QuestionForm;
import pk.project.form.RegisterForm;
import pk.project.model.Question;
import pk.project.model.User;
import pk.project.repository.QuestionRepository;
import pk.project.repository.UserRepository;
import pk.project.util.Role;
import pk.project.util.TokenGenerator;

import java.util.Collection;
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
    public Question newQuestion(QuestionForm questionForm)
    {
        Question question = new Question();
        question.setUserId(99L);
        question.setResolved(false);
        question.setPoints(0L);
        question.setTopic(questionForm.getTopic());
        question.setContents(questionForm.getContents());
        return questionRepository.save(question);
    }
}
