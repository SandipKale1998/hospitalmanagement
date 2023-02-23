package com.hospitalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude =SecurityAutoConfiguration.class)
public class HospitalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
		System.out.println("Spring Start..");

	}
}
	
	



	
	
	
	
	










//@Autowired
//private EmailService senderservice;	
	
	
//	@EventListener(ApplicationReadyEvent.class)
	//public void sendMail() {
	//	senderservice.sendEmail("sandipkale9528@gmail.com","this is subject","this is body of email" );	
 //}
 
