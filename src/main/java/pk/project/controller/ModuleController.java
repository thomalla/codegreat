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
}
