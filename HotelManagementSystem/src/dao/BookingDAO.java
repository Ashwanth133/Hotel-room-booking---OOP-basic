package dao;

import config.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class BookingDAO {

    public void saveBooking(int id,String customer_name,String mobile_no,int days,double price) throws Exception{
        try(Connection connection= DBConnection.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into bookings (room_id,customer_name,mobile_number,days,total_price,booking_date) values (?,?,?,?,?,?)"
            );
            ps.setInt(1, id);
            ps.setString(2, customer_name);
            ps.setString(3, mobile_no);
            ps.setInt(4, days);
            ps.setDouble(5, price);
            ps.setDate(6, Date.valueOf(LocalDate.now()));
        }

    }

    public void freeExpiredRooms() throws Exception{
        Connection connection=DBConnection.getConnection();
        PreparedStatement ps=connection.prepareStatement(
                """
                     update rooms set is_available=1
                     where room_id in (
                        select room_id from bookings
                        where booking_date + days< current_date
                    )
                    """
        );
        ps.executeUpdate();
        ps.close();
        connection.close();
    }
}

