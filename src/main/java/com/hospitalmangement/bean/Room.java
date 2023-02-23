package com.hospitalmangement.bean;

import javax.validation.constraints.NotBlank;

public class Room {
	private int room_id;

	@NotBlank
	private String room_Location;

	private int pid;

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_Location() {
		return room_Location;
	}

	public void setRoom_Location(String room_Location) {
		this.room_Location = room_Location;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
