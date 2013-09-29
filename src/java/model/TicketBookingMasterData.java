/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TicketBookingMaster;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class TicketBookingMasterData {

    DatabaseHelper db;

    public TicketBookingMasterData() {
        db = new DatabaseHelper();
    }

    public ArrayList<TicketBookingMaster> getAllTBMDetails() {
        ArrayList<TicketBookingMaster> lstTbm = new ArrayList<TicketBookingMaster>();


        ResultSet rs = db.getResultSet("Select * From TicketBookingMaster");
        TicketBookingMaster tbm;

        try {
            while (rs.next()) {
                tbm = new TicketBookingMaster();
                tbm.setTrainId(rs.getInt("TrainId"));
                tbm.setTicketBookingMasterId(rs.getInt("TicketBookingId"));
                tbm.setTrainDate(rs.getString("TrainDate"));
                tbm.setTotalTickets(rs.getInt("TotalTickets"));
                tbm.set1A(rs.getInt("1A"));
                tbm.set2A(rs.getInt("2A"));
                tbm.set2S(rs.getInt("2S"));
                tbm.set3A(rs.getInt("3A"));
                tbm.set3E(rs.getInt("3E"));
                tbm.setCC(rs.getInt("CC"));
                tbm.setFC(rs.getInt("FC"));
                tbm.setSL(rs.getInt("SL"));
                tbm.setTicketsBooked(rs.getInt("TicketsBooked"));

                lstTbm.add(tbm);
            }
        } catch (SQLException se) {
        }
        return lstTbm;
    }

    public TicketBookingMaster getTBMDetails(int trainId, String trainDate) {

        ResultSet rs = db.getResultSet("Select * From TicketBookingMaster Where TrainId =  " + trainId + " and TrainDate = '" + trainDate + "'");
        TicketBookingMaster tbm = new TicketBookingMaster();

        try {
            while (rs.next()) {
                tbm.setTrainId(rs.getInt("TrainId"));
                tbm.setTicketBookingMasterId(rs.getInt("TicketBookingId"));
                tbm.setTrainDate(rs.getString("TrainDate"));
                tbm.setTotalTickets(rs.getInt("TotalTickets"));
                tbm.set1A(rs.getInt("1A"));
                tbm.set2A(rs.getInt("2A"));
                tbm.set2S(rs.getInt("2S"));
                tbm.set3A(rs.getInt("3A"));
                tbm.set3E(rs.getInt("3E"));
                tbm.setCC(rs.getInt("CC"));
                tbm.setFC(rs.getInt("FC"));
                tbm.setSL(rs.getInt("SL"));
                tbm.setTicketsBooked(rs.getInt("TicketsBooked"));
            }
        } catch (SQLException se) {
        }
        return tbm;
    }

    public void updateTicketBookingMaster(TicketBookingMaster tbm) {
        ResultSet rs = db.getResultSet("Update TicketBookingMaster SET 1A = " + tbm.get1A() + ", 2A = " + tbm.get2A() + ", 2S = " + tbm.get2S() + ", 3A = " + tbm.get3A() + ", 3E = " + tbm.get3E() + ", CC = " + tbm.getCC() + ", FC = " + tbm.getFC() + ", SL = " + tbm.getSL() + ", TicketsBooked = " + tbm.getTicketsBooked() + "");
        
    }
}
