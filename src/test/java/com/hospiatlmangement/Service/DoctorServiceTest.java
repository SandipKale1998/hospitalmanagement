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
import com.hospitalmanagement.serviceImp.DoctorServiceimplementation;
import com.hospitalmangement.bean.Doctor;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {
	  
	 @Mock
	 DoctorServiceimplementation doctorservice;
	
	
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
			FinalResponse actual = doctorservice.getDoctor();
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

			when(doctorservice.AddDoctor(any(Doctor.class))).thenReturn(expected);

			FinalResponse actual = doctorservice.AddDoctor(doctor);

			assertEquals(expected, actual);

		}
		
		@Test
		@DisplayName("Delete the doctor ")
		public void testDeleteDoctor() {
			Doctor doctor = new Doctor();
			doctor.setDoctor_id(1);;
			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("Ok");
			expected.setMessage("Record deleted");

			when(doctorservice.deleteDoctorbyid(anyInt())).thenReturn(expected);
			FinalResponse actual = doctorservice.deleteDoctorbyid(anyInt());
			assertEquals(expected, actual);
		}
		@Test
		@DisplayName("Find doctor by id")
		public void testDoctorgetById() {
			Object[] doctor = { 2 ,"akshay" ,"9862638373" ,"Ortho" , 1 ,"2022-09-02" , "2016-12-27" };

			FinalResponse expected = new FinalResponse();
			expected.setStatus(true);
			expected.setStatusCode("Ok");
			expected.setMessage("Record present");
			expected.setData(doctor);

			when(doctorservice.GetDoctorbyid(anyInt())).thenReturn(expected);
			FinalResponse actual = doctorservice.GetDoctorbyid(anyInt());
			assertEquals(expected, actual);
		}

		
		@Test
	    @DisplayName("update the doctor")
	    public void testUpdateDoctor() {
	            Doctor doctor = new Doctor();
	            doctor.setDoctor_name("akshay");
	            doctor.setDoctor_id(1);;
	            
	            
	            FinalResponse expected = new FinalResponse();
	            expected.setStatus(true);
	            expected.setStatusCode("Ok");
	            expected.setMessage("Record updated");
	            expected.setData(doctor);
	            when(doctorservice.UpdateDoctor(doctor)).thenReturn(expected);
	            FinalResponse actual = doctorservice.UpdateDoctor(doctor);
	            assertEquals(expected, actual);
	 }
}
