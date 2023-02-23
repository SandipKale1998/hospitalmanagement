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

import com.hospiatlmangement.Service.PatientService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Patient;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

	@InjectMocks
	private PatientController patientcontroller;

	@Mock
	private PatientService patientservice;

	
	
	@Test
	public void TestGetpatient() {
		List<Object[]> patients=new ArrayList<>();
		
		Object[] patient1 = { 1, "sandip", "pune", 27, "male", 817623833, "fever" };
		Object[] patient2 = { 2, "akshay", "hyd", 26, "male", 817623833, "fever" };
	
		patients.add(patient1);
		patients.add(patient2);
		
		FinalResponse expected=new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(patients);
		  when(patientservice.GetAllpatientRecords()).thenReturn(expected);
	        FinalResponse actual = patientcontroller.GettingAllpatientDetails();
	        assertEquals(expected, actual);
	    }
	
	
	@Test
	public void TestPatientInsertedRecord() {
		Patient patient = new Patient();
		patient.setPid(21);
		patient.setPname("chahal");
		patient.setPaddress("pune");
		patient.setPgender("male");
		patient.setPage(27);
		patient.setP_disease("fever");
		patient.setPphoneno(797683237);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");
      
		expected.setData(patient);
		
		when(patientservice.InsertingOnePatientRecord(any(Patient.class))).thenReturn(expected);

		FinalResponse actual = patientcontroller.AddPatient(patient);

		assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Find patient by id")
	public void testPatientgetByIdController() {
		Object[] patient = { 1, "sandip", "hyd", 26, "male", 817623833, "fever" };

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(patient);

		when(patientservice.GetOnepatientRecord(anyInt())).thenReturn(expected);
		FinalResponse actual = patientcontroller.GettingpatientDetails(anyInt());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Delete the Patient object to databse")
	public void testDeletePatientController() {
		Patient patient = new Patient();
		patient.setPid(7);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");
		expected.setData(patient);
		
		when(patientservice.deletingpatientrecord(anyInt())).thenReturn(expected);
		FinalResponse actual = patientcontroller.deletingpatientbyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the patient object in databse")
    public void testUpdatePatientController() {
            Patient patient = new Patient();
            patient.setPname("Akshay");
            patient.setPid(2);
                   
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            
            when(patientservice.Updatingpatientrecord(patient)).thenReturn(expected);
            FinalResponse actual = patientcontroller.Updattingpatientrecord(patient);
            assertEquals(expected, actual);
    }
}





















/*
 * @Test
 * 
 * @DisplayName("save Patient Info") public void Insertpatient() { Patient
 * patient1 = new Patient(); patient1.setPid(21); patient1.setPname("chahal");
 * patient1.setPaddress("pune"); patient1.setPgender("male");
 * patient1.setPage(27); patient1.setP_disease("fever");
 * patient1.setPphoneno(797683237);
 * 
 * FinalResponse actual = patientcontroller.AddPatient(patient1); FinalResponse
 * expected=new FinalResponse(); expected.setStatus(HttpStatus.OK);
 * expected.setStatusCode("200"); expected.setMessage("insert sucessfully"); //
 * assertEquals(expected,actual); assertNotEquals(actual, expected); }
 */
