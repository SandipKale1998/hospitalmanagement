package com.hospiatlmangement.Service;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Admin;

public interface AdminService {

	public FinalResponse getAdmin();

	public FinalResponse addAdmin(Admin admin);

	public FinalResponse deleteAdminbyid(int adminId);

	public FinalResponse GetAdminbyid(int adminId);

	public FinalResponse AdminLogin2(Admin admin);

	public FinalResponse UpdateAdmin(Admin admin);

	public FinalResponse validatingToken(String token, Admin admin);

	public FinalResponse AdminLogin(Admin login);

	public FinalResponse adminLoginByMobileNumber(String mobileNumber, String password);

	public FinalResponse verificationotp(int otp, String mobileNumber);
}
