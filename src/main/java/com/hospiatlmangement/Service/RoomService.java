package com.hospiatlmangement.Service;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Room;

public interface RoomService {

	public FinalResponse GetRoom();

	public FinalResponse AddRoom(Room room);

	public FinalResponse deleteRoombyid(int room_id);

	public FinalResponse GetRoombyid(int room_id);

	public FinalResponse UpdateRoom(Room room);

}
