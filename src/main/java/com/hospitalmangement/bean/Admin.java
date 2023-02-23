package com.hospitalmangement.bean;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Admin {
	
	private int adminId;
	@NotEmpty(message = "firstname should not blank")
	private String firstName;
	@NotEmpty(message = "lastname should not blank ")
	private String lastName;
	@NotEmpty
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Invalid mobile number entered, please enter 10 Dig Mobile No")
	private String contactNo;
	private String city;
	@NotBlank
	@Size(max = 50)
	private String username;
	private int otp;
	@NotBlank
	@Size(max = 30)
	private String password;
	private Date Otp_expirytime;

	public Date getOtp_expirytime() {
		return Otp_expirytime;
	}

	public void setOtp_expirytime(Date otp_expirytime) {
		Otp_expirytime = otp_expirytime;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
