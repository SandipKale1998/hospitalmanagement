package com.hospitalmanagement.serviceImp;


import java.io.File;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hospitalmanagement.utility.EmailWithAttachment;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailsender;
	

	 public void sendEmail(String toEmail, String subject, String body) {
	        // Create an instance of SimplemailMessage
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("ashutosh.at46@gmail.com");
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);
	        mailsender.send(message);
	            System.out.println("Mail sent successfully...");
	 }
	 
	 public String sendattachment(EmailWithAttachment email) {
	        try {
	            MimeMessage mimeMessage = mailsender.createMimeMessage();
	            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	            mimeMessageHelper.setTo(email.getTo());
	            mimeMessageHelper.setSubject(email.getSubject());
	            mimeMessageHelper.setText(email.getBody());
	            FileSystemResource fileSystemResource = new FileSystemResource(new File(email.getAttachmentPath()));
	            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
	            mailsender.send(mimeMessage);
	            System.out.println("mail send Successfully");
	            return "mail sent";
	        } catch (Exception ex) {
	            return "sending failed";
	        }
	    }
		
}
