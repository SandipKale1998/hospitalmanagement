package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Patient;

public interface PatientRepository { // extends JpaRepository<PatientData, Integer>{

	public List<Object[]> GetAllpatientRecords();

	public String InsertingOnePatientRecord(Patient patient);

	public String deletingpatientrecordbyid(int pid);

	public Object[] GetOnepatientRecord(int pid);

	public Patient Updatingpatientrecord(Patient patient);

	public Object[] getpatientrecordbyname(String pname);
}





























































//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//import com.example.Entity.PatientData;