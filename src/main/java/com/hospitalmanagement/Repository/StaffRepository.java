package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Staff;

public interface StaffRepository {

	public List<Staff> GetStaff();
  
	public Staff InsertStaff(Staff staff);
	
	 public String DeleteStaffByid(int staff_id);
	 
	 public Object[] GetStaffByid(int staff_id);
	
	 public Staff UpdateStaff(Staff staff);
}
