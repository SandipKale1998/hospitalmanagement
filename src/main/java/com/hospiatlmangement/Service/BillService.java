package com.hospiatlmangement.Service;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Bill;

public interface BillService {

	public FinalResponse GetBilldetails();

	public FinalResponse addBill(Bill bill);

	public FinalResponse deleteBillbyid(int bid);

	public FinalResponse GetBillbyid(int bid);

	public FinalResponse UpdateBill(Bill bill);
}
