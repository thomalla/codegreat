package pk.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import pk.project.model.User;

import java.util.Optional;

@Component
public interface UserRepository extends CrudRepository<User, Long>
{
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneById(Long id);
    Optional<User> findOneByToken(String token);
    Optional<User> findOneByLogin(String login);
    void deleteUserById(Long id);
}
