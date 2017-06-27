package pk.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.project.model.Question;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long>
{
    Optional<Question> findOneById(Long id);
}
