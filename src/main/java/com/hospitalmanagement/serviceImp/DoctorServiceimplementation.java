package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.DoctorService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.DoctorRepository;
import com.hospitalmangement.bean.Doctor;

@Service
public class DoctorServiceimplementation implements DoctorService {

	Logger logger = LoggerFactory.getLogger(DoctorServiceimplementation.class);

	@Autowired
	DoctorRepository repository;

	@Override
	public FinalResponse getDoctor() {
		List<Object[]> doctordetails = null;
		FinalResponse finalResponse = new FinalResponse();
		logger.info("getdoctor :: input ::");
		try {
			doctordetails = repository.getDoctor();
			if (doctordetails != null) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage("Record Present");
				finalResponse.setData(doctordetails);
			}
		} catch (InputMismatchException e) {
			logger.info("getdoctor :: input ::" + e.getMessage());
		}
		return finalResponse;
	}

	@Override
	public List<Doctor> GetDoctorInfo() {
		return repository.GetDoctorInfo();
	}

	@Override
	public FinalResponse AddDoctor(Doctor doctor) {
		FinalResponse finalresponse = new FinalResponse();
		logger.info("InsertingOneDoctorRecord:: input :: doctor:" + doctor);
		try {
			repository.InsertDoctor(doctor);
			if (doctor != null) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("One Record was Inserted");
			}
		} catch (Exception ex) {
			logger.error("Not InsertingOneDoctorRecord:: input :: doctor:" + ex.getMessage());
		}
		return finalresponse;
	}

	@Override
	public FinalResponse deleteDoctorbyid(int doctor_id) {
		FinalResponse finalResponse = new FinalResponse();
		logger.info("deletedoctorbyid :: input :: doctor_id" + doctor_id);
		try {
			repository.DeleteDoctorByid(doctor_id);
			if (doctor_id > 0) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage(doctor_id + "th Record was deleted");
			}
		} catch (InputMismatchException e) {
			logger.info("deletedoctorbyid :: input :: doctor_id" + doctor_id + e.getMessage());
		}
		return finalResponse;
	}

	@Override
	public FinalResponse GetDoctorbyid(int doctor_id) {
		FinalResponse finalresponse = new FinalResponse();
		logger.info("getdoctorbyid :: input :: doctor_id:" + doctor_id);
		try {
		Object[] doctor = repository.GetDoctorByid(doctor_id);
			if (doctor != null) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("Record Present");
				finalresponse.setData(doctor);
				
			}
		} catch (InputMismatchException e) {
			logger.info("getdoctorbyid :: input :: doctor_id:" + doctor_id + e.getMessage());
		}
		return finalresponse;
	}

	@Override
	public FinalResponse UpdateDoctor(Doctor doctor) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingdoctorRecord:: input :: doctor:" + doctor);
		System.out.println(doctor.getDoctor_name());
		try {
			repository.UpdateDoctor(doctor);
			if (doctor != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingdoctorRecord:: input :: doctor:" + ex.getMessage());
		}
		return finalresponce;
	}
}
