package pk.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.project.util.Path.Web;
import pk.project.util.Path.Template;

@Controller
public class HomeController
{
    @RequestMapping(Web.INDEX)
    public String serveIndexPage()
    {

        return Template.INDEX;
    }

    @RequestMapping(Web.OFFER)
    public String serveOfferPage()
    {

        return Template.OFFER;
    }

    @RequestMapping(Web.ABOUT)
    public String serveAboutPage()
    {

        return Template.ABOUT;
    }

    @RequestMapping(Web.CONTACT)
    public String serveContactPage()
    {

        return Template.CONTACT;
    }
}

