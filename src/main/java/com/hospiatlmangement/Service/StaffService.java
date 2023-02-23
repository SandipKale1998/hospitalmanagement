package com.hospiatlmangement.Service;

import java.util.List;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Staff;

public interface StaffService {

	public List<Staff> GetStaffInfo();
	
	public Staff AddStaff(Staff staff);
	
	public FinalResponse deleteStaffbyid(int staff_id);

    public FinalResponse  GetStaffbyid(int staff_id);

    public Staff UpdateStaff(Staff staff);
}
