package dao;

import config.DBConnection;
import model.Rooms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public List<Rooms> getAvailableRoomsByType(String type) throws Exception{
        List<Rooms> room=new ArrayList<>();
        Connection connection= DBConnection.getConnection();

        PreparedStatement ps=connection.prepareStatement(
                "select * from rooms where room_type=? and is_available=1"
        );
        ps.setString(1,type);
        ResultSet rs= ps.executeQuery();
        System.out.println("  Rooms Available ⛵\n");
        while(rs.next()){
            System.out.println("    Found room: "+rs.getInt("room_id"));
            room.add(new Rooms(
                    rs.getInt("room_id"),
                    rs.getString("room_type"),
                    rs.getDouble("price"),
                    rs.getBoolean("is_available")

            ));
        }
        connection.close();
        ps.close();
        rs.close();
        return room;


    }

    public void updateRoomAvailability(int id,int status) throws Exception{
        Connection connection=DBConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(
                "update rooms set is_available=? where room_id=?"
        );
        ps.setInt(1,status);
        ps.setInt(2,id);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }
}
