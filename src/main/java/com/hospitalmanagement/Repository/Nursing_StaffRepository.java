package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Nursing_staff;

public interface Nursing_StaffRepository {

	public  List<Object[]> GetNursingStaff();

	public String DeleteNurseById(int nurse_id);

	public Nursing_staff addNurse(Nursing_staff nursingstaff);

	public Object[] GetNursebyid(int nurse_id);

	public Nursing_staff UpdateNurse(Nursing_staff nurse);
}
