package com.hospitalmanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Bill;

@Repository
public class BillRepositoryImplementation implements BillRepository {

	@Autowired
    EntityManager entityManager;
	
	@Override
	public List<Object[]> GetAllBill() {
		Query query=entityManager.createNativeQuery("select * from bill");
		List<Object[]> bill=query.getResultList();
		return bill;
	}

	@Transactional
	@Override
	public Bill AddBill(Bill bill) {
		Query query=entityManager.createNativeQuery("insert Into bill values(?,?,?,?,?)");
		query.setParameter(1, bill.getBid());
		query.setParameter(2, bill.getBamount());
		query.setParameter(3, bill.getMaintaince_charge());
		query.setParameter(4, bill.getMedicine_cost());
		query.setParameter(5, bill.getPid());
        query.executeUpdate();
		return bill;
	}

	@Transactional
	@Override
	public String DeleteBillByid(int bid) {
		Query query=entityManager.createNativeQuery("delete from bill where bid=?");
		query.setParameter(1, bid);
		query.executeUpdate();
		return "Bill was deleted";
	}

	@Override
	public Object[] GetBillByid(int bid) {
		Query query=entityManager.createNativeQuery("select * from bill where bid=?");
		query.setParameter(1, bid);
		Object[] bill=(Object[])query.getSingleResult();
		return bill;
	}
   
	@Transactional
	@Override
	public Bill UpdateBill(Bill bill) {
		Query query=entityManager.createNativeQuery("update bill set bamount=?,maintaince_charge=?,medicine_cost=?, pid=? where bid=?");
		query.setParameter(1, bill.getBamount());
		query.setParameter(2, bill.getMaintaince_charge());
		query.setParameter(3, bill.getMedicine_cost());
		query.setParameter(4, bill.getPid());
		query.setParameter(5, bill.getBid());
		query.executeUpdate();
		return bill;
	}
	

}
