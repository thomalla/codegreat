package pk.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pk.project.model.Question;

import java.util.Optional;

@Component
public interface QuestionRepository extends JpaRepository<Question, Long>
{
    Optional<Question> findOneById(Long id);
}
