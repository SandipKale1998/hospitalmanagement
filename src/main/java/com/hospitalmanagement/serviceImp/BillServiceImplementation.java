package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.BillService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.BillRepository;
import com.hospitalmangement.bean.Bill;

@Service
public class BillServiceImplementation implements BillService {

	Logger logger = LoggerFactory.getLogger(BillServiceImplementation.class);

	@Autowired
	BillRepository billrepository;

	@Override
	public FinalResponse GetBilldetails() {
		List<Object[]> Billdetails = null;
		FinalResponse finalResponse = new FinalResponse();
		logger.info("getbill :: input ::");
		try {
			Billdetails = billrepository.GetAllBill();
			if (Billdetails != null) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage("Record Present");
				finalResponse.setData(Billdetails);;
			}
		} catch (InputMismatchException e) {
			logger.info("getbill :: input ::" + e.getMessage());
		}
		return finalResponse;
	}

	@Override
	public FinalResponse addBill(Bill bill) {
		FinalResponse finalresponse = new FinalResponse();
		logger.info("InsertingOneBillRecord:: input :: bill:" + bill);
		try {
			billrepository.AddBill(bill);
			if (bill != null) {
				finalresponse.setStatus(true);
				finalresponse.setStatusCode("200");
				finalresponse.setMessage("One Record was Inserted");
			}
		} catch (Exception ex) {
			logger.error("Not InsertingOneBillRecord:: input :: bill:" + ex.getMessage());
		}
		return finalresponse;
	}

	@Override
	public FinalResponse deleteBillbyid(int bid) {
		FinalResponse finalResponse = new FinalResponse();
		logger.info("deletebillbyid :: input :: bid:"+bid);
		
		try {
			billrepository.DeleteBillByid(bid);
			if (bid > 0) {
				finalResponse.setStatus(true);
				finalResponse.setStatusCode("200");
				finalResponse.setMessage(bid + " th Record was deleted");

			}
		} catch (InputMismatchException e) {
			logger.error("deletebillbyid :: input :: bid:"+bid+e.getMessage());
		}
		return finalResponse;
	}

	@Override
	public FinalResponse GetBillbyid(int bid) {
		Object[] bill =null;;
		FinalResponse finalresponse = new FinalResponse();
		logger.info("getbillbyid :: input :: bid:"+bid);
		try {
		bill= billrepository.GetBillByid(bid);
		if (bill != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
			finalresponse.setMessage("Record Present");
			finalresponse.setData(bill);
		} }catch(InputMismatchException e) {
			logger.error("getbillbyid :: input :: bid:"+e.getMessage());
		}return finalresponse;
	}

	@Override
	public FinalResponse UpdateBill(Bill bill) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingbillRecord:: input :: bill:" + bill);
		System.out.println(bill.getBamount());
		try {
			billrepository.UpdateBill(bill);
			if (bill != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingbillRecord:: input :: bill:" + ex.getMessage());
		}
		return finalresponce;
	}

}
