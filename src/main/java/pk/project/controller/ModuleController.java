package pk.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pk.project.util.Path;


@Controller
public class ModuleController
{

    @RequestMapping(value = Path.Web.ALLMODULES)
    public String serveAllModulesPage()
    {
        return Path.Template.ALLMODULES;
    }

    @RequestMapping(value = Path.Web.DESCRIPTION11)
    public String serveDescription11Page()
    {
        return Path.Template.DESCRIPTION11;
    }

    @RequestMapping(value = Path.Web.LESSON11)
    public String serveLesson11Page()
    {
        return Path.Template.LESSON11;
    }

    @RequestMapping(value = Path.Web.LESSON12)
    public String serveLesson12Page()
    {
        return Path.Template.LESSON12;
    }

    @RequestMapping(value = Path.Web.LESSON13)
    public String serveLesson13Page()
    {
        return Path.Template.LESSON13;
    }
    @RequestMapping(value = Path.Web.LESSON14)
    public String serveLesson14Page()
    {
        return Path.Template.LESSON14;
    }
    @RequestMapping(value = Path.Web.LESSON15)
    public String serveLesson15Page()
    {
        return Path.Template.LESSON15;
    }
    @RequestMapping(value = Path.Web.LESSON16)
    public String serveLesson16Page()
    {
        return Path.Template.LESSON16;
    }
    @RequestMapping(value = Path.Web.LESSON21)
    public String serveLesson21Page()
    {
        return Path.Template.LESSON21;
    }
    @RequestMapping(value = Path.Web.LESSON22)
    public String serveLesson22Page()
    {
        return Path.Template.LESSON22;
    }
    @RequestMapping(value = Path.Web.LESSON23)
    public String serveLesson23Page()
    {
        return Path.Template.LESSON23;
    }
    @RequestMapping(value = Path.Web.LESSON24)
    public String serveLesson24Page()
    {
        return Path.Template.LESSON24;
    }
    @RequestMapping(value = Path.Web.LESSON31)
    public String serveLesson31Page()
    {
        return Path.Template.LESSON31;
    }
    @RequestMapping(value = Path.Web.LESSON32)
    public String serveLesson32Page()
    {
        return Path.Template.LESSON32;
    }
    @RequestMapping(value = Path.Web.LESSON33)
    public String serveLesson33Page()
    {
        return Path.Template.LESSON33;
    }
    @RequestMapping(value = Path.Web.LESSON34)
    public String serveLesson34Page()
    {
        return Path.Template.LESSON34;
    }
    @RequestMapping(value = Path.Web.LESSON35)
    public String serveLesson35Page()
    {
        return Path.Template.LESSON35;
    }

    @RequestMapping(value = Path.Web.TEST)
    public String serveTestPage()
    {
        return Path.Template.TEST;
    }




}
