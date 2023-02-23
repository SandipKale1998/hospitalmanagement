package com.hospitalmanagement.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hospiatlmangement.Service.RoomService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Room;

@ExtendWith(MockitoExtension.class)
class RoomControllerTest {

	@InjectMocks
	private RoomController roomController;

	@Mock
	private RoomService roomService;

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
		when(roomService.GetRoom()).thenReturn(expected);
		FinalResponse actual = roomController.getRoomDetails();
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

		expected.setData(room);
		
		when(roomService.AddRoom(any(Room.class))).thenReturn(expected);

		FinalResponse actual = roomController.AddRoom(room);

		assertEquals(expected, actual);

	}
	
	@Test
	@DisplayName("Find room by id")
	public void testRoomgetByIdController() {
		Object[] room = { 1, "FirstF", 5 };

		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record present");
		expected.setData(room);

		when(roomService.GetRoombyid(anyInt())).thenReturn(expected);
		FinalResponse actual = roomController.GettingRoomDetails(anyInt());
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Delete the Room object to databse")
	public void testDeleteRoomController() {
		Room room = new Room();
		room.setRoom_id(2);
		FinalResponse expected = new FinalResponse();
		expected.setStatus(true);
		expected.setStatusCode("Ok");
		expected.setMessage("Record deleted");

		when(roomService.deleteRoombyid(anyInt())).thenReturn(expected);
		FinalResponse actual = roomController.deletingRoombyid(anyInt());
		assertEquals(expected, actual);
	}

	
	@Test
    @DisplayName("update the Room")
    public void testUpdateRoomController() {
           Room room = new Room();
            room.setRoom_Location("secondf");;
            room.setRoom_id(1);;
            
            
            FinalResponse expected = new FinalResponse();
            expected.setStatus(true);
            expected.setStatusCode("Ok");
            expected.setMessage("Record updated");
            expected.setData(room);
            
            when(roomService.UpdateRoom(room)).thenReturn(expected);
            FinalResponse actual = roomController.UpdateRoom(room);
            assertEquals(expected, actual);
    }
    
}

