package pk.project.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import pk.project.util.Path.Email;
import pk.project.util.Path.EmailTemplate;

public class EmailSender
{
    private final String senderEmail = "****@gmail.com";
    private final String password = "********";
    private final String host = "smtp.gmail.com";

    public boolean send(String[] to, String subject, String body)
    {
        Properties props = System.getProperties();
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try
        {
            message.setFrom(new InternetAddress(senderEmail));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            //To get the array of addresses
            for(int i = 0; i < to.length; ++i)
            {
                toAddress[i] = new InternetAddress(to[i]);
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body, "utf-8", "html");

            Transport transport = session.getTransport("smtp");
            transport.connect(host, senderEmail, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch(AddressException ae)
        {
            System.out.println("--- EXCEPTION OCCURED (EmailSender::send) : " + ae.getMessage());
            return false;
        }
        catch(MessagingException me)
        {
            System.out.println("--- EXCEPTION OCCURED (EmailSender::send) : " + me.getMessage());
            return false;
        }

        return true;
    }

    public boolean sendRegistrationLink(String email, String username, String token)
    {
        String to[] = {email};
        String parsedBody = parseRegistrationLinkHtml(readHtmlFile(EmailTemplate.REGISTRATION_LINK), email, username, token);
        return send(to, "Potwierdzenie rejestracji w serwisie CodeGreat", parsedBody);
    }

    private String readHtmlFile(String file)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while((str = in.readLine()) != null)
            {
                contentBuilder.append(str);
            }
            in.close();
        }
        catch(IOException e)
        {
            System.out.println("--- (EXCEPTION OCCURED EmailSender::readHtmlFile) : " + e.getMessage());
        }

        return contentBuilder.toString();
    }

    private String parseRegistrationLinkHtml(String body, String email, String username, String token)
    {
        body = body.replace(Email.USERNAME, username);
        body = body.replace(Email.USER_EMAIL, email);
        body = body.replace(Email.TOKEN, token);
        return body;
    }
}
