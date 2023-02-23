package com.hospitalmanagement.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospiatlmangement.Service.RoomService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmangement.bean.Room;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomservice;
	
	@GetMapping("/GetRooms")
	public FinalResponse getRoomDetails(){
		return roomservice.GetRoom();
	}
	@PostMapping("/AddRoom")
	public FinalResponse AddRoom( @RequestBody @Valid Room room) {
		return roomservice.AddRoom(room);	
	}
	
	@DeleteMapping("/DeleteRoombyid/{room_id}")
	public FinalResponse deletingRoombyid(@PathVariable int room_id) {
		return roomservice.deleteRoombyid(room_id);
	}
	
	 @GetMapping("/GetRoombyid/{room_id}")
	    public FinalResponse GettingRoomDetails(@PathVariable int room_id) {
	        return roomservice.GetRoombyid(room_id);
	    }
	 
	 @PutMapping("/updateRoomrecord")
	 public FinalResponse UpdateRoom(@RequestBody @Valid Room room) {
		return roomservice.UpdateRoom(room);
		
	 }
}
