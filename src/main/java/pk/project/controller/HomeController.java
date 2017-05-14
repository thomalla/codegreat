package pk.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
    @RequestMapping("/")
    public String serveIndexPage()
    {


        return "html/index";
    }

    @RequestMapping("/offer")
    public String serveOfferPage()
    {

        return "html/offer";
    }

    @RequestMapping("/about")
    public String serveAboutPage()
    {

        return "html/about";
    }

    @RequestMapping("/contact")
    public String serveContactPage()
    {

        return "html/contact";
    }
}

