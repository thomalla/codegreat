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

    @RequestMapping(value = Path.Web.TEST)
    public String serveTestPage()
    {
        return Path.Template.TEST;
    }




}
