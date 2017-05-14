package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.project.model.User;
import pk.project.repository.StudentRepository;

/**
 * Created by DELL on 2017-04-20.
 */
@Controller
public class UserController
{
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String serveRegisterPage()
    {
        return "html/register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("newUser") User user)
    {
        studentRepository.save(user);
        return "html/index";
    }
    @RequestMapping("/login")
    public String serveLoginPage()
    {
        return "html/login";
    }
}
