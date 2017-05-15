package pk.project.repository;

import org.springframework.data.repository.CrudRepository;
import pk.project.model.User;

/**
 * Created by Tomasz on 2017-04-25.
 */

public interface StudentRepository extends CrudRepository<User, Long> {
}
