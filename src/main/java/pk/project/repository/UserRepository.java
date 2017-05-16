package pk.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pk.project.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>
{
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneById(Long id);
}
