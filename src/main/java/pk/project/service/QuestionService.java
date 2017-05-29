package pk.project.service;


import org.springframework.data.domain.Page;
import pk.project.form.QuestionForm;
import pk.project.form.RegisterForm;
import pk.project.model.Question;
import pk.project.model.User;

import java.util.Collection;
import java.util.Optional;

public interface QuestionService
{
    Optional<Question> getQuestionById(long id);
    Question newQuestion(QuestionForm questionForm);
    Page<Question> getNewestQuestions(Integer pageNumber);

}
