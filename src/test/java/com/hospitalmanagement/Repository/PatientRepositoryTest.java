package com.hospitalmanagement.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Patient;

@ExtendWith(MockitoExtension.class)
class PatientRepositoryTest {

	@Mock
	PatientRepositoryImplementation patientrepository;
	
	    @Test
	    @DisplayName("Save the patient")
	   public void testSavePatientRepository() {
	            Patient patient = new Patient();
	            patient.setPid(21);
	            patient.setPname("chahal");
	            patient.setPaddress("pune");
	            patient.setPgender("male");
	            patient.setPage(27);
	            patient.setP_disease("fever");
	            patient.setPphoneno(797683237);

	            when(patientrepository.InsertingOnePatientRecord(patient)).thenReturn("inserted");
	            String actual = patientrepository.InsertingOnePatientRecord(patient);
	            assertNotNull(actual);

	    }
	    
	    @Test
	    @DisplayName("update the customer")
	    public void testUpdatePatientRepository() {
	            Patient patient = new Patient();
	            patient.setPname("akshay");
	            patient.setPid(2);
	            
	            when(patientrepository.Updatingpatientrecord(patient)).thenReturn(patient);
	            Patient actual = patientrepository.Updatingpatientrecord(patient);
	            assertNotNull(actual);
	    }
	    
	    @Test
	    @DisplayName("Delete the patient")
	    public void testDeletePatientRepository() {
	         Patient patient = new Patient();
	         patient.setPid(2);
	         
	            when(patientrepository.deletingpatientrecordbyid(anyInt())).thenReturn("deleted");
	            String actual = patientrepository.deletingpatientrecordbyid(anyInt());
	            assertNotNull(actual);
	    }	
	
	    @Test
	    @DisplayName("Find patient by id")
	    public void testGetByIdPatientRepository() {

	         Object[] patient = {"ashutosh","Nagpur","Katol","7689687989",null,null};
	        
	         FinalResponse expected = new FinalResponse();
	         expected.setStatus(true);
	         expected.setStatusCode("Ok");
	         expected.setMessage("Record present");
	         expected.setData(patient);
	         
	         when(patientrepository.GetOnepatientRecord(anyInt())).thenReturn(patient);
	         Object[] actual = patientrepository.GetOnepatientRecord(anyInt());
	         assertNotNull(actual);
	    }	
	
	
	
	
	
	
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

		when(patientrepository.Updatingpatientrecord(any(Patient.class))).thenReturn(patient1);
		patient1.setPname("surya");

		Patient newpatient = patientrepository.Updatingpatientrecord(patient1);

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

		when(patientrepository.deletingpatientrecordbyid(anyInt())).thenReturn(null);

		patientrepository.deletingpatientrecordbyid(7);

		verify(patientrepository).deletingpatientrecordbyid(7);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
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

		List<Patient> expected = new ArrayList<>();

		when(patientrepository.GetAllpatientRecords()).thenReturn(expected);
		List<Patient> actual = patientrepository.GetAllpatientRecords();
		assertEquals(expected, actual);
	}

	*/
	/*
	
	@Test
	@DisplayName("save Patient Info")
	public void Insertpatient() {
		Patient patient1 = new Patient();
		patient1.setPid(21);
		patient1.setPname("chahal");
		patient1.setPaddress("pune");
		patient1.setPgender("male");
		patient1.setPage(27);
		patient1.setP_disease("fever");
		patient1.setPphoneno(797683237);

		when(patientrepository.InsertingOnePatientRecord(any(Patient.class))).thenReturn("inserted ");
		String newpatient = patientrepository.InsertingOnePatientRecord(patient1);

		assertNotEquals(patient1, newpatient);
  }
	
	
	*/
	
	
	
	
	/*
	@Test
	void findbyid() {
		
		Patient patient= new Patient();
		patientrepository.GetOnepatientRecord(5);
		
		Object[] result= patientrepository.GetOnepatientRecord(5);
		
		assertEquals(patient, result);
		
	}
	
	*/
	
	
}

