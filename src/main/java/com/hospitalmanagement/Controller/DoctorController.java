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

import com.hospiatlmangement.Service.DoctorService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Doctor;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService service;
	
	@GetMapping("/getDoctor")
	public FinalResponse getDoctors() {
		return service.getDoctor();
		
	}
	
	@GetMapping("/GetDoctorInfo")
	public List<Doctor> getDoctersDetails(){
		return service.GetDoctorInfo();
	}
	
	@PostMapping("/AddDoctor")
	public FinalResponse addDoctors(@RequestBody Doctor doctor) {
	 return service.AddDoctor(doctor);

	}
	@DeleteMapping("/DeleteDoctorbyid/{doctor_id}")
	public FinalResponse deletingDoctorbyid(@PathVariable int doctor_id) {
		return service.deleteDoctorbyid(doctor_id);
	}
	
	 @GetMapping("/DisplayDoctorbyid/{doctor_id}")
	    public FinalResponse GettingpatientDetails(@PathVariable int doctor_id) {
	        return service.GetDoctorbyid(doctor_id);
	    }
	 
	 @PutMapping("/updateDoctor")
	 public FinalResponse Updattingpatientrecord(@RequestBody Doctor doctor) {
		return service.UpdateDoctor(doctor);
		
	 }
}
