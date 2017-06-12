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

    @RequestMapping(value = Path.Web.DESCRIPTION1)
    public String serveDescription1Page()
    {
        return Path.Template.DESCRIPTION1;
    }

    @RequestMapping(value = Path.Web.DESCRIPTION2)
    public String serveDescription2Page()
    {
        return Path.Template.DESCRIPTION2;
    }

    @RequestMapping(value = Path.Web.DESCRIPTION3)
    public String serveDescription3Page()
    {
        return Path.Template.DESCRIPTION3;
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

    @RequestMapping(value = Path.Web.TEST1)
    public String serveTest1Page()
    {
        return Path.Template.TEST1;
    }
    @RequestMapping(value = Path.Web.TEST2)
    public String serveTest2Page()
    {
        return Path.Template.TEST2;
    }
    @RequestMapping(value = Path.Web.TEST3)
    public String serveTest3Page() { return Path.Template.TEST3; }


    @RequestMapping(value = Path.Web.TEST11)
    public String serveTest11Page()
    {
        return Path.Template.TEST11;
    }
    @RequestMapping(value = Path.Web.TEST12)
    public String serveTest12Page()
    {
        return Path.Template.TEST12;
    }
    @RequestMapping(value = Path.Web.TEST13)
    public String serveTest13Page()
    {
        return Path.Template.TEST13;
    }
    @RequestMapping(value = Path.Web.TEST14)
    public String serveTest14Page()
    {
        return Path.Template.TEST14;
    }
    @RequestMapping(value = Path.Web.TEST15)
    public String serveTest15Page()
    {
        return Path.Template.TEST15;
    }
    @RequestMapping(value = Path.Web.TEST16)
    public String serveTest16Page()
    {
        return Path.Template.TEST16;
    }

    @RequestMapping(value = Path.Web.TEST21)
    public String serveTest21Page()
    {
        return Path.Template.TEST21;
    }
    @RequestMapping(value = Path.Web.TEST22)
    public String serveTest22Page()
    {
        return Path.Template.TEST22;
    }
    @RequestMapping(value = Path.Web.TEST23)
    public String serveTest23Page()
    {
        return Path.Template.TEST23;
    }
    @RequestMapping(value = Path.Web.TEST24)
    public String serveTest24Page()
    {
        return Path.Template.TEST24;
    }
    @RequestMapping(value = Path.Web.TEST25)
    public String serveTest25Page()
    {
        return Path.Template.TEST25;
    }

    @RequestMapping(value = Path.Web.TEST31)
    public String serveTest31Page()
    {
        return Path.Template.TEST31;
    }
    @RequestMapping(value = Path.Web.TEST32)
    public String serveTest32Page()
    {
        return Path.Template.TEST32;
    }
    @RequestMapping(value = Path.Web.TEST33)
    public String serveTest33Page()
    {
        return Path.Template.TEST33;
    }
    @RequestMapping(value = Path.Web.TEST34)
    public String serveTest34Page()
    {
        return Path.Template.TEST34;
    }

}
