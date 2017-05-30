package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.project.model.CurrentUser;
import pk.project.service.UserService;
import pk.project.util.Path.Web;
import pk.project.util.Path.Template;

import java.util.NoSuchElementException;

@Controller
public class HomeController
{
    @RequestMapping(Web.INDEX)
    public String serveIndexPage(Model model, Authentication authentication)
    {
        if(authentication==null) System.out.println("nie ma uzytnika");
        else
        {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            model.addAttribute("user",currentUser.getUser());
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

