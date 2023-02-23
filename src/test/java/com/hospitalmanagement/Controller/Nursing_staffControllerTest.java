package com.hospitalmanagement.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hospiatlmangement.Service.Nursing_staffService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Nursing_staff;

@ExtendWith(MockitoExtension.class)
class Nursing_staffControllerTest {

	@InjectMocks
	private Nursing_staffController nurseController;
	
	@Mock
	private Nursing_staffService nurseservice;
	
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
		FinalResponse actual = nurseController.GetNursingStaff();
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

		FinalResponse actual = nurseController.AddNurse(nurse);

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("Delete the nurse object to databse")
	public void testDeleteNurseController() {
		Nursing_staff nurse = new Nursing_staff();
		nurse.setNurse_id(1);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");

		when(nurseservice.DeleteNurseByid(anyInt())).thenReturn(expected);
		FinalResponse actual = nurseController.DeleteNurseByid(anyInt());
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("Find Nurse by id")
	public void testNursegetByIdController() {
		
		Object[] nurse = {1,"suman","927362832","rajnagar","unit_manager","50000","2020-09-28","0000-00-00",2};

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(nurse);

		when(nurseservice.GetNursebyid(anyInt())).thenReturn(expected);
		FinalResponse actual = nurseController.GetNurse(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the Nursing_staff object in databse")
    public void testUpdateNurseController() {
            Nursing_staff nurse = new Nursing_staff();
            nurse.setNurse_name("darshana");;
            nurse.setNurse_id(2);
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            expected.setData(nurse);
            
            when(nurseservice.UpdateNurse(nurse)).thenReturn(expected);
            FinalResponse actual = nurseController.UpdateNurse(nurse);
            assertEquals(expected, actual);
    }
		
}
