package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.project.form.QuestionForm;
import pk.project.model.Question;
import pk.project.service.QuestionService;
import pk.project.util.Path;

import javax.validation.Valid;

@Controller
public class BoardController
{
    private final QuestionService questionService;

    @Autowired
    public BoardController(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    @RequestMapping(value = Path.Web.QUESTIONS_NEWEST + "/{pageNumber}", method = RequestMethod.GET)
    public String serveNewestQuestionsPage(@PathVariable Integer pageNumber, Model model)
    {
        Page<Question> page = questionService.getNewestQuestions(pageNumber);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("newestQuestions", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        return Path.Template.QUESTIONS_NEWEST;
    }

    @RequestMapping(value = Path.Web.QUESTION, method = RequestMethod.POST)
    public String addQuestions(@Valid @ModelAttribute("form")QuestionForm form)
    {
        Question question = questionService.newQuestion(form);
        return Path.Template.QUESTION_POSTED;
    }
}
