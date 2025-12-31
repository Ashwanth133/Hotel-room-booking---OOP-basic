package model;

import java.time.LocalDate;

public class Booking {

    private int booking_id;
    private int room_id;
    private String customer_name;
    private String mobile_number;
    private LocalDate booking_date;
    private int days;
    private double total_price;

    public Booking(int room_id, String customer_name, String mobile_number, LocalDate booking_date, int days, double total_price) {

        this.room_id = room_id;
        this.customer_name = customer_name;
        this.mobile_number = mobile_number;
        this.days = days;
        this.total_price = total_price;
        this.booking_date = booking_date;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public LocalDate getBooking_date() {
        return booking_date;
    }

    public int getDays() {
        return days;
    }

    public double getTotal_price() {
        return total_price;
    }
}
