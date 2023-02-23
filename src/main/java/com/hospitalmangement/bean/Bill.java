package com.hospitalmangement.bean;

public class Bill {

	private int bid;

	private int bamount;

	private int maintaince_charge;

	private int medicine_cost;

	private int pid;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public double getBamount() {
		return bamount;
	}

	public void setBamount(int bamount) {
		this.bamount = bamount;
	}

	public int getMaintaince_charge() {
		return maintaince_charge;
	}

	public void setMaintaince_charge(int maintaince_charge) {
		this.maintaince_charge = maintaince_charge;
	}

	public int getMedicine_cost() {
		return medicine_cost;
	}

	public void setMedicine_cost(int medicine_cost) {
		this.medicine_cost = medicine_cost;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
