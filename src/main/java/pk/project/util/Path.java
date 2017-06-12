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

        public static final String DESCRIPTION11 = "/description/1/1";
        public static final String DESCRIPTION12 = "/description/1/2";
        public static final String DESCRIPTION13 = "/description/1/3";


        public static final String LESSON11 = "/lesson/1/1";
        public static final String LESSON12 = "/lesson/1/2";
        public static final String LESSON13 = "/lesson/1/3";
        public static final String LESSON14 = "/lesson/1/4";
        public static final String LESSON15 = "/lesson/1/5";
        public static final String LESSON16 = "/lesson/1/6";

        public static final String LESSON21 = "/lesson/2/1";
        public static final String LESSON22 = "/lesson/2/2";
        public static final String LESSON23 = "/lesson/2/3";
        public static final String LESSON24 = "/lesson/2/4";

        public static final String LESSON31 = "/lesson/3/1";
        public static final String LESSON32 = "/lesson/3/2";
        public static final String LESSON33 = "/lesson/3/3";
        public static final String LESSON34 = "/lesson/3/4";
        public static final String LESSON35 = "/lesson/3/5";


        public static final String TEST = "/test";

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

        public static final String DESCRIPTION11 = "html/course/description1.html";
        public static final String DESCRIPTION12 = "html/course/description2.html";
        public static final String DESCRIPTION13 = "html/course/description3.html";

        public static final String LESSON11 = "html/course/lessons/lesson11.html";
        public static final String LESSON12 = "html/course/lessons/lesson12.html";
        public static final String LESSON13 = "html/course/lessons/lesson13.html";
        public static final String LESSON14 = "html/course/lessons/lesson14.html";
        public static final String LESSON15 = "html/course/lessons/lesson15.html";
        public static final String LESSON16 = "html/course/lessons/lesson16.html";

        public static final String LESSON21 = "html/course/lessons/lesson21.html";
        public static final String LESSON22 = "html/course/lessons/lesson22.html";
        public static final String LESSON23 = "html/course/lessons/lesson23.html";
        public static final String LESSON24 = "html/course/lessons/lesson24.html";

        public static final String LESSON31 = "html/course/lessons/lesson31.html";
        public static final String LESSON32 = "html/course/lessons/lesson32.html";
        public static final String LESSON33 = "html/course/lessons/lesson33.html";
        public static final String LESSON34 = "html/course/lessons/lesson34.html";
        public static final String LESSON35 = "html/course/lessons/lesson35.html";
        public static final String TEST = "html/test.html";

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