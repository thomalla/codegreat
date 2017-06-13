package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pk.project.service.TestService;
import pk.project.util.Path;

@Controller
public class TestController
{
    private TestService testService;

    @Autowired
    public TestController(TestService testService)
    {
        this.testService = testService;
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
    public String serveTest3Page()
    {
        return Path.Template.TEST3;
    }
    @RequestMapping(value = Path.Web.TEST11, method = RequestMethod.GET)
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
    @RequestMapping(value = Path.Web.TEST35)
    public String serveTest35Page()
    {
        return Path.Template.TEST35;
    }

    @RequestMapping(value = Path.Web.TEST1, method = RequestMethod.POST)
    public String checkTest1(@RequestParam char a1, @RequestParam char a2, @RequestParam char a3,@RequestParam char a4, @RequestParam char a5, @RequestParam char a6,  Model model)
    {
        char correctAnswers[]={'c','a','b','d','d','d'};
        char userAnswers[]={a1,a2,a3,a4,a5,a6};
        String userAnswersStr[]=new String[userAnswers.length];
        for(int i=0;i<userAnswers.length;i++)
        {
            userAnswersStr[i]=Character.toString(userAnswers[i]);
        }
        boolean correctness[]=testService.checkCorectness(correctAnswers,userAnswers);
        Integer score=testService.countScore(correctAnswers,userAnswers);
        model.addAttribute("correctness",correctness);
        model.addAttribute("userAnswers",userAnswersStr);
        model.addAttribute("score",score);
        return Path.Template.TEST1;
    }
    @RequestMapping(value = Path.Web.TEST2CHECK, method = RequestMethod.POST)
    public String checkTest2(@RequestParam char a1, @RequestParam char a2, @RequestParam char a3,@RequestParam char a4, @RequestParam char a5, @RequestParam char a6,  Model model)
    {
        char correctAnswers[]={'c','a','b','c','c','c'};
        char userAnswers[]={a1,a2,a3,a4,a5,a6};
        String userAnswersStr[]=new String[userAnswers.length];
        for(int i=0;i<userAnswers.length;i++)
        {
            userAnswersStr[i]=Character.toString(userAnswers[i]);
        }
        boolean correctness[]=testService.checkCorectness(correctAnswers,userAnswers);
        Integer score=testService.countScore(correctAnswers,userAnswers);
        model.addAttribute("correctness",correctness);
        model.addAttribute("userAnswers",userAnswersStr);
        model.addAttribute("score",score);
        return Path.Template.TEST2;
    }
    @RequestMapping(value = Path.Web.TEST3, method = RequestMethod.POST)
    public String checkTest3()
    {
        return Path.Template.TEST3;
    }
    @RequestMapping(value = Path.Web.TEST11CHECK, method = RequestMethod.POST)
    public String checkTest11(@RequestParam char a1, @RequestParam char a2, Model model)
    {
        char correctAnswers[]={'b','c'};
        char userAnswers[]={a1,a2};
        String userAnswersStr[]=new String[userAnswers.length];
        for(int i=0;i<userAnswers.length;i++)
        {
            userAnswersStr[i]=Character.toString(userAnswers[i]);
        }
        boolean correctness[]=testService.checkCorectness(correctAnswers,userAnswers);
        Integer score=testService.countScore(correctAnswers,userAnswers);
        System.out.println(score);

        model.addAttribute("correctness",correctness);
        model.addAttribute("userAnswers",userAnswersStr);
        model.addAttribute("score",score);
        return Path.Template.TEST11;
    }
    @RequestMapping(value = Path.Web.TEST12, method = RequestMethod.POST)
    public String checkTest12()
    {
        return Path.Template.TEST12;
    }
    @RequestMapping(value = Path.Web.TEST13, method = RequestMethod.POST)
    public String checkTest13()
    {
        return Path.Template.TEST13;
    }
    @RequestMapping(value = Path.Web.TEST14, method = RequestMethod.POST)
    public String checkTest14()
    {
        return Path.Template.TEST14;
    }
    @RequestMapping(value = Path.Web.TEST15, method = RequestMethod.POST)
    public String checkTest15()
    {
        return Path.Template.TEST15;
    }
    @RequestMapping(value = Path.Web.TEST16, method = RequestMethod.POST)
    public String checkTest16()
    {
        return Path.Template.TEST16;
    }

    @RequestMapping(value = Path.Web.TEST21, method = RequestMethod.POST)
    public String checkTest21()
    {
        return Path.Template.TEST21;
    }
    @RequestMapping(value = Path.Web.TEST22, method = RequestMethod.POST)
    public String checkTest22()
    {
        return Path.Template.TEST22;
    }
    @RequestMapping(value = Path.Web.TEST23, method = RequestMethod.POST)
    public String checkTest23()
    {
        return Path.Template.TEST23;
    }
    @RequestMapping(value = Path.Web.TEST24, method = RequestMethod.POST)
    public String checkTest24()
    {
        return Path.Template.TEST24;
    }
    @RequestMapping(value = Path.Web.TEST31, method = RequestMethod.POST)
    public String checkTest31()
    {
        return Path.Template.TEST31;
    }
    @RequestMapping(value = Path.Web.TEST32, method = RequestMethod.POST)
    public String checkTest32()
    {
        return Path.Template.TEST32;
    }
    @RequestMapping(value = Path.Web.TEST33, method = RequestMethod.POST)
    public String checkTest33()
    {
        return Path.Template.TEST33;
    }
    @RequestMapping(value = Path.Web.TEST34, method = RequestMethod.POST)
    public String checkTest34()
    {
        return Path.Template.TEST34;
    }
    @RequestMapping(value = Path.Web.TEST35, method = RequestMethod.POST)
    public String checkTest35()
    {
        return Path.Template.TEST35;
    }
}
