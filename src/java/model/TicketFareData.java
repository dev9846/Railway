/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TicketFare;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class TicketFareData {

    DatabaseHelper db;

    public TicketFareData() {
        db = new DatabaseHelper();
    }

    public ArrayList<TicketFare> getAllTicketFares() {
        ArrayList<TicketFare> lstTbm = new ArrayList<TicketFare>();


        ResultSet rs = db.getResultSet("Select * From TicketFare");
        TicketFare tbm;
        try {
            while (rs.next()) {
                tbm = new TicketFare();
                tbm.setTrainId(rs.getInt("TrainId"));
                tbm.setTicketFareId(rs.getInt("TicketFareId"));
                tbm.set1A(rs.getInt("1A"));
                tbm.set2A(rs.getInt("2A"));
                tbm.set2S(rs.getInt("2S"));
                tbm.set3A(rs.getInt("3A"));
                tbm.set3E(rs.getInt("3E"));
                tbm.setCC(rs.getInt("CC"));
                tbm.setFC(rs.getInt("FC"));
                tbm.setSL(rs.getInt("SL"));

                lstTbm.add(tbm);
            }
        } catch (SQLException se) {
        }
        return lstTbm;
    }

    public TicketFare getTicketFare(int trainId) {

        ResultSet rs = db.getResultSet("Select * From TicketFare Where TrainId = " + trainId);
        TicketFare tbm = new TicketFare();
        try {
            while (rs.next()) {

                tbm.setTrainId(rs.getInt("TrainId"));
                tbm.setTicketFareId(rs.getInt("TicketFareId"));
                tbm.set1A(rs.getInt("1A"));
                tbm.set2A(rs.getInt("2A"));
                tbm.set2S(rs.getInt("2S"));
                tbm.set3A(rs.getInt("3A"));
                tbm.set3E(rs.getInt("3E"));
                tbm.setCC(rs.getInt("CC"));
                tbm.setFC(rs.getInt("FC"));
                tbm.setSL(rs.getInt("SL"));
            }
        } catch (SQLException se) {
            System.out.println(""+se);
        }
         catch(Exception ex){
            System.out.print(ex);
        }
        return tbm;
    }
}
