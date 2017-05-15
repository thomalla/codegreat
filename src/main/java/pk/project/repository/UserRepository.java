package pk.project.repository;

import org.springframework.data.repository.CrudRepository;
import pk.project.model.User;

public interface UserRepository extends CrudRepository<User, Long>
{
}
