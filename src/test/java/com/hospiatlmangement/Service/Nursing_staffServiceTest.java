package com.hospiatlmangement.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.serviceImp.Nursing_staffServiceImplementation;
import com.hospitalmangement.bean.Nursing_staff;

@ExtendWith(MockitoExtension.class)
class Nursing_staffServiceTest {

	@Mock
	Nursing_staffServiceImplementation nurseservice;

	
	@Test
	public void TestGetNursing_staff() {
		List<Object[]> Nurse_staff = new ArrayList<>();
		Object[] nurse1 = { 1,"suman","827362832","sainagar","unit_manager","50000","2020-09-28","0000-00-00",2};
		Object[] nurse2 = {2,"suman","927362832","rajnagar","unit_manager","50000","2020-09-28","0000-00-00",2};
		Nurse_staff.add(nurse1);
		Nurse_staff.add(nurse2);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(Nurse_staff);
		when(nurseservice.GetNursingStaff()).thenReturn(expected);
		FinalResponse actual = nurseservice.GetNursingStaff();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestInsertedNurse_staff() {
		Nursing_staff nurse = new Nursing_staff();
		nurse.setNurse_id(1);;
		nurse.setNurse_name("suman");;
		nurse.setNurse_phoneno("9156872583");;
		nurse.setNurse_role("manager");
		nurse.setNurse_salary("30000");;
		nurse.setNurse_address("pune");
		nurse.setNurse_joiningdate(null);
		nurse.setNurse_resignDate("2022-02-07");
		nurse.setStaff_id(2);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		expected.setData(nurse);
		
		when(nurseservice.AddNurse(any(Nursing_staff.class))).thenReturn(expected);

		FinalResponse actual = nurseservice.AddNurse(nurse);

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("Delete the nurse")
	public void testDeleteNurseController() {
		Nursing_staff nurse = new Nursing_staff();
		nurse.setNurse_id(1);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");

		when(nurseservice.DeleteNurseByid(anyInt())).thenReturn(expected);
		FinalResponse actual = nurseservice.DeleteNurseByid(anyInt());
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("Find Nurse by id")
	public void testNursegetById() {
		
		Object[] nurse = {1,"suman","927362832","rajnagar","unit_manager","50000","2020-09-28","0000-00-00",2};

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(nurse);

		when(nurseservice.GetNursebyid(anyInt())).thenReturn(expected);
		FinalResponse actual = nurseservice.GetNursebyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the Nursing_staff ")
    public void testUpdateNurse() {
            Nursing_staff nurse = new Nursing_staff();
            nurse.setNurse_name("darshana");;
            nurse.setNurse_id(2);
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            
            when(nurseservice.UpdateNurse(nurse)).thenReturn(expected);
            FinalResponse actual = nurseservice.UpdateNurse(nurse);
            assertEquals(expected, actual);
    }

}
