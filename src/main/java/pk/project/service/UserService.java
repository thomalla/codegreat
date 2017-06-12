package pk.project.service;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Component;
import pk.project.form.RegisterForm;
import pk.project.model.User;

import java.util.Collection;
import java.util.Optional;

@Component
public interface UserService
{
    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByLogin(String login);

    Collection<User> getAllUsers();

    User register(RegisterForm form);

    boolean activateAccount(String token);

    void deleteUser(long id);

    void changePassword(String newPassword, Authentication authentication);
}
