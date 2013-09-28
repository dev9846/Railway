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
    
    private int bookingId, trainId, ticketId, scheduleId, age ;
    private String PasssengerName, sex ;
    private boolean SC ;

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
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the scheduleId
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId the scheduleId to set
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the PasssengerName
     */
    public String getPasssengerName() {
        return PasssengerName;
    }

    /**
     * @param PasssengerName the PasssengerName to set
     */
    public void setPasssengerName(String PasssengerName) {
        this.PasssengerName = PasssengerName;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the SC
     */
    public boolean isSC() {
        return SC;
    }

    /**
     * @param SC the SC to set
     */
    public void setSC(boolean SC) {
        this.SC = SC;
    }
    
    
}
