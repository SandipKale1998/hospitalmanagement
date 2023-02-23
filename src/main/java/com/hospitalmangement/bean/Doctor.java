package com.hospitalmangement.bean;

import java.sql.Date;

public class Doctor {
	private int doctor_id;
	private String doctor_name;
	private String doctor_phnumber;
	private String doctor_specialization;
	private Date doctor_joiningdate;
	private Date doctor_resign;
	private int staff_id;

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_phnumber() {
		return doctor_phnumber;
	}

	public void setDoctor_phnumber(String doctor_phnumber) {
		this.doctor_phnumber = doctor_phnumber;
	}

	public String getDoctor_specialization() {
		return doctor_specialization;
	}

	public void setDoctor_specialization(String doctor_specialization) {
		this.doctor_specialization = doctor_specialization;
	}

	public Date getDoctor_joiningdate() {
		return doctor_joiningdate;
	}

	public void setDoctor_joiningdate(Date doctor_joiningdate) {
		this.doctor_joiningdate = doctor_joiningdate;
	}

	public Date getDoctor_resign() {
		return doctor_resign;
	}

	public void setDoctor_resign(Date doctor_resign) {
		this.doctor_resign = doctor_resign;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id_id(int staff_id) {
		this.staff_id = staff_id;
	}

}
