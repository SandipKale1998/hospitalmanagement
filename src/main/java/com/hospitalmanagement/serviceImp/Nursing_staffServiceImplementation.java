package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.Nursing_staffService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.Nursing_StaffRepository;
import com.hospitalmangement.bean.Nursing_staff;

@Service
public class Nursing_staffServiceImplementation implements Nursing_staffService {
	
	Logger logger = LoggerFactory.getLogger(Nursing_staffServiceImplementation.class);
	
	@Autowired
	private Nursing_StaffRepository NurseRespository;

	@Override
	public FinalResponse GetNursingStaff() {
		List<Object[]> nurse_staff = null;
		FinalResponse finalResponse = new FinalResponse();
		logger.info("getdoctor :: input ::");
		try {
			nurse_staff = NurseRespository.GetNursingStaff();
			if (nurse_staff != null) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage("Record Present");
				finalResponse.setData(nurse_staff);
			}
		} catch (InputMismatchException e) {
			logger.info("getdoctor :: input ::" + e.getMessage());
		}
		return finalResponse;
	}

	@Override
	public FinalResponse DeleteNurseByid(int nurse_id) {
		FinalResponse finalResponce = new FinalResponse();
		logger.info("deletenursebyid :: input :: nurse_id"+nurse_id);
		try {
		NurseRespository.DeleteNurseById(nurse_id);
		if (nurse_id > 0) {
			finalResponce.setStatus(true);
			finalResponce.setStatusCode("200");
			finalResponce.setMessage(nurse_id + "th Record was deleted");
		  }
		}catch(InputMismatchException e) {
			logger.info("deletenursebyid :: input :: nurse_id "+nurse_id+e.getMessage());    
		  } 
		return finalResponce;
	}

	@Override
	public FinalResponse AddNurse(Nursing_staff nurse) {
		FinalResponse finalresponse = new FinalResponse();
        logger.info("addnurse :: input :: nurse :"+nurse);
		try {
		NurseRespository.addNurse(nurse);
		if (nurse != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("One Record was Inserted");
			return finalresponse;
		} 
		}catch(InputMismatchException e) {
			logger.info("addnurse :: input :: nurse :"+nurse+e.getMessage());
		}return finalresponse;
	}

	@Override
	public FinalResponse GetNursebyid(int nurse_id) {
		Object[] nurse=null;
		FinalResponse finalresponse = new FinalResponse();
		logger.info("getnursebyid :: input :: nurse_id"+nurse_id);
		try {
		nurse= NurseRespository.GetNursebyid(nurse_id);
		if (nurse != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record Present");
			finalresponse.setData(nurse);
		} }catch(InputMismatchException e) {
			logger.info("getnursebyid :: input :: nurse_id"+nurse_id+e.getMessage());
		}
		return finalresponse; 
	}

	@Override
	public FinalResponse UpdateNurse(Nursing_staff nursingdtaff) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingNurseRecord:: input :: nurse:" + nursingdtaff);
		System.out.println(nursingdtaff.getNurse_name());
		try {
			NurseRespository.UpdateNurse(nursingdtaff);
			if (nursingdtaff != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingdoctorRecord:: input :: nurse:" + ex.getMessage());
		}
		return finalresponce;
	}

}
