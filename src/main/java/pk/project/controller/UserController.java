package pk.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 2017-04-20.
 */
@Controller
public class UserController
{
    @RequestMapping("/register")
    public String serveRegisterPage()
    {
        return "html/register";
    }

    @RequestMapping("/login")
    public String serveLoginPage()
    {
        return "html/login";
    }
}
