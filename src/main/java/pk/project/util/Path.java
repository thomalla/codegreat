package pk.project.util;

public class Path
{
    public static class Web
    {
        public static final String INDEX = "/";
        public static final String REGISTER = "/register";
        public static final String LOGIN = "/login";
        public static final String LOGOUT = "/logout";
        public static final String FORGOTPASSWORD = "/forgotPassword";
        public static final String RESETPASSWORD = "/resetPassword";
        public static final String ACCOUNTACTIVATION= "/accountActivation";
        public static final String OFFER = "/offer";
        public static final String ABOUT = "/about";
        public static final String CONTACT = "/contact";
    }

    public static class Template
    {
        public static final String INDEX = "html/index.html";
        public static final String REGISTER = "html/register.html";
        public static final String LOGIN = "html/login.html";
        public static final String REGISTER_SUCCESS = "html/registerSuccess.html";
        public static final String OFFER = "html/offer.html";
        public static final String ABOUT = "html/about.html";
        public static final String CONTACT = "html/contact.html";
    }

    public static class Email
    {
        public static final String USERNAME = "$username";
        public static final String USER_EMAIL = "$user_email";
        public static final String TOKEN = "$token";
    }

    public static class EmailTemplate
    {
        public static final String REGISTRATION_LINK = "html/email/registrationLink.html";
    }

}