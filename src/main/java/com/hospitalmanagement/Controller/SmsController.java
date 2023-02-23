package com.hospitalmanagement.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.serviceImp.EmailService;
import com.hospitalmanagement.utility.EmailWithAttachment;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@RestController
public class SmsController {

	@Autowired
	private EmailService senderservice;

	private final String sid = "AC85201a21a4b35656d372a5660cc8dd2c";
	private final String auth = "2eeeda3b99de467a7f41800cb1488d14";

	@GetMapping(value = "/sendSMS")
	public ResponseEntity<String> sendSMS() {
		Twilio.init(sid, auth);
		Message.creator(new com.twilio.type.PhoneNumber("+91 9145769528"),
				new com.twilio.type.PhoneNumber("++12672637481"), "Hello").create();
		return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/sendOtp")
	public ResponseEntity<String> sendOTP() {
		Twilio.init(sid, auth);

		Random random=new Random();
       int number=random.nextInt(1000000);		
      String Otp=Integer.toString(number);
		Message.creator(new com.twilio.type.PhoneNumber("+91 9145769528"),
				new com.twilio.type.PhoneNumber("++12672637481"), Otp).create();
		return new ResponseEntity<String>("Otp sent successfully", HttpStatus.OK);
	}


	@PostMapping("/sendMail")
	public String sendattachmennt(@RequestBody EmailWithAttachment email) {
		return senderservice.sendattachment(email);

	}
}