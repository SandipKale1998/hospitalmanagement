package com.hospitalmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.serviceImp.StaffServiceImplementation;
import com.hospitalmangement.bean.Staff;

@RestController
public class StaffController {
	
	@Autowired
	StaffServiceImplementation service;
	
	@GetMapping("/GetStaffInfo")
	public List<Staff> GetStaff() {
		return service.GetStaffInfo();	
	}

	@PostMapping("/AddStaff")
	public Staff addStaff(@RequestBody Staff staff) {
		return service.AddStaff(staff);
	}

	@DeleteMapping("/DeleteStaffByid/{staff_id}")
	public FinalResponse DeleteDepartment(@PathVariable int staff_id) {
		return service.deleteStaffbyid(staff_id);

	}

	@GetMapping("/GetStaffbyId/{staff_id}")
	public FinalResponse GetStaffByid(@PathVariable int staff_id) {
		return service.GetStaffbyid(staff_id);
	}

	@PutMapping("/updateDepartment")
	public Staff updateStaff(@RequestBody Staff staff) {
		service.UpdateStaff(staff);
		return staff;

	}
	
		
}
