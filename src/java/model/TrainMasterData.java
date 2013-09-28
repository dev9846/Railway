/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TrainMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Dev
 */
public class TrainMasterData {
    
   DatabaseHelper db ;
    
   public TrainMasterData()
   {
        db = new DatabaseHelper();
   }
   
   public ArrayList<DbClasses.TrainMaster> getTrains() {
        ArrayList<DbClasses.TrainMaster> trains = new ArrayList<TrainMaster>();
        

        ResultSet rs = db.getResultSet("Select * From trainmaster");
        TrainMaster train;

        try {
            while (rs.next()) {
                train = new TrainMaster();
                train.setTrainId(rs.getInt("TrainId"));
                train.setTrainName(rs.getString("TrainName"));
                train.setTrainNumber(rs.getInt("TrainNumber"));
                train.setTrainType(rs.getString("TrainType"));
                
                trains.add(train);
            }
        } catch (SQLException se) {
        }
        return trains;
    }

    public TrainMaster getTrain(int trainId) {

           
        ResultSet rs = db.getResultSet("Select * From TrainMaster where TrainId = "+trainId);
        TrainMaster train = new TrainMaster();

        try {
            while (rs.next()) {

               train.setTrainId(rs.getInt("TrainId"));
               train.setTrainName(rs.getString("TrainName"));
                train.setTrainNumber(rs.getInt("TrainNumber"));
                train.setTrainType(rs.getString("TrainType"));
                
            }
        } catch (SQLException se) {
        }
        return train;
    }


    public TrainMaster getTrain(String trainname) {

           
        ResultSet rs = db.getResultSet("Select * From TrainMaster where TrainName = "+trainname);
        TrainMaster train = new TrainMaster();

        try {
            while (rs.next()) {

                train.setTrainId(rs.getInt("TrainId"));
               train.setTrainName(rs.getString("TrainName"));
                train.setTrainNumber(rs.getInt("TrainNumber"));
                train.setTrainType(rs.getString("TrainType"));
                
            }
        } catch (SQLException se) {
        }
        return train;
    }
   
}
