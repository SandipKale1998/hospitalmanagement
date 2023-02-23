package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.StaffService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.StaffRepository;
import com.hospitalmangement.bean.Staff;

@Service
public class StaffServiceImplementation implements StaffService {

	Logger logger = LoggerFactory.getLogger(StaffServiceImplementation.class);
	
	@Autowired
	StaffRepository repository;

	@Override
	public List<Staff> GetStaffInfo() {
		return repository.GetStaff();
	}

	@Override
	public Staff AddStaff(Staff staff) {

		return repository.InsertStaff(staff);
	}

	@Override
	public FinalResponse deleteStaffbyid(int staff_id) {
		FinalResponse finalResponse = new FinalResponse();
		logger.info("deleteStaffbyid :: input :: staff_id:"+staff_id);
		try {
		repository.DeleteStaffByid(staff_id);
		if (staff_id > 0) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage(staff_id + "th Record was deleted");
			return finalResponse;
		} }catch(InputMismatchException e) {
		logger.info("deleteStaffbyid :: input :: staff_id:"+e.getMessage());
		}return finalResponse;
	}

	@Override
	public FinalResponse GetStaffbyid(int staff_id) {
		Object[] staff = repository.GetStaffByid(staff_id);
		FinalResponse finalresponse = new FinalResponse();
		if (staff != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record Present");
			return finalresponse;
		} else {
			finalresponse.setStatus(false);
			finalresponse.setStatusCode("501");
			finalresponse.setErrorMessages("Record Not Present");
			return finalresponse;
		}
	}

	@Override
	public Staff UpdateStaff(Staff staff) {
		return repository.UpdateStaff(staff);

	}

}
