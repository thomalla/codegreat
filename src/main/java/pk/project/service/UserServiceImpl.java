package pk.project.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.project.form.RegisterForm;
import pk.project.model.CurrentUser;
import pk.project.model.User;
import pk.project.repository.UserRepository;
import pk.project.util.Role;
import pk.project.util.TokenGenerator;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final TokenGenerator tokenGenerator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TokenGenerator tokenGenerator)
    {
        this.userRepository = userRepository;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Optional<User> getUserByLogin(String login)
    {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public Collection<User> getAllUsers()
    {
        return null;
    }

    @Override
    public User register(RegisterForm registerForm) {
        User user=new User();
        user.setLogin(registerForm.getLogin());
        user.setName(registerForm.getName());
        user.setSurname(registerForm.getSurname());
        user.setEmail(registerForm.getEmail());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(registerForm.getPassword()));
        user.setToken(tokenGenerator.nextToken());
        user.setActivated(false);
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public boolean activateAccount(String token)
    {
        if(token == null) return false;
        Optional<User> user = userRepository.findOneByToken(token);
        if(user.isPresent() && !user.get().isActivated())
        {
            user.get().setToken(null);
            user.get().setActivated(true);
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(long id)
    {
        userRepository.deleteUserById(id);
    }

    @Override
    public void changePassword(String password, Authentication authentication)
    {
        CurrentUser currentUser=(CurrentUser)authentication.getPrincipal();
        currentUser.getUser().setPasswordHash(password);
        userRepository.save(currentUser.getUser());
    }


}
