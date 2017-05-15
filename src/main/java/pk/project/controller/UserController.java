package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.project.model.User;
import pk.project.repository.UserRepository;
import pk.project.util.Path.Web;
import pk.project.util.Path.Template;
import pk.project.util.TokenGenerator;


@Controller
public class UserController
{
    @Autowired
    UserRepository userRepository;
    TokenGenerator tokenGenerator = new TokenGenerator();

    @RequestMapping(value = Web.LOGIN, method = RequestMethod.GET)
    public String serveLoginPage()
    {
        return Template.LOGIN;
    }

    @RequestMapping(value = Web.REGISTER, method = RequestMethod.GET)
    public String serveRegisterPage()
    {
        return Template.REGISTER;
    }

}
