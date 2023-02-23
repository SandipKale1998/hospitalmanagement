package com.hospitalmanagement.serviceImp;

import java.util.InputMismatchException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospiatlmangement.Service.RoomService;
import com.hospitalmanagement.FinalResponse.FinalResponse;
import com.hospitalmanagement.Repository.RoomRepository;
import com.hospitalmangement.bean.Room;

@Service
public class RoomServiceImplementation implements RoomService {
	Logger logger = LoggerFactory.getLogger(RoomServiceImplementation.class);
	@Autowired
	private RoomRepository roomrepository;

	@Override
	public FinalResponse GetRoom() {
		 FinalResponse finalresponse=new FinalResponse();
	      List<Object[]> roomsdetails=null;
	      logger.info("getroom :: input ::");
			try {
				roomsdetails = roomrepository.GetRoomDetails();
				if (roomsdetails != null) {
					finalresponse.setStatus(true);
					finalresponse.setStatusCode("200");
					finalresponse.setMessage("Record Present");
					finalresponse.setData(roomsdetails);
				}
			} catch (InputMismatchException e) {
				logger.error("getrooms :: input ::" + e.getMessage());
			}
			return finalresponse;
	}

	@Override
	public FinalResponse AddRoom(Room room) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("InsertingOneroomRecord:: input :: room:" + room);
		System.out.println(room.getRoom_Location());
		try {
			roomrepository.InsertingRoom(room);
			if (room != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("One Record was Inserted");
			}
		} catch (InputMismatchException ex) {
			logger.error("InsertingOneroomRecord:: input :: room:" + ex.getMessage());
		}
		return finalresponce;
	}

	@Override
	public FinalResponse deleteRoombyid(int room_id) {
		FinalResponse finalResponse = new FinalResponse();
		logger.info("deletingroombyid :: input :: room_id "+room_id);
		try {
		roomrepository.deleteRoombyid(room_id);
		if (room_id > 0) {
			finalResponse.setStatus(true);
			finalResponse.setStatusCode("200");
			finalResponse.setMessage("One Record was deleted");
		} }catch(InputMismatchException e) {
			logger.error("deletedroombyid :: input :: room_id "+room_id + e.getLocalizedMessage());
		}
		return finalResponse;
	}

	@Override
	public FinalResponse GetRoombyid(int room_id) {
		Object[] room=null; 
		FinalResponse finalresponse = new FinalResponse();
		logger.info("Gettingroombyid :: input :: room_id "+room_id);
		try {
		room=roomrepository.GetRoombyid(room_id);
		if (room != null) {
			finalresponse.setStatus(true);
			finalresponse.setStatusCode("200");
	    	finalresponse.setMessage("Record Present");
			return finalresponse;
		}
		}catch(InputMismatchException e) {
			logger.error("Getroombyid :: input :: room_id "+room_id+e.getMessage());
		}
			return finalresponse;
		
	}
	
	@Override
	public FinalResponse UpdateRoom(Room room) {
		FinalResponse finalresponce = new FinalResponse();
		logger.info("UpdatingRoomRecord:: input :: room:" + room);
		System.out.println(room.getRoom_id());
		try {
			roomrepository.UpdatingRoomrecord(room);
			if (room != null) {
				finalresponce.setStatus(true);
				finalresponce.setStatusCode("200");
				finalresponce.setMessage("Record Updated");
			}
		} catch (Exception ex) {
			logger.error("UpdatingRoomRecord:: input :: room:" + ex.getMessage());
		}
		return finalresponce;
	}

}
