package pk.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pk.project.form.RegisterForm;
import pk.project.model.CurrentUser;
import pk.project.model.User;
import pk.project.service.UserService;
import pk.project.util.EmailSender;
import pk.project.util.Path.Template;
import pk.project.util.Path.Web;
import pk.project.validator.RegisterValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController
{
    private final UserService userService;
    private final RegisterValidator registerValidator;
    private final CurrentUserControllerAdvice currentUserControllerAdvice;

    @Autowired
    public UserController(UserService userService, RegisterValidator registerValidator, CurrentUserControllerAdvice currentUserControllerAdvice)
    {
        this.userService = userService;
        this.registerValidator = registerValidator;
        this.currentUserControllerAdvice=currentUserControllerAdvice;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registerValidator);
    }


    @RequestMapping(value = Web.LOGIN, method = RequestMethod.GET)
    public String serveLoginPage(Model model, @RequestParam Optional<String> error)
    {
        model.addAttribute("error",error);
        return Template.LOGIN;
    }

    @RequestMapping(value = Web.REGISTER, method = RequestMethod.GET)
    public String serveRegisterPage(Model model)
    {
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

    @RequestMapping(value = Web.ACCOUNTEDITION, method = RequestMethod.GET)
    public String serveAccountEditionPage()
    {
        return Template.ACCOUNTEDITION;
    }

    @RequestMapping(value = Web.DELETEACCOUNTCONFIRMATION, method = RequestMethod.GET)
    public String serveDeleteAccountConfirmationPage()
    {
        return Template.DELETEACCOUNTCONFIRMATION;
    }

    @Transactional
    @RequestMapping(value = Web.DELETEACCOUNT, method = RequestMethod.POST)
    public String deleteUser(Authentication authentication)
    {
        userService.deleteUser(currentUserControllerAdvice.getCurrentUser(authentication).getId());
        return Template.DELETEACCOUNT;
    }

    @RequestMapping(value = Web.CHANGEPASSWORD, method = RequestMethod.GET)
    public String servePasswordChangePage()
    {
        return Template.CHANGEPASSWORD;
    }

    @RequestMapping(value = Web.CHANGEPASSWORD, method = RequestMethod.POST)
    public String changePassword(@RequestParam String currentPassword,@RequestParam String password,@RequestParam String passwordRepeated, Authentication authentication, Model model)
    {
        List<String> errorList=new ArrayList<>();
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        CurrentUser currentUser=(CurrentUser)authentication.getPrincipal();

        if(!encoder.matches(currentPassword,currentUser.getUser().getPasswordHash()))
        {
            errorList.add("Twoje aktualne hasło nie jest prawidłowe");
        }
        if(!password.equals(passwordRepeated))
        {
            errorList.add("Wprowadzone hasła nie zgadzają się");
        }
        else if(password.length()<8||password.length()>30)
        {
            errorList.add("Nowe hasło musi zawierać od 8 do 30 znaków");
        }
        model.addAttribute("errors",errorList);
        if(errorList.isEmpty())
        {
            userService.changePassword(encoder.encode(password), authentication);
            return Template.CHANGEPASSWORDSUCCESS;
        }
        return Template.CHANGEPASSWORDFAILED;

    }
}
