package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pk.project.form.RegisterForm;
import pk.project.model.User;
import pk.project.service.UserService;
import pk.project.util.EmailSender;
import pk.project.util.Path.Web;
import pk.project.util.Path.Template;
import pk.project.validator.RegisterValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
public class UserController
{
    private final UserService userService;
    private final RegisterValidator registerValidator;

    @Autowired
    public UserController(UserService userService, RegisterValidator registerValidator)
    {
        this.userService = userService;
        this.registerValidator = registerValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }


    @RequestMapping(value = Web.LOGIN, method = RequestMethod.GET)
    public String serveLoginPage(Model model, @RequestParam Optional<String> error)
    {
        System.out.println("jestem w serve login");
        model.addAttribute("errors",error);
        return Template.LOGIN;
    }

    @PreAuthorize("currentUserServiceImpl.canAccessUser(principal,#id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        System.out.println("jestem w getuserpage");
        return new ModelAndView("user", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    @RequestMapping(value = Web.REGISTER, method = RequestMethod.GET)
    public String serveRegisterPage(Model model)
    {
        System.out.println("jestem w serve register");
        model.addAttribute("errors", new ArrayList<ObjectError>());
        return Template.REGISTER;
    }

    @RequestMapping(value = Web.ACCOUNTACTIVATION + "/{token}", method = RequestMethod.GET)
    public String serveActivationPage(@PathVariable("token") String token, Model model)
    {
        if(userService.activateAccount(token))
        {
            return Template.VERIFIACTION_SUCCESS;
        }
        else
        {
            return Template.VERIFIACTION_FAILED;
        }
    }

    @RequestMapping(value = Web.REGISTER, method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("form")RegisterForm form,BindingResult bindingResult, Model model)
    {
        List<ObjectError> errorList;
        User user;
        EmailSender emailSender = new EmailSender();

        if(bindingResult.hasErrors())
        {
            errorList=bindingResult.getAllErrors();
            model.addAttribute("errors",errorList);
            return Template.REGISTER;
        }
        try
        {
            user = userService.register(form);
        }
        catch(DataIntegrityViolationException e)
        {
            errorList=new ArrayList<>();
            errorList.add(new ObjectError("email.exists","Email istnieje już w bazie"));
            model.addAttribute("errors",errorList);
            return Template.REGISTER;
        }

        emailSender.sendRegistrationLink(user.getEmail(), user.getName(), user.getToken());
        return Template.REGISTER_SUCCESS;
    }

    
}
