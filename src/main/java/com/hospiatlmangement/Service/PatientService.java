package com.hospiatlmangement.Service;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Patient;

public interface PatientService {
	
    public FinalResponse GetAllpatientRecords();
	
    public FinalResponse InsertingOnePatientRecord(Patient patient);
    
    public FinalResponse deletingpatientrecord(int pid);
    
    public FinalResponse  GetOnepatientRecord(int pid);
	
    public FinalResponse Updatingpatientrecord(Patient patient);
    
    public Object[] getpatientrecordbyname(String pname);
}





















































































































































/*
	@Autowired
	PatientRepository patientrepository;
	
	// get data
	public List<PatientData> getAllpatient(){
		return patientrepository.findAll();
		
	}
	/// get data byid
	public PatientData getpatientbyid(int patientid) {
		return patientrepository.findById(patientid).get();
		
	}
	
	//number of records
	
	public List<PatientData> insertmultiplerecord(List<PatientData> patientdata){
		
		patientrepository.saveAll(patientdata);
		
		return patientdata;
		
	}
	
	// save data
	public void saveorupdate(PatientData patientdata)   
	{  
		patientrepository.save(patientdata); 
	}
	
	//deleting a specific record by using the method deleteById()  
		public void delete(int patientid)   
		{  
		patientrepository.deleteById(patientid);  
		} 
		*/
		 

