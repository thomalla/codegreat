package pk.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by DELL on 2017-04-19.
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    public String serveIndexPage()
    {
        return "html/index";
    }
}
