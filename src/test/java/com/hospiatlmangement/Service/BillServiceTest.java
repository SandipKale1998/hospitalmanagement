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
import com.hospitalmanagement.serviceImp.BillServiceImplementation;
import com.hospitalmangement.bean.Bill;
@ExtendWith(MockitoExtension.class)
class BillServiceTest {

	@Mock
    BillServiceImplementation billservice;
	
	@Test
	public void TestGetpatient() {
		List<Object[]> bills=new ArrayList<>();
		
		Object[] bill1 = { 2,500,50,100,2 };
		Object[] bill2 = { 3,200,50,100,3 };
	
		bills.add(bill1);
		bills.add(bill2);
		
		FinalResponse expected=new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(bills);
		  when(billservice.GetBilldetails()).thenReturn(expected);
	        FinalResponse actual = billservice.GetBilldetails();
	        assertEquals(expected, actual);
	    }
	
	
	@Test
	public void TestAddBill() {
		Bill bill = new Bill();
		bill.setBid(1);
		bill.setBamount(500);
		bill.setMaintaince_charge(100);
		bill.setMedicine_cost(100);
		bill.setPid(2);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		when(billservice.addBill(any(Bill.class))).thenReturn(expected);

		FinalResponse actual = billservice.addBill(bill);

		assertEquals(expected, actual);

	}

	@Test
	@DisplayName("Find Bill by id")
	public void testBillgetById() {
		
		Object[] bill = { 3,200,50,100,3 };
		
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(bill);

		when(billservice.GetBillbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = billservice.GetBillbyid(anyInt());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Delete the bill")
	public void testDeleteBill() {
		Bill bill = new Bill();
		bill.setBid(2);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");

		when(billservice.deleteBillbyid(anyInt())).thenReturn(expected);
		FinalResponse actual = billservice.deleteBillbyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the bill")
    public void testUpdateBill() {
            Bill bill = new Bill();
            bill.setBamount(700);
            bill.setBid(2);
                   
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            expected.setData(bill);
            
            when(billservice.UpdateBill(bill)).thenReturn(expected);
            FinalResponse actual = billservice.UpdateBill(bill);
            assertEquals(expected, actual);
    }

}
