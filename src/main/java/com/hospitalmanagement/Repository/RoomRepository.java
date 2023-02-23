package com.hospitalmanagement.Repository;

import java.util.List;

import com.hospitalmangement.bean.Room;

public interface RoomRepository {
	
	public List<Object[]> GetRoomDetails();
	
	public Room InsertingRoom(Room room);

	public String deleteRoombyid(int room_id);

	public Object[] GetRoombyid(int room_id);

	public Room UpdatingRoomrecord(Room room);


}
