package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pk.project.form.AnswerForm;
import pk.project.form.QuestionForm;
import pk.project.model.Answer;
import pk.project.model.Question;
import pk.project.service.AnswerService;
import pk.project.service.QuestionService;
import pk.project.util.Path;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BoardController
{
    private final QuestionService questionService;
    private final AnswerService answerService;


    @Autowired
    public BoardController(QuestionService questionService, AnswerService answerService)
    {
        this.questionService = questionService;
        this.answerService = answerService;
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

    @RequestMapping(value = Path.Web.QUESTION  + "/{questionId}", method = RequestMethod.GET)
    public String serveQuestionPage(@PathVariable Long questionId, Model model)
    {
        Optional<Question> question = questionService.getQuestionById(questionId);
        List<Answer> answers = answerService.getAnswersByQuestionId(questionId);
        System.out.println(answers.size());

        model.addAttribute("answers", answers);
        model.addAttribute("question", question.get());
        return Path.Template.QUESTION;
    }

    @RequestMapping(value = Path.Web.ADD_QUESTION, method = RequestMethod.GET)
    public String serveAddQuestionPage(Model model)
    {
        return Path.Template.ADD_QUESTION;
    }

    @RequestMapping(value = Path.Web.ADD_QUESTION, method = RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute("form")QuestionForm form, Authentication authentication)
    {
        Question question = questionService.newQuestion(form, authentication);
        return "redirect:/questions/newest/1";
    }

    @RequestMapping(value = Path.Web.ADD_ANSWER, method = RequestMethod.POST)
    public String addAnswer(@Valid @ModelAttribute("form")AnswerForm form, Authentication authentication)
    {
        Answer answer = answerService.newAnswer(form, authentication);
        return "redirect:/question/"+answer.getQuestionId();
    }
}
