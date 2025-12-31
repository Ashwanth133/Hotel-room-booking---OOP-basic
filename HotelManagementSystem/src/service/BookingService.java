package service;

import dao.BookingDAO;
import dao.RoomDAO;

public class BookingService {

    private final BookingDAO bookingDAO=new BookingDAO();
    private final RoomDAO roomDAO=new RoomDAO();


    public double calculateTotal(double pricePerDay,int days){
        return pricePerDay*days;
    }

    public void bookRoom(int id,String name,String mobile,double pricePerDay,int days) throws Exception{
        double total=calculateTotal(pricePerDay,days);
        System.out.println("\nThe Price will be 💲"+total+" for "+days+" days.\n");

        bookingDAO.saveBooking(id,name,mobile,days,total);
        roomDAO.updateRoomAvailability(id,0);

        System.out.println("Booking Successfully completed ✅");
    }
    public void autoReleaseRoom() throws Exception{
        bookingDAO.freeExpiredRooms();
    }
}
