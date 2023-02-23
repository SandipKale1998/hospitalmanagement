package com.hospitalmanagement.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospiatlmangement.Service.AdminService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Admin;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminservice;

	@GetMapping("/getAdmin")
	public FinalResponse getAdminDetails() {
		return adminservice.getAdmin();
	}

	@PostMapping("/addAdmin")
	public FinalResponse addAdmin(@RequestBody @Valid Admin admin) {
		return adminservice.addAdmin(admin);

	}

	@DeleteMapping("/DeleteAdminbyid/{adminId}")
	public FinalResponse deletingAdminbyid(@PathVariable int adminId) {
		return adminservice.deleteAdminbyid(adminId);
	}

	@GetMapping("/DisplayAdminbyid/{adminId}")
	public FinalResponse GettingAdminDetails(@PathVariable int adminId) {
		return adminservice.GetAdminbyid(adminId);
	}

	@PutMapping("/updateAdmin")
	public FinalResponse Updattingpatientrecord(@RequestBody Admin admin) {
		return adminservice.UpdateAdmin(admin);
	}

	@PostMapping("/AdminLogin")
	public FinalResponse loginAdmin(@RequestBody Admin admin) {
		return adminservice.AdminLogin2(admin);
	}

	@GetMapping("/authenticate")
	public FinalResponse toVerifyToken(@RequestHeader("Authorization") String token, @RequestBody Admin admin) {
		return adminservice.validatingToken(token, admin);
	}

	@GetMapping("/loginbymobilenumber")
	public FinalResponse userLoginByMobileNumber(@RequestParam("contact_no") String mobileNumber,
			@RequestParam("password") String password) {
		return adminservice.adminLoginByMobileNumber(mobileNumber, password);
	}

	@GetMapping("/verificationOtp")
	public FinalResponse verificationOtp(@RequestParam("otp") int otp,
			@RequestParam("mobileNumber") String mobileNumber) {
		return adminservice.verificationotp(otp, mobileNumber);
	}

}

/*
 * public FinalResponse addAdmin(@RequestBody @Valid Admin
 * admin, @RequestHeader("Email") String email ) {
 * senderservice.sendEmail(email,"Insert Successfull","admin add successfully"
 * );
 */