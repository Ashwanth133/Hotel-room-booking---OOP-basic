package service;
import dao.RoomDAO;
import model.Rooms;


import java.util.List;

public class RoomService {

    private RoomDAO roomDAO=new RoomDAO();

    public List<Rooms> getAvailableRooms(String type) throws Exception {
        return roomDAO.getAvailableRoomsByType(type);
    }

    public void occupyRoom(int id) throws Exception {
        roomDAO.updateRoomAvailability(id,0);
    }

}
