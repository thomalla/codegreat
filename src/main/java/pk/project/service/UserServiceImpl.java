package pk.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pk.project.form.RegisterForm;
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
    public Collection<User> getAllUsers()
    {
        return null;
    }

    /*@Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }*/

   /* @Override
    public Optional<User> getUserById(long id)
    {
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email)
    {
        return null;
    }

    @Override
    public Collection<User> getAllUsers()
    {
        return null;
    }*/

    @Override
    public User register(RegisterForm registerForm) {
        /*User user=new User(registerForm.getLogin(),registerForm.getName(),registerForm.getSurname(),registerForm.getEmail(),
                new BCryptPasswordEncoder().encode(registerForm.getPassword()),tokenGenerator.nextToken());*/
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
}
