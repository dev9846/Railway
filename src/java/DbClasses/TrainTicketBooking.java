/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbClasses;

/**
 *
 * @author Dev
 */
public class TrainTicketBooking {
    
    private int bookingId, trainId, ticketBookingMasterId, scheduleToId, scheduleFromId, ticketFareId, userId ;
    private String BookingDate ;

    /**
     * @return the bookingId
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * @param bookingId the bookingId to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * @return the trainId
     */
    public int getTrainId() {
        return trainId;
    }

    /**
     * @param trainId the trainId to set
     */
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    /**
     * @return the ticketBookingMasterId
     */
    public int getTicketBookingMasterId() {
        return ticketBookingMasterId;
    }

    /**
     * @param ticketBookingMasterId the ticketBookingMasterId to set
     */
    public void setTicketBookingMasterId(int ticketBookingMasterId) {
        this.ticketBookingMasterId = ticketBookingMasterId;
    }

    /**
     * @return the ticketFareId
     */
    public int getTicketFareId() {
        return ticketFareId;
    }

    /**
     * @param ticketFareId the ticketFareId to set
     */
    public void setTicketFareId(int ticketFareId) {
        this.ticketFareId = ticketFareId;
    }

    /**
     * @return the BookingDate
     */
    public String getBookingDate() {
        return BookingDate;
    }

    /**
     * @param BookingDate the BookingDate to set
     */
    public void setBookingDate(String BookingDate) {
        this.BookingDate = BookingDate;
    }

    /**
     * @return the scheduleToId
     */
    public int getScheduleToId() {
        return scheduleToId;
    }

    /**
     * @param scheduleToId the scheduleToId to set
     */
    public void setScheduleToId(int scheduleToId) {
        this.scheduleToId = scheduleToId;
    }

    /**
     * @return the scheduleFrom
     */
    public int getScheduleFromId() {
        return scheduleFromId;
    }

    /**
     * @param scheduleFrom the scheduleFrom to set
     */
    public void setScheduleFromId(int scheduleFromId) {
        this.scheduleFromId = scheduleFromId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
