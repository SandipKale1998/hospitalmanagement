package com.hospitalmangement.bean;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Nursing_staff {
	private int nurse_id;
	@NotBlank(message = "nursename should not be null")
	private String nurse_name;
	private String nurse_address;
	@NotNull(message = "nurse_phoneno should not be null")
	private String nurse_phoneno;
	private String nurse_salary;
	@NotNull(message = "nurse_role should not be null")
	private String nurse_role;
	private Date nurse_joiningdate;
	private String nurse_resignDate;
	private int staff_id;

	public int getNurse_id() {
		return nurse_id;
	}

	public void setNurse_id(int nurse_id) {
		this.nurse_id = nurse_id;
	}

	public String getNurse_name() {
		return nurse_name;
	}

	public void setNurse_name(String nurse_name) {
		this.nurse_name = nurse_name;
	}

	public String getNurse_address() {
		return nurse_address;
	}

	public void setNurse_address(String nurse_address) {
		this.nurse_address = nurse_address;
	}

	public String getNurse_phoneno() {
		return nurse_phoneno;
	}

	public void setNurse_phoneno(String nurse_phoneno) {
		this.nurse_phoneno = nurse_phoneno;
	}

	public String getNurse_salary() {
		return nurse_salary;
	}

	public void setNurse_salary(String nurse_salary) {
		this.nurse_salary = nurse_salary;
	}

	public String getNurse_role() {
		return nurse_role;
	}

	public void setNurse_role(String nurse_role) {
		this.nurse_role = nurse_role;
	}

	public Date getNurse_joiningdate() {
		return nurse_joiningdate;
	}

	public void setNurse_joiningdate(Date nurse_joiningdate) {
		this.nurse_joiningdate = nurse_joiningdate;
	}

	public String getNurse_resignDate() {
		return nurse_resignDate;
	}

	public void setNurse_resignDate(String nurse_resignDate) {
		this.nurse_resignDate = nurse_resignDate;
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

}
