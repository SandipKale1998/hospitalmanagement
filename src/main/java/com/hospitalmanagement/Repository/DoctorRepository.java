package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Doctor;

public interface DoctorRepository {

	public List<Object[]> getDoctor();

	public List<Doctor> GetDoctorInfo();

	public Doctor InsertDoctor(Doctor doctor);

	public String DeleteDoctorByid(int doctor_id);

	public Object[] GetDoctorByid(int doctor_id);

	public Doctor UpdateDoctor(Doctor doctor);
	
}
