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

import com.hospiatlmangement.Service.DoctorService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Doctor;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {
	
	@InjectMocks
	DoctorController doctorcontroller;

	@Mock
	DoctorService doctorservice;
   
	@Test
	public void TestGetDoctor() {
		List<Object[]> doctors = new ArrayList<>();
		Object[] doctor1 = { 1 ,"anil" ,"9862638373" ,"Orthopedics" , 1 ,"2020-09-02" , "2016-12-27"};
		Object[] doctor2 = { 2 ,"akshay" ,"9862638373" ,"Ortho" , 1 ,"2022-09-02" , "2016-12-27"};
		doctors.add(doctor1);
		doctors.add(doctor2);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(doctors);
		when(doctorservice.getDoctor()).thenReturn(expected);
		FinalResponse actual = doctorcontroller.getDoctors();
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestInsertedDoctor() {
		Doctor doctor = new Doctor();
		doctor.setDoctor_id(1);
		doctor.setDoctor_name("akshay");
		doctor.setDoctor_phnumber("914576952");
		doctor.setDoctor_joiningdate(null);
		doctor.setDoctor_resign(null);
		doctor.setStaff_id_id(1);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		expected.setData(doctor);
		when(doctorservice.AddDoctor(any(Doctor.class))).thenReturn(expected);

		FinalResponse actual = doctorcontroller.addDoctors(doctor);

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("Delete the doctor object to databse")
	public void testDeleteDoctorController() {
		Doctor doctor = new Doctor();
		doctor.setDoctor_id(1);;
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");
		expected.setData(doctor);
		
		when(doctorservice.deleteDoctorbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = doctorcontroller.deletingDoctorbyid(anyInt());
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName("Find doctor by id")
	public void testDoctorgetByIdController() {
		Object[] doctor = { 2 ,"akshay" ,"9862638373" ,"Ortho" , 1 ,"2022-09-02" , "2016-12-27" };

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(doctor);

		when(doctorservice.GetDoctorbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = doctorcontroller.GettingpatientDetails(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the doctor object in databse")
    public void testUpdateDoctorController() {
            Doctor doctor = new Doctor();
            doctor.setDoctor_name("akshay");
            doctor.setDoctor_id(1);;
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            expected.setData(doctor);
            when(doctorservice.UpdateDoctor(doctor)).thenReturn(expected);
            FinalResponse actual = doctorcontroller.Updattingpatientrecord(doctor);
            assertEquals(expected, actual);
    }
}

