package pk.project.service;

import org.springframework.security.core.Authentication;
import pk.project.form.AnswerForm;
import pk.project.model.Answer;
import pk.project.model.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerService
{
    Optional<Answer> getAnswerById(long id);
    List<Answer> getAnswersByQuestionId(long questionId);
    Answer newAnswer(AnswerForm answerForm, Authentication authentication);
    //Page<Question> getNewestQuestions(Integer pageNumber);
}
