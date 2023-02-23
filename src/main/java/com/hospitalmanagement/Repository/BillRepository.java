package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Bill;

public interface BillRepository {

	public List<Object[]> GetAllBill();

	public Bill AddBill(Bill bill);

	public String DeleteBillByid(int bid);

	public Object[] GetBillByid(int bid);

	public Bill UpdateBill(Bill bill);

}
