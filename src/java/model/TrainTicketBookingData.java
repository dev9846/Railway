/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TrainTicketBooking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dev
 */
public class TrainTicketBookingData {
    
    DatabaseHelper db;
    
    public TrainTicketBookingData() {
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
                booking.setUserId(rs.getInt("UserId"));
                booking.setScheduleFromId(rs.getInt("ScheduleFromId"));
                booking.setScheduleToId(rs.getInt("ScheduleToId"));
                booking.setTicketFareId(rs.getInt("TicketFareId"));
                booking.setTicketBookingMasterId(rs.getInt("TicketBookingMasterId"));
                booking.setBookingDate(rs.getString("BookingDate"));
                booking.setQuantity(rs.getInt("Quantity"));
                
                bookings.add(booking);
            }
        } catch (SQLException se) {
        }
        return bookings;
    }
    
    public TrainTicketBooking getBooking(int bookingId) {
        
        
        ResultSet rs = db.getResultSet("Select * From TrainTicketBooking where BookingID = " + bookingId);
        TrainTicketBooking booking = new TrainTicketBooking();
        
        try {
            while (rs.next()) {
                
                booking = new TrainTicketBooking();
                booking.setTrainId(rs.getInt("TrainId"));
                booking.setBookingId(rs.getInt("BookingId"));
                booking.setScheduleFromId(rs.getInt("ScheduleFromId"));
                booking.setScheduleToId(rs.getInt("ScheduleToId"));
                booking.setUserId(rs.getInt("UserId"));
                booking.setTicketFareId(rs.getInt("TicketFareId"));
                booking.setTicketBookingMasterId(rs.getInt("TicketBookingMasterId"));
                booking.setBookingDate(rs.getString("BookingDate"));
                booking.setQuantity(rs.getInt("Quantity"));
                
            }
        } catch (SQLException se) {
        }
        return booking;
    }
    
    public int getCurrentBookingId() {
        ResultSet rs = db.getResultSet("Select MAX(BookingId) From TrainTicketBooking");
        int bkId = 0;
        try {
            while (rs.next()) {
                bkId = rs.getInt("BookingId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainTicketBookingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bkId;
    }
    
    public void insertTrainTicketBooking(TrainTicketBooking ttb) {
        db.getResultSet("Insert into TrainTicketBooking Values(null, " + ttb.getTrainId() + ", " + ttb.getTicketFareId() + "," + ttb.getScheduleFromId() + ", " + ttb.getScheduleToId() + ", " + ttb.getTicketBookingMasterId() + ", '" + ttb.getBookingDate() + "', " + ttb.getUserId() + ", "+ttb.getQuantity()+")");
    }
}
