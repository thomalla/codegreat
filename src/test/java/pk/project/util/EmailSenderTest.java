package pk.project.util;

import org.junit.Assert;
import org.junit.Test;

public class EmailSenderTest
{
    EmailSender emailSender = new EmailSender();
    String to[] = {"contact.codegreat@gmail.com"};

    @Test
    public void simpleSendTest()
    {
        Assert.assertTrue("send must returns true", emailSender.send(to,"simpleSendTest()", "Simple Send Test"));
    }

    @Test
    public void simpleHtmlSendTest()
    {
        String htmlBody = "" +
                "<html>" +
                "<head></head>" +
                "<body>" +
                "<h1 align=\"center\"> Simple HTML <b>Test</b></h1>" +
                "</body>" +
                "</html>";
        Assert.assertTrue("send must returns true", emailSender.send(to,"simpleHtmlSendTest()", htmlBody));
    }

    @Test
    public void registrationLinkSendTest()
    {
        TokenGenerator tokenGenerator = new TokenGenerator();
        Assert.assertTrue("send must returns true",
                emailSender.sendRegistrationLink("contact.codegreat@gmail.com", "UnitTest", tokenGenerator.nextToken()));
    }
}