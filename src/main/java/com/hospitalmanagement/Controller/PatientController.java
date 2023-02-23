package com.hospitalmanagement.Controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospiatlmangement.Service.PatientService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Patient;

//@Controller
@RestController
public class PatientController {

	 Logger logger = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	 private PatientService patientservice;
	
	
	 @GetMapping("/DispayAllPatientData")
	public FinalResponse GettingAllpatientDetails() {
	 return patientservice.GetAllpatientRecords();
	}
	
	@PostMapping("/addpatient")
	public FinalResponse AddPatient(@RequestBody @Valid Patient patient) {
		logger.info("patient inserted successfuly"+patient);
		return patientservice.InsertingOnePatientRecord(patient);	
	}
	
	@DeleteMapping("/DeletePatientbyid/{pid}")
	public FinalResponse deletingpatientbyid(@PathVariable int pid) {
		return patientservice.deletingpatientrecord(pid);
	}
	
	 @GetMapping("/DisplayPatientbyid/{pid}")
	    public FinalResponse GettingpatientDetails(@PathVariable int pid) {
	        return patientservice.GetOnepatientRecord(pid);
	    }
	 
	 @PutMapping("/updatePatientrecord")
	 public FinalResponse Updattingpatientrecord(@RequestBody @Valid Patient patient) {
		 return patientservice.Updatingpatientrecord(patient);
	 
	 }
	 @GetMapping("/getpatientbyname/{pname}")
	 public Object[] getpatientbyname(@PathVariable String pname) {
		 return patientservice.getpatientrecordbyname(pname);
		 
	 }
	 
}





























/*
 * @GetMapping("/getpatient/{pid}") public List<patient>
 * getpatientbyid(@PathVariable int pid) { return
 * patientservice.getpatientbyid(pid); }
 */

/*
 * @Autowired
 * 
 * PatientService patientservice;
 * 
 * //get all record
 * 
 * @GetMapping("/patientinfo") private List<PatientData> getAllpatient(){ return
 * patientservice.getAllpatient(); }
 * 
 * //get record byid
 * 
 * @GetMapping("/patientinfo/{patientid}") private PatientData
 * getpatient(@PathVariable("patientid") int patientid) { return
 * patientservice.getpatientbyid(patientid); }
 * 
 * // inserting data
 * 
 * @PostMapping("/addpatient") private PatientData savePatient(@RequestBody
 * PatientData patientdata) { patientservice.saveorupdate(patientdata); return
 * patientdata; }
 * 
 * 
 * // delete patieint by patientid
 * 
 * @DeleteMapping("/deletepatient/{patientid}") public void
 * deletepatient(@PathVariable("patientid") int patientid) {
 * patientservice.delete(patientid); }
 * 
 * // update
 * 
 * @PutMapping("/updatepatient") private PatientData update(@RequestBody
 * PatientData patientdata) {
 * 
 * patientservice.saveorupdate(patientdata); return patientdata;
 * 
 * }
 * 
 * //
 * 
 * @PostMapping("/insertrecords") public void addmulitiplerecord(@RequestBody
 * List<PatientData> patientdata) {
 * patientservice.insertmultiplerecord(patientdata); }
 * 
 */
