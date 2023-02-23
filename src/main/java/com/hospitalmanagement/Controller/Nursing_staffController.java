package com.hospitalmanagement.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospiatlmangement.Service.Nursing_staffService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Nursing_staff;


@RestController
public class Nursing_staffController {

	@Autowired
	private Nursing_staffService Nursingservice;

	@GetMapping("/GetNusrsingStaff")
	public FinalResponse GetNursingStaff() {
		return Nursingservice.GetNursingStaff();
	}

	@DeleteMapping("/deleteNurseByid/{nurse_id}")
	public FinalResponse DeleteNurseByid(@PathVariable int nurse_id) {
		return Nursingservice.DeleteNurseByid(nurse_id);
	}

	@PostMapping("/addNurse")
	public FinalResponse AddNurse(@RequestBody @Valid Nursing_staff nurse) {
		return Nursingservice.AddNurse(nurse);

	}

	@GetMapping("/GetNursebyid/{nurse_id}")
	public FinalResponse GetNurse(@PathVariable int nurse_id) {
		return Nursingservice.GetNursebyid(nurse_id);
	}

	@PutMapping("/updateNurse")
	public FinalResponse UpdateNurse(@RequestBody @Valid Nursing_staff nurse) {
	 return	Nursingservice.UpdateNurse(nurse);
	}
}
