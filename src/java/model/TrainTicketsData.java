/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DbClasses.TrainTickets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class TrainTicketsData {

    DatabaseHelper db;

    public TrainTicketsData() {

        db = new DatabaseHelper();
    }

    public ArrayList<DbClasses.TrainTickets> getTrainTickets() {
        ArrayList<DbClasses.TrainTickets> tickets = new ArrayList<TrainTickets>();


        ResultSet rs = db.getResultSet("Select * From TrainTickets");
        TrainTickets ticket;

        try {
            while (rs.next()) {
                ticket = new TrainTickets();
                ticket.setTicketId(rs.getInt("ticketId"));
                ticket.setTrainId(rs.getInt("TrainID"));
                ticket.set1A(rs.getInt("1A"));
                ticket.setFC(rs.getInt("FC"));
                ticket.set2A(rs.getInt("2A"));
                ticket.set3A(rs.getInt("3A"));
                ticket.set3E(rs.getInt("3E"));
                ticket.setCC(rs.getInt("CC"));
                ticket.setSL(rs.getInt("SL"));
                ticket.set2S(rs.getInt("2S"));
                ticket.setTotalTickets(rs.getInt("TotalTickets"));

                tickets.add(ticket);
            }
        } catch (SQLException se) {
        }
        return tickets;
    }

    public TrainTickets getTrainTicket(int ticketId) {


        ResultSet rs = db.getResultSet("Select * From traintickets where TicketId = " + ticketId);
        TrainTickets ticket = new TrainTickets();

        try {
            while (rs.next()) {

                ticket.setTicketId(rs.getInt("ticketId"));
                ticket.setTrainId(rs.getInt("TrainID"));
                ticket.set1A(rs.getInt("1A"));
                ticket.setFC(rs.getInt("FC"));
                ticket.set2A(rs.getInt("2A"));
                ticket.set3A(rs.getInt("3A"));
                ticket.set3E(rs.getInt("3E"));
                ticket.setCC(rs.getInt("CC"));
                ticket.setSL(rs.getInt("SL"));
                ticket.set2S(rs.getInt("2S"));
                ticket.setTotalTickets(rs.getInt("TotalTickets"));

            }
        } catch (SQLException se) {
        }
        return ticket;
    }
}
