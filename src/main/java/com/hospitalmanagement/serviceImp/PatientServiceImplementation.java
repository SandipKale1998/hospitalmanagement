package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.PatientService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.PatientRepository;
import com.hospitalmangement.bean.Patient;

@Service
public class PatientServiceImplementation implements PatientService {
	Logger logger = LoggerFactory.getLogger(PatientServiceImplementation.class);

	@Autowired
	private PatientRepository repository;

	@Override
	public FinalResponse GetAllpatientRecords() {
      FinalResponse finalresponse=new FinalResponse();
      List<Object[]> patientDetails=null;
      logger.info("getpatient :: input ::");
		try {
			patientDetails = repository.GetAllpatientRecords();
			if (patientDetails != null) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("Record Present");
				finalresponse.setData(patientDetails);
			}
		} catch (InputMismatchException e) {
			logger.info("getpatient :: input ::" + e.getMessage());
		}
		return finalresponse;
	}


	public PatientServiceImplementation(PatientRepository repository) {
		this.repository = repository;
	}

	@Override
	public FinalResponse InsertingOnePatientRecord(Patient patient) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("InsertingOnePatientRecord:: input :: patient:" + patient);
		System.out.println(patient.getPname());
		try {
			repository.InsertingOnePatientRecord(patient);
			if (patient != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("One Record was Inserted");
			}
		} catch (Exception ex) {
			logger.error("InsertingOnePatientRecord:: input :: patient:" + ex.getMessage());
		}
		return finalresponce;
	}

	@Override
	public FinalResponse deletingpatientrecord(int pid) {
		FinalResponse finalResponce = new FinalResponse();
		logger.info("deletingpatientrecord:: input :: patient");
		try {
			repository.deletingpatientrecordbyid(pid);
			if (pid > 0) {
				finalResponce.setStatus(true);
				finalResponce.setStatusCode("200");
				finalResponce.setMessage("One Record was deleted");
			}
		} catch (InputMismatchException e) {
			logger.info("deletedngpatientrecord:: input :: patient:" +e.getMessage());
		}
		return finalResponce;
	}

	@Override
	public FinalResponse GetOnepatientRecord(int pid) {
		FinalResponse finalresponse = new FinalResponse();
		Object[] patient =null;
		logger.info("GetPatientByid"+patient);
        try {
		patient = repository.GetOnepatientRecord(pid);
		if (patient != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record Present");
			
			
		}
		}catch(InputMismatchException ex) {
	    logger.info("get patient"+patient+ex.getMessage());
		}
        return finalresponse;
   }

	@Override
	public FinalResponse Updatingpatientrecord(Patient patient) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingPatientRecord:: input :: patient:" + patient);
		System.out.println(patient.getPname());
		try {
			repository.Updatingpatientrecord(patient);
			if (patient != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingPatientRecord:: input :: patient:" + ex.getMessage());
		}
		return finalresponce;
	}

	@Override
	public Object[] getpatientrecordbyname(String pname) {
		return repository.getpatientrecordbyname(pname);
	}

}
