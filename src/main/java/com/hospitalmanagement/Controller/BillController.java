package com.hospitalmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospiatlmangement.Service.BillService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Bill;

@RestController
public class BillController {

	@Autowired
	BillService billservice;

	@GetMapping("/GetBills")
	public FinalResponse getBill() {
		return billservice.GetBilldetails();
	}

	@PostMapping("/AddBill")
	public FinalResponse addBill(@RequestBody  Bill bill) {
		return billservice.addBill(bill);
	}

	@DeleteMapping("/DeleteBillByid/{bid}")
	public FinalResponse DeleteBillbyid(@PathVariable int bid) {
		return billservice.deleteBillbyid(bid);

	}

	@GetMapping("/GetBillbyId/{bid}")
	public FinalResponse GetBillByid(@PathVariable int bid) {
		return billservice.GetBillbyid(bid);
	}

	@PutMapping("/updateBill")
	public FinalResponse updateBill(@RequestBody  Bill bill) {
		return billservice.UpdateBill(bill);
		
	}

}
