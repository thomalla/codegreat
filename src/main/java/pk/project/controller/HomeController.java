package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.project.model.CurrentUser;
import pk.project.util.Path.Web;
import pk.project.util.Path.Template;

@Controller
public class HomeController
{

    //@ModelAttribute("currentUser")
    @RequestMapping(Web.INDEX)
    public String serveIndexPage(Authentication authentication)
    {
        if(authentication==null) System.out.println("nie ma uzytnika");
        else
        {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            System.out.println(currentUser.toString());
        }

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

