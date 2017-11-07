/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
 
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static pack.Send_Email.mailServerProperties;
 
public class Send_Email {
    
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
        static String  subject,messagee,to,name;

    public static Properties getMailServerProperties() {
        return mailServerProperties;
    }

    public static void setMailServerProperties(Properties mailServerProperties) {
        Send_Email.mailServerProperties = mailServerProperties;
    }

    public static Session getGetMailSession() {
        return getMailSession;
    }

    public static void setGetMailSession(Session getMailSession) {
        Send_Email.getMailSession = getMailSession;
    }

    public static MimeMessage getGenerateMailMessage() {
        return generateMailMessage;
    }

    public static void setGenerateMailMessage(MimeMessage generateMailMessage) {
        Send_Email.generateMailMessage = generateMailMessage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessagee() {
        return messagee;
    }

    public void setMessagee(String messagee) {
        this.messagee = messagee;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
	public static void main(String args[]) throws AddressException, MessagingException {
		        Send_Email s=new Send_Email();
                        s.setMessagee("Hello Test");
                        s.setName("Bebe");
                        s.setSubject("Test");
                        s.setTo("nshissa02@gmail.com");
                       s.generateAndSendEmail();     
		
	}
 
	public  void generateAndSendEmail() throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(to));
		generateMailMessage.setSubject(subject);
		String emailBody = messagee;
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "armandrwangalinde@gmail.com", ")Armand~(");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}
