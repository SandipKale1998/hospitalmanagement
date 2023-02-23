package com.hospiatlmangement.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.serviceImp.RoomServiceImplementation;
import com.hospitalmangement.bean.Room;
@ExtendWith(MockitoExtension.class)
class RoomServiceTest {
	
	@Mock
	RoomServiceImplementation roomservice;
	
	@Test
	public void TestGetallRooms() {

		List<Object[]> rooms = new ArrayList<>();

		Object[] room1 = { 1, "Firstfloor", 2 };
		Object[] room2 = { 2, "ThirdFloor", 3 };
		rooms.add(room1);
		rooms.add(room2);

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Records present");
		expected.setData(rooms);
		when(roomservice.GetRoom()).thenReturn(expected);
		FinalResponse actual = roomservice.GetRoom();
		assertEquals(expected, actual);
	}

	@Test
	public void TestInsertedRoom() {
		Room room = new Room();
		room.setRoom_id(1);
		room.setRoom_Location("firstF");
		room.setPid(2);

		FinalResponse expected = new FinalResponse();

		expected.setStatus(true);

		expected.setStatusCode("201");

		expected.setMessage("Record is inserted");

		when(roomservice.AddRoom(any(Room.class))).thenReturn(expected);

		FinalResponse actual = roomservice.AddRoom(room);

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("Find room by id")
	public void testRoomgetById() {
		Object[] room = { 1, "FirstF", 5 };

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(room);

		when(roomservice.GetRoombyid(anyInt())).thenReturn(expected);
		FinalResponse actual = roomservice.GetRoombyid(anyInt());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Delete the Room")
	public void testDeleteRoom() {
		Room room = new Room();
		room.setRoom_id(2);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");
		expected.setData(room);

		when(roomservice.deleteRoombyid(anyInt())).thenReturn(expected);
		FinalResponse actual = roomservice.deleteRoombyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the Room")
    public void testUpdateRoom() {
           Room room = new Room();
            room.setRoom_Location("secondf");;
            room.setRoom_id(1);;
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            expected.setData(room);
            
            when(roomservice.UpdateRoom(room)).thenReturn(expected);
            FinalResponse actual = roomservice.UpdateRoom(room);
            assertEquals(expected, actual);
    }

}
