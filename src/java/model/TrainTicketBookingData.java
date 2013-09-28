/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TrainTicketBooking;
import DbClasses.TrainMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class TrainTicketBookingData {
    DatabaseHelper db;
    
    public TrainTicketBookingData(){
        db = new DatabaseHelper();
        
    }
    
       public ArrayList<DbClasses.TrainTicketBooking> getBookings() {
        ArrayList<DbClasses.TrainTicketBooking> bookings = new ArrayList<TrainTicketBooking>();
        

        ResultSet rs = db.getResultSet("Select * From TrainTicketBooking");
        TrainTicketBooking booking;

        try {
            while (rs.next()) {
                booking = new TrainTicketBooking();
                booking.setTrainId(rs.getInt("TrainId"));
                booking.setBookingId(rs.getInt("BookingId"));
                booking.setAge(rs.getInt("Age"));
                booking.setPasssengerName(rs.getString("PassengerName"));
                booking.setSC(rs.getBoolean("SC"));
                booking.setScheduleId(rs.getInt("ScheduleId"));
                booking.setSex(rs.getString("Sex"));
                booking.setTicketId(rs.getInt("TicketId"));
                
                bookings.add(booking);
            }
        } catch (SQLException se) {
        }
        return bookings;
    }

           public TrainTicketBooking getBooking(int bookingId) {

           
        ResultSet rs = db.getResultSet("Select * From TrainTicketBooking where BookingID = "+bookingId);
        TrainTicketBooking booking = new TrainTicketBooking();

        try {
            while (rs.next()) {

              booking = new TrainTicketBooking();
                booking.setTrainId(rs.getInt("TrainId"));
                booking.setBookingId(rs.getInt("BookingId"));
                booking.setAge(rs.getInt("Age"));
                booking.setPasssengerName(rs.getString("PassengerName"));
                booking.setSC(rs.getBoolean("SC"));
                booking.setScheduleId(rs.getInt("ScheduleId"));
                booking.setSex(rs.getString("Sex"));
                booking.setTicketId(rs.getInt("TicketId"));
                
            }
        } catch (SQLException se) {
        }
        return booking;
    }

    
}
