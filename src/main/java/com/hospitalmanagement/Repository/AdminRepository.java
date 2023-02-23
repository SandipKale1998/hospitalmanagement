package com.hospitalmanagement.Repository;

import java.util.Date;
import java.util.List;

import com.hospitalmangement.bean.Admin;

public interface AdminRepository {

	public List<Object[]> GetAdmin();

	public String InsertAdmin(Admin admin);

	public String DeleteAdminByid(int adminId);

	public List<Object[]> GetAdminByid(int adminId);

	public Object Login1(String password);

	public Admin UpdateAdmin(Admin admin);

	public Admin GetAdminBy(int adminId);

	public List<Object> checkUsersName();

	public List<Object> checkUsersPassword();

	// login by mobile number
	public Admin adminLoginByMobileNumber(String mobileNumber, String password);

	public String checkadminIsPresentByMobileNumber(String mobileNumber);

	public List<String> getAllmobile();

	public String UpdateOtp(int otp, Date OtpDate, String mobileNumber);

	public int checkotp(String mobileNumber);

	public String verficationotp(int otp, String mobileNumber);

	public Date toGetDBOtpTime(String mobileNo);
	
	public Object Login(String userName, String password);
}

























