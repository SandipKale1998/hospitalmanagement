package com.hospiatlmangement.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.hospitalmanagement.serviceImp.PatientServiceImplementation;
import com.hospitalmangement.bean.Patient;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
	private PatientServiceImplementation patientservice;
    
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
	        FinalResponse actual = patientservice.GetAllpatientRecords();
	        assertEquals(expected, actual);
	    }
	
	@Test
	@DisplayName("save Patient Info")
	public void Insertpatient() {
		Patient patient = new Patient();
		patient.setPid(1);
		patient.setPname("sandip");
		patient.setPaddress("hyd");
		patient.setPage(26);
		patient.setPgender("male");
		patient.setPphoneno(817623833);
		patient.setP_disease("fever");

		 FinalResponse expected = new FinalResponse();
		 expected.setStatus(true);
		 expected.setStatusCode("200");
		 expected.setMessage("One Record was Inserted");
	        when(patientservice.InsertingOnePatientRecord(any(Patient.class))).thenReturn(expected);
	        FinalResponse actual = patientservice.InsertingOnePatientRecord(patient);
	        assertEquals(expected, actual);
	        
		
	}
	
	

@Test
public void GettingOneRecordTest() {
    Object[] patient = { 1,	"sandip" ,"hyd"	,26,"male"	,817623833	,"fever"};
    List<Integer> pid = new ArrayList<>();
    pid.add(1);
    FinalResponse expected = new FinalResponse();
    expected.setStatus(true);
    expected.setStatusCode("200");
    expected.setMessage("Record Present");
    expected.setData(patient);
    when(patientservice.GetOnepatientRecord(1)).thenReturn(expected);
    FinalResponse actual = patientservice.GetOnepatientRecord(1);;
    assertEquals(expected, actual);
}
@Test
@DisplayName("Delete the Patient")
public void testDeletePatient() {
	Patient patient = new Patient();
	patient.setPid(7);
	FinalResponse expected = new FinalResponse();
	expected.setStatus(true);
	expected.setStatusCode("Ok");
	expected.setMessage("Record deleted");

	when(patientservice.deletingpatientrecord(anyInt())).thenReturn(expected);
	FinalResponse actual = patientservice.deletingpatientrecord(anyInt());
	assertEquals(expected, actual);
}

@Test
@DisplayName("update the patient")
public void testUpdatePatient() {
        Patient patient = new Patient();
        patient.setPname("Akshay");
        patient.setPid(2);
               
        FinalResponse expected = new FinalResponse();
        expected.setStatus(true);
        expected.setStatusCode("Ok");
        expected.setMessage("Record updated");
        
        when(patientservice.Updatingpatientrecord(patient)).thenReturn(expected);
        FinalResponse actual = patientservice.Updatingpatientrecord(patient);
        assertEquals(expected, actual);
}

}
	
	
	
	
	










































































	
	/*
	

	@Test
	@DisplayName("update the patient object in databse")
	public void testUpdatePatient() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		when(patientservice.Updatingpatientrecord(any(Patient.class))).thenReturn(patient1);
		patient1.setPname("surya");

		Patient newpatient = patientservice.Updatingpatientrecord(patient1);

		assertEquals("surya", newpatient.getPname());
	}

	@Test
	@DisplayName("detele patient test")
	public void testDeletePatient() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		when(patientservice.deletingpatientrecordbyid(anyInt())).thenReturn(null);

		patientservice.deletingpatientrecordbyid(7);

		verify(patientservice).deletingpatientrecordbyid(7);
	}
	
	@Test
	@DisplayName("display patient test")
	public void testPatientById() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		when(patientservice.GetOnepatientRecord(anyInt())).thenReturn(null);

		patientservice.GetOnepatientRecord(7);

		verify(patientservice).GetOnepatientRecord(7);
	
	}
	@Test
	public void testFindAllPatient() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		Patient patient2 = new Patient();
		patient2.setPid(21);
		patient2.setPname("chahal");
		patient2.setPaddress("pune");
		patient2.setPgender("male");
		patient2.setPage(27);
		patient2.setP_disease("fever");
		patient2.setPphoneno(797683237);

		List<Patient> patients = new ArrayList<>();

		when(patientservice.GetAllpatientRecords()).thenReturn(patients);
		List<Patient> newpatient = patientservice.GetAllpatientRecords();
		assertEquals(patients, newpatient);
	}
	
	
	
	
		@Test
	public void TestPatientInsertedRecord() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(HttpStatus.CREATED);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		//expected.setData(patient1);

		when(patientservice.InsertingOnePatientRecord(any(Patient.class))).thenReturn(expected);

		FinalResponse actual = patientservice.InsertingOnePatientRecord(patient1);

	    assertEquals(expected, actual);
		
	}
	

}

*/