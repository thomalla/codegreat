package pk.project.util;

public class Path
{
    public static class Web
    {
        public static final String INDEX = "/";
        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
        public static final String FORGOTPASSWORD = "/forgotPassword";
        public static final String RESETPASSWORD = "/resetPassword";
        public static final String ACCOUNTACTIVATION= "/accountActivation";
        public static final String OFFER = "/offer";
        public static final String ABOUT = "/about";
        public static final String CONTACT = "/contact";
        public static final String QUESTION = "/question";
        public static final String QUESTIONS_NEWEST = "/questions/newest";
        public static final String ADD_QUESTION = "/addQuestion";
        public static final String ALLMODULES = "/allModules";
        public static final String ACCOUNTEDITION = "/accountEdition";
        public static final String DELETEACCOUNTCONFIRMATION="/deleteAccountConfirmation";
        public static final String DELETEACCOUNT="/deleteAccount";
        public static final String CHANGEPASSWORD="/changePassword";

    }

    public static class Template
    {
        public static final String INDEX = "html/index.html";
        public static final String REGISTER = "html/register.html";
        public static final String LOGIN = "html/login.html";
        public static final String OFFER = "html/offer.html";
        public static final String ABOUT = "html/about.html";
        public static final String CONTACT = "html/contact.html";
        public static final String REGISTER_FAILED = "html/registerFailed.html";
        public static final String REGISTER_SUCCESS = "html/registerSuccess.html";
        public static final String VERIFIACTION_SUCCESS = "html/verificationSuccess.html";
        public static final String VERIFIACTION_FAILED = "html/verificationFailed.html";
        public static final String QUESTION = "html/question.html";
        public static final String ADD_QUESTION = "html/addQuestion.html";
        public static final String QUESTIONS_NEWEST = "html/questionsNewest.html";
        public static final String QUESTION_POSTED = "html/questionPosted.html";
        public static final String ALLMODULES = "html/allModules.html";
        public static final String ACCOUNTEDITION = "html/accountEdition.html";
        public static final String DELETEACCOUNTCONFIRMATION = "html/deleteAccountConfirmation.html";
        public static final String DELETEACCOUNT="html/deleteAccount.html";
        public static final String CHANGEPASSWORD="html/changePassword.html";
        public static final String CHANGEPASSWORDSUCCESS="html/changePasswordSuccess.html";
        public static final String CHANGEPASSWORDFAILED="html/changePasswordFailed.html";



    }

    public static class Email
    {
        public static final String USERNAME = "$username";
        public static final String USER_EMAIL = "$user_email";
        public static final String TOKEN = "$token";
    }

    public static class EmailTemplate
    {
        //TODO why we must write whole location?
        public static final String REGISTRATION_LINK = "src/main/resources/templates/html/email/registrationLink.html";
    }

}