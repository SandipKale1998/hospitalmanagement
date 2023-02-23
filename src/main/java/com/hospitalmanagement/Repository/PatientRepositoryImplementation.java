package com.hospitalmanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Patient;

@Repository
public class PatientRepositoryImplementation implements PatientRepository {

	@Autowired
	private EntityManager entitymanager;

	// get all patientdata
	@Override
	public List<Object[]> GetAllpatientRecords() {
		Query query = entitymanager.createNativeQuery("select * from patient");
		List<Object[]> patient = query.getResultList();
		return patient;
	}

	@Transactional
	@Override
	public String InsertingOnePatientRecord(Patient patient) {
		Query query = entitymanager.createNativeQuery("insert into patient values(?,?,?,?,?,?,?)");
		query.setParameter(1, patient.getPid());
		query.setParameter(2, patient.getPname());
		query.setParameter(3, patient.getPgender());
		query.setParameter(4, patient.getPage());
		query.setParameter(5, patient.getPaddress());
		query.setParameter(6, patient.getPphoneno());
		query.setParameter(7, patient.getP_disease());
		query.executeUpdate();
		return "patient Inserted";
		/*
		 * int Record=query.executeUpdate(); if(Record > 0) { return patient; }
		 */

	}

	@Transactional
	@Override
	public String deletingpatientrecordbyid(int pid) {
		Query query = entitymanager.createNativeQuery("delete from patient where pid=?");
		query.setParameter(1, pid);
		int rec = query.executeUpdate();
		if (rec > 0) {
			return " one Patient record was deleted";
		} else {
			return "Patient record was not found";
		}
	}

	@Override
	public Object[] GetOnepatientRecord(int pid) {
		Query query = entitymanager.createNativeQuery("select * from patient where pid=?");
		query.setParameter(1, pid);
		Object[] patient = (Object[]) query.getSingleResult();
		return patient;

	}

	@Transactional
	@Override
	public Patient Updatingpatientrecord(Patient patient) {
		Query query = entitymanager.createNativeQuery(
				"update patient set pname=?,paddress=?,page=?,pgender=?,pphoneno=?, p_disease=? where pid=?");
		query.setParameter(1, patient.getPname());
		query.setParameter(2, patient.getPaddress());
		query.setParameter(3, patient.getPage());
		query.setParameter(4, patient.getPgender());
		query.setParameter(5, patient.getPphoneno());
		query.setParameter(6, patient.getP_disease());
		query.setParameter(7, patient.getPid());
		int record = query.executeUpdate();
		if (record > 0) {
			return patient;
		}
		return patient;

	}

	@Override
	public Object[] getpatientrecordbyname(String pname) {

		Query query = entitymanager.createNativeQuery("select * from patient where pname=?");
		query.setParameter(1, pname);
		Object[] patient = (Object[]) query.getSingleResult();
		return patient;
	}

}
