package com.hospitalmanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Doctor;

@Repository
public class DoctorRepositoryImplementation implements DoctorRepository {

	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<Object[]> getDoctor() {
		
		Query query=entityManager.createNativeQuery("select * from doctor");
		List<Object[]> doctor=query.getResultList();
		return doctor;
	}


	@Override
	public List<Doctor> GetDoctorInfo() {
		Query query=entityManager.createNativeQuery("select * from doctor");
		List<Doctor> doctor=query.getResultList();
		return doctor;
	}

    @Transactional
	@Override
	public Doctor InsertDoctor(Doctor doctor) {
		Query query = entityManager.createNativeQuery("insert into doctor values(?,?,?,?,?,?,?)");
		query.setParameter(1,doctor.getDoctor_id());
		query.setParameter(2,doctor.getDoctor_name());
		query.setParameter(3,doctor.getDoctor_phnumber());
		query.setParameter(4,doctor.getDoctor_specialization());
		query.setParameter(5,doctor.getDoctor_joiningdate());
		query.setParameter(6,doctor.getDoctor_resign());
		query.setParameter(7,doctor.getStaff_id());
		query.executeUpdate();
		return doctor;
	}

    @Transactional
	@Override
	public String DeleteDoctorByid(int doctor_id) {
		Query query=entityManager.createNativeQuery("delete from Doctor where doctor_id=?");
		query.setParameter(1, doctor_id);
		int rec=query.executeUpdate();
		if(rec > 0) {
			return " one Patient record was deleted";
		}else {
			return "Patient record was not found";
		}
	}


	@Override
	public Object[] GetDoctorByid(int doctor_id) {
		Query query = entityManager.createNativeQuery("select * from Doctor where doctor_id=?");
        query.setParameter(1,doctor_id);
        Object[] doctor=(Object[])query.getSingleResult();
        return doctor;
		
	}

      @Transactional
	@Override
	public Doctor UpdateDoctor(Doctor doctor) {
		Query query=
				  entityManager.createNativeQuery("update Doctor set doctor_name=?,doctor_phnumber=?,doctor_specialization=?,doctor_joiningdate=?,doctor_resign=?, staff_id=? where doctor_id=?");
					query.setParameter(1, doctor.getDoctor_name());
					query.setParameter(2, doctor.getDoctor_phnumber());
					query.setParameter(3, doctor.getDoctor_specialization());
					query.setParameter(4, doctor.getDoctor_joiningdate());
					query.setParameter(5, doctor.getDoctor_resign());
					query.setParameter(6, doctor.getStaff_id());
					query.setParameter(7, doctor.getDoctor_id());
				      int record=query.executeUpdate();
				      if(record > 0) {
				    	  return doctor;
				      }
				    	return doctor;  
	}

}
