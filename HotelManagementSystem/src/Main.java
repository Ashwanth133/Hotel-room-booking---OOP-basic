import config.DBConnection;
import model.Rooms;
import service.BookingService;
import service.RoomService;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    static double price=-1;
    static RoomService roomService = new RoomService();
    static BookingService bookingService=new BookingService();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        bookingService.autoReleaseRoom();
        //DB CONNECTION
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Connected ");

        } catch (Exception e) {
            e.printStackTrace();
        }

        String room_type = null;
        while (true) {
            System.out.println("********** ROOM BOOKING APPLICATION 🏩**********");
            System.out.println("\n    ✨ VIEW ROOMS ✨    \n");
            System.out.println("1.Single Room 📍  ---> Price per day : 1050 ");
            System.out.println("2.Double Rooms📍  ---> Price per day : 1850 ");
            System.out.println("3.Deluxe Rooms📍  ---> Price per day : 3200 ");
            System.out.println();
            System.out.print("Enter your choice: ");
            int type = sc.nextInt();
            switch (type) {
                case 1:
                    room_type = "Single";
                    break;
                case 2:
                    room_type = "Double";
                    break;
                case 3:
                    room_type = "Deluxe";
                    break;
                default:
                    System.out.println("❌ INVALID CHOICE ...Please try again\n ");
                    continue;
            }
            break;
        }
        System.out.println();
        List<Rooms> roomsList = roomService.getAvailableRooms(room_type);
        System.out.println();
        int SelectedRoom=-1;
        int attempts=0;
        while (true) {
            System.out.print("Enter Room No 🤓: ");
            int RoomId = sc.nextInt();
            if (ValidRoom(RoomId, roomsList)) {
                System.out.println("\n    Room is Available 🍸");
                SelectedRoom=RoomId;
                break;
            } else {
                if(attempts==3){
                    System.out.println("\nERROR DUE TO MULTIPLE ATTEMPTS ❌");
                    System.out.println( "     THANK YOU 😊");
                    return;
                }
                System.out.println("\n****************************************");
                System.out.println("Invalid Room Number ❌");
                System.out.println("Please Select The rooms from the List 🤓 ");
                System.out.println("****************************************\n");
                attempts++;
            }
        }
        System.out.println("\n*******************************");
        System.out.println("         Booking Page 🔖");
        System.out.println("*******************************\n");

        System.out.print("Enter your name :");
        String name=sc.next();
        System.out.print("Enter your Mobile number: ");
        String mobile_no=sc.next();
        System.out.print("Number of days you want to book: ");
        int days=sc.nextInt();

        bookingService.bookRoom(SelectedRoom,name,mobile_no,price,days);
        roomService.occupyRoom(SelectedRoom);

        System.out.println("\n    Thank you 🙏");

    }


    private static boolean ValidRoom ( int roomId, List<Rooms > roomsList) throws Exception {
            for (Rooms r : roomsList) {
                if (r.getId() == roomId) {
                    price=r.getPrice();
                    return true;
                }
            }
            return false;
        }
}
