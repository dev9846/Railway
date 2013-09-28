/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DbClasses;

/**
 *
 * @author Dev
 */
public class TrainSchedule {
    
    private int scheduleId,trainId,stationId,distance;
    private String trainDate, arrivalTime, departure ;

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
     * @return the stationId
     */
    public int getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the trainDate
     */
    public String getTrainDate() {
        return trainDate;
    }

    /**
     * @param trainDate the trainDate to set
     */
    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    /**
     * @return the arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the departure
     */
    public String getDeparture() {
        return departure;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    
    
}
