package com.hospitalmanagement.serviceImp;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.AdminService;
import com.hospitalmanagement.Configure.JwtToken;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.AdminRepository;
import com.hospitalmangement.bean.Admin;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class AdminServiceImplementation implements AdminService {

	Logger logger = LoggerFactory.getLogger(AdminServiceImplementation.class);

	private static final long OTP_VALID_DURATION = 1 * 60 * 1000; // 1 minutes

	@Autowired
	private AdminRepository adminrepository;

	@Autowired
	private JwtToken jwttokenutil;

	private final String sid = "AC85201a21a4b35656d372a5660cc8dd2c";
	private final String auth = "2eeeda3b99de467a7f41800cb1488d14";

	@Override
	public FinalResponse getAdmin() {
		List<Object[]> admin = null;
		FinalResponse finalResponse = new FinalResponse();
		logger.info("getadmin :: input ::");
		try {
			admin = adminrepository.GetAdmin();
			if (admin != null) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage("Record Present");
				// finalResponse.setDatas(admin);
				finalResponse.setData(admin);
			}
		} catch (InputMismatchException e) {
			logger.error("getadmin :: input ::" + e.getMessage());
		}
		return finalResponse;
	}

	// Insert New Admin 
	@Override
	public FinalResponse addAdmin(Admin admin) {
		FinalResponse finalresponse = new FinalResponse();
		logger.info("InsertingOneBillRecord:: input :: bill:" + admin);
		try {
			adminrepository.InsertAdmin(admin);
			if (admin != null) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("One Record was Inserted");
			}
		} catch (Exception ex) {
			logger.error("Not InsertingOneBillRecord:: input :: bill:" + ex.getMessage());
		}
		return finalresponse;
	}

	// delete admin by id 
	@Override
	public FinalResponse deleteAdminbyid(int adminId) {
		FinalResponse finalResponse = new FinalResponse();
		logger.info("deletebillbyid :: input :: bid:" + adminId);

		try {
			adminrepository.DeleteAdminByid(adminId);
			if (adminId > 0) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage(adminId + " th Record was deleted");
			}
		} catch (InputMismatchException e) {
			logger.error("deletebillbyid :: input :: bid:" + adminId + e.getMessage());
		}
		return finalResponse;
	}

	
	// retrieve admin record by id
	@Override
	public FinalResponse GetAdminbyid(int adminId) {
		FinalResponse finalresponse = new FinalResponse();
		logger.info("InsertingOneCBookRecord::input::book:" + adminId);
		try {
			List<Object[]> admin = adminrepository.GetAdminByid(adminId);
			LinkedHashMap<String, String> adminobjects = new LinkedHashMap<>();
			for (Object[] admindetails : admin) {
				adminobjects.put("Id:", String.valueOf(admindetails[0]));
				adminobjects.put("FirstName:", String.valueOf(admindetails[1]));
				adminobjects.put("LastName:", String.valueOf(admindetails[2]));
				adminobjects.put("ContactNo:", String.valueOf(admindetails[3]));
				adminobjects.put("City:", String.valueOf(admindetails[4]));
				adminobjects.put("UserName:", String.valueOf(admindetails[5]));
				adminobjects.put("Password:", String.valueOf(admindetails[6]));
			}
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record is persent");
			finalresponse.setData(adminobjects);
			return finalresponse;
		} catch (InputMismatchException ex) {
			logger.error("InsertingOneAdminRecord::input::book:");
		}
		return finalresponse;
	}

	// update admin record
	@Override
	public FinalResponse UpdateAdmin(Admin admin) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingAdminRecord:: input :: admin:" + admin);
		System.out.println(admin.getFirstName());
		try {
			adminrepository.UpdateAdmin(admin);
			if (admin != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingAdminRecord:: input :: admin:" + ex.getMessage());
		}
		return finalresponce;
	}
	
	// admin login
	@Override
	public FinalResponse AdminLogin(Admin login) {
		logger.info("Login::input:: user:" + login);
		FinalResponse finalResponse = new FinalResponse();
		Object user = null;
		Object password = null;
		List<Object> userList = adminrepository.checkUsersName();
		for (int i = 0; i < userList.size(); i++) {
			if ((login.getUsername()).equals(userList.get(i))) {
				user = userList.get(i);
			}
		}
		List<Object> passwordList = adminrepository.checkUsersPassword();
		for (int i = 0; i < passwordList.size(); i++) {
			if ((login.getPassword()).equals(passwordList.get(i))) {
				password = passwordList.get(i);
			}
		}
		if (login.getUsername().equals(user)) {
			if (login.getPassword().equals(password)) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage("User Login Successfull");
				Object token = jwttokenutil.generateToken(login);
				finalResponse.setData(token);
				return finalResponse;

			} else {
				finalResponse.setStatus(false);
				finalResponse.setStatusCode("404");
				finalResponse.setErrorMessages("password is incorrect");
				return finalResponse;
			}
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("404");
			finalResponse.setErrorMessages("user no exit");
			return finalResponse;
		}
	}

	@Override
	public FinalResponse validatingToken(String token, Admin admin) {
		FinalResponse finalResponse = new FinalResponse();
		String userToken = token.substring(7, token.length());
		if (userToken != null) {
			try {
				boolean value = jwttokenutil.validateToken(userToken, admin);
				System.out.println(userToken);
				if (value == true) {
					finalResponse.setStatus(true);
					finalResponse.setStatusCode("200");
					finalResponse.setMessage("Token is valid");
					return finalResponse;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		finalResponse.setStatus(false);
		finalResponse.setStatusCode("500");
		finalResponse.setMessage("Token is Invalid");
		return finalResponse;
	}

	
	// login by using mobile number
	@Override
	public FinalResponse adminLoginByMobileNumber(String mobileNumber, String password) {
		logger.info("userLoginByMobile:: " + mobileNumber + " : " + password);
		FinalResponse finalResponse = new FinalResponse();
		String passwordAuthentication = adminrepository.checkadminIsPresentByMobileNumber(mobileNumber);
		if (passwordAuthentication != null) {
			if (passwordAuthentication.equals(password)) {
				try {
					Admin user = adminrepository.adminLoginByMobileNumber(mobileNumber, passwordAuthentication);
					finalResponse.setStatus(true);
					finalResponse.setStatusCode("200");
					finalResponse.setMessage("Login successful");
					finalResponse.setData(user);
					return finalResponse;
				} catch (InputMismatchException ex) {
					logger.error("userLoginByMobile:: " + ex.getMessage());
				}
			} else {
				Twilio.init(sid, auth);
				Random random = new Random();
				int randomnumber = random.nextInt(1000000);
				String Opt = Integer.toString(randomnumber);
				Message.creator(new com.twilio.type.PhoneNumber("+91 9145769528"),
						new com.twilio.type.PhoneNumber("++12672637481"), Opt).create();
				adminrepository.UpdateOtp(randomnumber, new Date(), mobileNumber);
				finalResponse.setMessage("incorrect password");
				return finalResponse;
			}
		} else {
			finalResponse.setMessage("user does not exists with this mobile number");
			return finalResponse;
		}
		return finalResponse;
	}

	@Override
	public FinalResponse AdminLogin2(Admin admin) {
		FinalResponse finalResponse = new FinalResponse();
		Object loginInfo = adminrepository.Login(admin.getUsername(), admin.getPassword());
		if (loginInfo != null) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("login successfull");
			Object jwttoken = jwttokenutil.generateToken(admin);
			finalResponse.setData(jwttoken);
			return finalResponse;
		} else {
			finalResponse.setStatus(false);
			// sms.sendOTP();
			finalResponse.setStatusCode("404");
			finalResponse.setErrorMessages("Wrong username");
		}
		return finalResponse;
	}
	
	@Override
	public FinalResponse verificationotp(int otp, String mobileNumber) {
		FinalResponse finalResponse = new FinalResponse();
		int otps = adminrepository.checkotp(mobileNumber);
		if (otps != 0) {
			long currentTime = System.currentTimeMillis();
			long otpRequested = adminrepository.toGetDBOtpTime(mobileNumber).getTime();
			if (otpRequested + OTP_VALID_DURATION > currentTime) {
				if (otps == otp) {
					/*
					 * SimpleMailMessage message = new SimpleMailMessage();
					 * message.setFrom("sandipkale9528@gmail.com"); message.setTo(to);
					 * message.setSubject("verfication");
					 * message.setText("otp verification is done"); mailsender.send(message);
					 */

					adminrepository.verficationotp(otp, mobileNumber);
					finalResponse.setStatus(true);
					finalResponse.setStatusCode("200");
					finalResponse.setMessage(" otp verification is done");
					return finalResponse;
				} else {
					finalResponse.setStatus(false);
					finalResponse.setStatusCode("500");
					finalResponse.setMessage(" otp time has expiry");
					return finalResponse;
				}
			} else {
				finalResponse.setStatus(false);
				finalResponse.setStatusCode("500");
				finalResponse.setMessage(" incorrect Otp");
				return finalResponse;
			}
		} else {
			finalResponse.setStatus(false);
			finalResponse.setStatusCode("404");
			finalResponse.setMessage("user does not exits with this mobileNumber");
			return finalResponse;
		}
	}
}





















