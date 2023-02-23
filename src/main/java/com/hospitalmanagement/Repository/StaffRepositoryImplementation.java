package com.hospitalmanagement.Repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hospitalmangement.bean.Staff;

@Repository
public class StaffRepositoryImplementation implements StaffRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Staff> GetStaff() {
		Query query = entityManager.createNativeQuery("select * from staff");
		List<Staff> staff = query.getResultList();
		return staff;
	}

	@Transactional
	@Override
	public Staff InsertStaff(Staff staff) {
		Query query = entityManager.createNativeQuery("insert into staff values(?,?)");
		query.setParameter(1, staff.getStaff_id());
		query.setParameter(2, staff.getDepartment_name());
		query.executeUpdate();
		return staff;
	}

	@Transactional
	@Override
	public String DeleteStaffByid(int staff_id) {
		Query query = entityManager.createNativeQuery("delete from staff where staff=?");
		query.setParameter(1, staff_id);
		int rec = query.executeUpdate();
		if (rec > 0) {
			return " one staff record was deleted";
		} else {
			return "staff record was not found";
		}
	}

	@Override
	public Object[] GetStaffByid(int staff_id) {
		Query query = entityManager.createNativeQuery("select * from staff where staff_id=?");
		query.setParameter(1, staff_id);
		Object[] staff = (Object[]) query.getSingleResult();
		return staff;
	}

	@Transactional
	@Override
	public Staff UpdateStaff(Staff staff) {
		Query query = entityManager.createNativeQuery("update Staff set department_name=? where staff_id=?");
		query.setParameter(1, staff.getDepartment_name());
		query.setParameter(2, staff.getStaff_id());
		int record = query.executeUpdate();
		if (record > 0) {
			return staff;
		}
		return staff;
	}

	
	/*

	@Transactional
	@Override
	public String DeleteStaffByid(int staff_id) {
		Query query = entityManager.createNativeQuery("delete from Department where department_id=?");
		query.setParameter(1, staff_id);
		int rec = query.executeUpdate();
		if (rec > 0) {
			return " one Patient record was deleted";
		} else {
			return "Patient record was not found";
		}
	}

	@Override
	public Object[] GetStaffByid(int staff_id) {
		Query query = entityManager.createNativeQuery("select * from Department where department_id=?");
		query.setParameter(1, department_id);
		Object[] department = (Object[]) query.getSingleResult();
		return department;
	}

	@Transactional
	@Override
	public Staff UpdateDepartment(Staff department) {
		Query query = entityManager.createNativeQuery("update department set department_name=? where department_id=?");
		query.setParameter(1, department.getDepartment_name());
		query.setParameter(2, department.getDepartment_id());
		int record = query.executeUpdate();
		if (record > 0) {
			return department;
		}
		return department;
	}
	*/
	
}