package com.hospitalmanagement.Controller;

import static org.junit.jupiter.api.Assertions.*;
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

import com.hospiatlmangement.Service.AdminService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Admin;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

	@InjectMocks
	private AdminController admincontroller;
	
	@Mock
	private AdminService adminservice;
	
	@Test
	public void TestGetAdmin() {
		List<Object[]> admins=new ArrayList<>();
		
		Object[] admin1 = { 1,"sandip","kale","9122382637","pune","akshay_nasre","akshay@123"};
		Object[] admin2 = {2,"akshay","nasre","9822382637","pune","akshay_nasre","akshay@123"};
	
		admins.add(admin1);
		admins.add(admin2);
		
		FinalResponse expected=new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(admins);
		  when(adminservice.getAdmin()).thenReturn(expected);
	        FinalResponse actual = admincontroller.getAdminDetails();
	        assertEquals(expected, actual);
	    }
	
	
	@Test
	public void TestAdminInsertedRecord() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setFirstName("rahul");
        admin.setLastName("sharma");
        admin.setCity("pune");
        admin.setContactNo("9145769528");
        admin.setUsername("rahul_sharma");
        admin.setPassword("rahul@123");

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		expected.setData(admin);
		when(adminservice.addAdmin(any(Admin.class))).thenReturn(expected);

	//	FinalResponse actual = admincontroller.addAdmin(admin);

	//	assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Find admin by id")
	public void testAdmingetByIdController() {
		Object[] admin = {2,"akshay","nasre","9822382637","pune","akshay_nasre","akshay@123"};

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(admin);

		when(adminservice.GetAdminbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = admincontroller.GettingAdminDetails(anyInt());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Delete the Admin object to databse")
	public void testDeleteAdminController() {
		Admin admin = new Admin();
		admin.setAdminId(2);;
		FinalResponse expected = new FinalResponse();
		//expected.setStatus(HttpStatus.OK);
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");
        expected.setData(admin);
		
		when(adminservice.deleteAdminbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = admincontroller.deletingAdminbyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the Admin object in databse")
    public void testUpdateAdminController() {
            Admin admin = new Admin();
            admin.setFirstName("amay");
            admin.setAdminId(2);
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            
            when(adminservice.UpdateAdmin(admin)).thenReturn(expected);
            FinalResponse actual = admincontroller.Updattingpatientrecord(admin);
            assertEquals(expected, actual);
    }
}
