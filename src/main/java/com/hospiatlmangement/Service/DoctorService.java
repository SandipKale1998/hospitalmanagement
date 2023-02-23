package com.hospiatlmangement.Service;

import java.util.List;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Doctor;

public interface DoctorService {
	
	public FinalResponse getDoctor();

	public List<Doctor> GetDoctorInfo();
	
	public FinalResponse AddDoctor(Doctor doctor);
	
	public FinalResponse deleteDoctorbyid(int doctor_id);

    public FinalResponse  GetDoctorbyid(int doctor_id);

    public FinalResponse UpdateDoctor(Doctor doctor);
    
}
