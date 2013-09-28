/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TrainSchedule;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Dev
 */
public class TrainScheduleData {
    DatabaseHelper db;
    
    public TrainScheduleData(){
        
        db = new DatabaseHelper();
        
    }
    
    public ArrayList<DbClasses.TrainSchedule> getSchedules() {
        ArrayList<DbClasses.TrainSchedule> schedules = new ArrayList<TrainSchedule>();
        

        ResultSet rs = db.getResultSet("Select * From TrainSchedule");
        TrainSchedule schedule;

        try {
            while (rs.next()) {
                schedule = new TrainSchedule();
                schedule.setScheduleId(rs.getInt("ScheduleId"));
                schedule.setTrainId(rs.getInt("TrainId"));
                schedule.setTrainDate(rs.getString("TrainDate"));
                schedule.setArrivalTime(rs.getString("ArrivalTime"));
                schedule.setDeparture(rs.getString("Departure"));
                schedule.setDistance(rs.getInt("Distance"));
                schedule.setStationId(rs.getInt("StationId"));
                
                
                schedules.add(schedule);
            }
        } catch (SQLException se) {
        }
        return schedules;
    }

      public TrainSchedule getSchedule(int scheduleId) {

           
        ResultSet rs = db.getResultSet("Select * From TrainSchedule where ScheduleId = "+scheduleId);
        TrainSchedule schedule = new TrainSchedule();

        try {
            while (rs.next()) {

                schedule = new TrainSchedule();
                schedule.setScheduleId(rs.getInt("ScheduleId"));
                schedule.setTrainId(rs.getInt("TrainId"));
                schedule.setTrainDate(rs.getString("TrainDate"));
                schedule.setArrivalTime(rs.getString("ArrivalTime"));
                schedule.setDeparture(rs.getString("Departure"));
                schedule.setDistance(rs.getInt("Distance"));
                schedule.setStationId(rs.getInt("StationId"));
                
            }
        } catch (SQLException se) {
        }
        return schedule;
    }


      public TrainSchedule getScheduleByStation(int stationId) {

           
        ResultSet rs = db.getResultSet("Select * From TrainSchedule where StationId = "+stationId);
        TrainSchedule schedule = new TrainSchedule();

        try {
            while (rs.next()) {

                schedule = new TrainSchedule();
                schedule.setScheduleId(rs.getInt("ScheduleId"));
                schedule.setTrainId(rs.getInt("TrainId"));
                schedule.setTrainDate(rs.getString("TrainDate"));
                schedule.setArrivalTime(rs.getString("ArrivalTime"));
                schedule.setDeparture(rs.getString("Departure"));
                schedule.setDistance(rs.getInt("Distance"));
                schedule.setStationId(rs.getInt("StationId"));
                
            }
        } catch (SQLException se) {
        }
        return schedule;
    }

      
      public TrainSchedule getScheduleByDate(String date) {

           
        ResultSet rs = db.getResultSet("Select * From TrainSchedule where TrainDate= "+date);
        TrainSchedule schedule = new TrainSchedule();

        try {
            while (rs.next()) {

                schedule = new TrainSchedule();
                schedule.setScheduleId(rs.getInt("ScheduleId"));
                schedule.setTrainId(rs.getInt("TrainId"));
                schedule.setTrainDate(rs.getString("TrainDate"));
                schedule.setArrivalTime(rs.getString("ArrivalTime"));
                schedule.setDeparture(rs.getString("Departure"));
                schedule.setDistance(rs.getInt("Distance"));
                schedule.setStationId(rs.getInt("StationId"));
                
            }
        } catch (SQLException se) {
        }
        return schedule;
    }

   
    
}
