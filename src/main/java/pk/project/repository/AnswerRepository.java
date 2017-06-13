package pk.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pk.project.model.Answer;

import java.util.List;
import java.util.Optional;

@Component
public interface AnswerRepository extends JpaRepository<Answer, Long>
{
    Optional<Answer> findOneById(Long id);
    List<Answer> findAllByQuestionId(Long questionId);
}
