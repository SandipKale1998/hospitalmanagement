package com.hospitalmanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Nursing_staff;

@Repository
public class Nursing_staffImplementation implements Nursing_StaffRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public  List<Object[]> GetNursingStaff() {
		Query query = entityManager.createNativeQuery("Select * from Nursing_staff");
		List<Object[]> nursingstaff = query.getResultList();
		return nursingstaff;
	}

	@Transactional
	@Override
	public String DeleteNurseById(int nurse_id) {
		Query query = entityManager.createNativeQuery("Delete from Nursing_staff where nurse_id=?");
		query.setParameter(1, nurse_id);
		query.executeUpdate();
		return "patient was deleted";
	}

	@Transactional
	@Override
	public Nursing_staff addNurse(Nursing_staff nursingstaff) {
		Query query = entityManager.createNativeQuery("insert into Nursing_staff values(?,?,?,?,?,?,?,?,?)");
		query.setParameter(1, nursingstaff.getNurse_id());
		query.setParameter(2, nursingstaff.getNurse_name());
		query.setParameter(3, nursingstaff.getNurse_phoneno());
		query.setParameter(4, nursingstaff.getNurse_address());
		query.setParameter(5, nursingstaff.getNurse_role());
		query.setParameter(6, nursingstaff.getNurse_salary());
		query.setParameter(7, nursingstaff.getNurse_joiningdate());
		query.setParameter(8, nursingstaff.getNurse_resignDate());
		query.setParameter(9, nursingstaff.getStaff_id());
		query.executeUpdate();
		return nursingstaff;
	}

	@Override
	public Object[] GetNursebyid(int nurse_id) {
		Query query = entityManager.createNativeQuery("select * from Nursing_staff where nurse_id=?");
		query.setParameter(1, nurse_id);
		Object[] nurse = (Object[]) query.getSingleResult();
		return nurse;
	}

	@Transactional
	@Override
	public Nursing_staff UpdateNurse(Nursing_staff nurse) {
		Query query = entityManager.createNativeQuery(
				"update Nursing_staff set nurse_name=?,nurse_address=?,nurse_phoneno=?,nurse_role=?,nurse_salary=?, nurse_joiningdate=?,nurse_resignDate=?,staff_id=? where nurse_id=?");
		query.setParameter(1, nurse.getNurse_name());
		query.setParameter(2, nurse.getNurse_address());
		query.setParameter(3, nurse.getNurse_phoneno());
		query.setParameter(4, nurse.getNurse_role());
		query.setParameter(5, nurse.getNurse_salary());
		query.setParameter(6, nurse.getNurse_joiningdate());
		query.setParameter(7, nurse.getNurse_resignDate());
		query.setParameter(8, nurse.getStaff_id());
		query.setParameter(9, nurse.getNurse_id());
		query.executeUpdate();
		return nurse;
	}

}
