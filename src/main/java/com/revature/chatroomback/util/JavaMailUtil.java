package com.revature.chatroomback.util;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;

public class JavaMailUtil {
	
	private JavaMailUtil() {
	    throw new IllegalStateException("Utility class");
	  }
	
	static Logger logger = LogManager.getLogger(JavaMailUtil.class);
	
public static void sendReimburseMail(String recipient) throws Exception {
	Properties properties = new Properties();
	
	properties.put("mail.smtp.auth", true);
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "587");
	
	String myAccountEmail = "saramm123454321@gmail.com";
	String password = "P@ssword123!";
	
	Session session = Session.getInstance(properties, new Authenticator(){
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(myAccountEmail, password);
		}
	});
	
	Message message = prepareMassage(session, myAccountEmail, recipient);
	Transport.send(message);
}

private static Message prepareMassage(Session session, String myAccountEmail, String recipient) {
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(myAccountEmail));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		message.setSubject("Your reimbursement has been completed");
		String reimburseComplete = "<h2>Hello!</h2><br>"
				+ "Your reimbursement has been completed! Log into view your reimbursement.<br/><br/>"
				+ "Thank you!<br/> Team Sara"; 
		message.setContent(reimburseComplete, "text/html");
		return message;
	} catch(Exception e) {
		logger.info("alright something crazy happened");
	}
	return null;
}}







