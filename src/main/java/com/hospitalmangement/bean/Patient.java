package com.hospitalmangement.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Patient {
	private int pid;

	@NotBlank(message = "pname should not be blank")
	private String pname;
	@NotBlank(message = "paddress should not be blank")
	private String paddress;
	@NotNull
	private int page;
	@NotBlank(message = "pgender should not be blank")
	private String pgender;
	@NotNull
	private int pphoneno;
	@NotBlank(message = "p_disease should not be blank")
	private String p_disease;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public int getPphoneno() {
		return pphoneno;
	}

	public void setPphoneno(int pphoneno) {
		this.pphoneno = pphoneno;
	}

	public String getP_disease() {
		return p_disease;
	}

	public void setP_disease(String p_disease) {
		this.p_disease = p_disease;
	}

}
