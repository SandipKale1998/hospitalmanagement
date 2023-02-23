package com.hospitalmanagement.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hospitalmangement.bean.Room;

@Repository
public class RoomRepositoryImplementation implements RoomRepository {

	@Autowired 
	EntityManager entityManager;
	
	
	@Override
	public List<Object[]> GetRoomDetails() {
		Query query=entityManager.createNativeQuery("select * from room");
		List<Object[]> room=query.getResultList();
		return room;
	}

    @Transactional
	@Override
	public Room InsertingRoom(Room room) {
		Query query=entityManager.createNativeQuery("Insert into Room values(?,?,?)");
		query.setParameter(1, room.getRoom_id());
		query.setParameter(2, room.getRoom_Location());
		query.setParameter(3, room.getPid());
		query.executeUpdate();
		return room;
	}

    @Transactional
	@Override
	public String deleteRoombyid(int room_id) {
		Query query=entityManager.createNativeQuery("delete from room where room_id=?");
		query.setParameter(1, room_id);
		query.executeUpdate();
		return "record deleted successfully";
	}


	@Override
	public Object[] GetRoombyid(int room_id) {
		Query query=entityManager.createNativeQuery("select * from room where room_id=?");
		query.setParameter(1, room_id);
		Object[] room = (Object[]) query.getSingleResult();
		return room;
	}

    @Transactional
	@Override
	public Room UpdatingRoomrecord(Room room) {
		Query query=entityManager.createNativeQuery("Update Room set room_Location=?,pid=? where room_id=?");
		query.setParameter(1, room.getRoom_Location());
		query.setParameter(2, room.getPid());
		query.setParameter(3, room.getRoom_id());
		query.executeUpdate();
		return room;
	}
	

}
