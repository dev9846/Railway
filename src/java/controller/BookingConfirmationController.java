/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DbClasses.BookingDetails;
import DbClasses.TicketBookingMaster;
import DbClasses.TrainTicketBooking;
import DbClasses.UserT;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TicketBookingMasterData;
import model.TrainTicketBookingData;

/**
 *
 * @author Dev
 */
@WebServlet(name = "BookingConfirmationController", urlPatterns = {"/BookingConfirmationController"})
public class BookingConfirmationController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loadData = request.getParameter("load");
        if (loadData.equals("True")) {
            showBookingDetails(request, response);
        } else {
            showBookingConfirmation(request, response);
        }
        
    }

    public void showBookingDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DbClasses.BookingDetails bd = (BookingDetails) request.getSession().getAttribute("SelectedBooking");
            String qty = request.getParameter("qty");
            //int qty = Integer.parseInt(request.getParameter("qty"));

            bd.setQty(1);

            UserT user = (UserT) request.getSession().getAttribute("User");

            TicketBookingMaster tmb = new TicketBookingMasterData().getTBMDetails(bd.getTrainId(), bd.getTrainDate());

            if (bd.getSeatClass().equals("1A")) {
                tmb.set1A(tmb.get1A() - bd.getQty());
            } else if (bd.getSeatClass().equals("2A")) {
                tmb.set2A(tmb.get2A() - bd.getQty());
            } else if (bd.getSeatClass().equals("3A")) {
                tmb.set3A(tmb.get3A() - bd.getQty());
            } else if (bd.getSeatClass().equals("3E")) {
                tmb.set3E(tmb.get3E() - bd.getQty());
            } else if (bd.getSeatClass().equals("2S")) {
                tmb.set2S(tmb.get2S() - bd.getQty());
            } else if (bd.getSeatClass().equals("CC")) {
                tmb.setCC(tmb.getCC() - bd.getQty());
            } else if (bd.getSeatClass().equals("FC")) {
                tmb.setFC(tmb.getFC() - bd.getQty());
            } else {
                tmb.setSL(tmb.getSL() - bd.getQty());
            }
            tmb.setTotalTickets(tmb.getTotalTickets() - bd.getQty());
            tmb.setTicketsBooked(tmb.getTicketsBooked() + bd.getQty());

            TrainTicketBooking ttb = new TrainTicketBooking();
            ttb.setTrainId(bd.getTrainId());
            ttb.setTicketFareId(bd.getTicketFareId());
            ttb.setScheduleFromId(bd.getScheduleFromId());
            ttb.setScheduleToId(bd.getScheduleToId());
            ttb.setTicketBookingMasterId(tmb.getTicketBookingMasterId());
            ttb.setBookingDate(bd.getTrainDate());
            ttb.setUserId(user.getUserId());
            ttb.setQuantity(bd.getQty());

            request.getSession().setAttribute("FinalTMB", tmb);
            request.getSession().setAttribute("FinalTTB", ttb);

            String innerText = "<h2 style=\"color: #4391df; font-family: 'calibri', cursive; font-size: 30px; margin: 0 auto; width: 290px\">Booking Confirmation</h2>\n"
                    + "            <table class=\"bookingTable\">";
            innerText += "<table class=\"bookingTable\">\n"
                    + "                <tr>\n"
                    + "                    <td class=\"bookingTableTd\" style=\"font-size: 20px;\" colspan=\"4\">\n"
                    + "                        Booking Details\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Passenger Name:\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">" + user.getName() + "</td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Total Passengers: \n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getQty() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr style=\"margin-top: 10px; \">\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Train No\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getTrainNo() + "\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Train Name: \n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getTrainName() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr style=\"margin-top: 10px; \">\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Ticket Fare\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        Rs. " + bd.getFare() * bd.getQty() + "\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Train Class \n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getSeatClass() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr style=\"margin-top: 10px; \">\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Distance\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getDistance() + " Kms\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Train Type \n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getTrainType() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr style=\"margin-top: 10px; \">\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        From\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getStationFrom() + "\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        To\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getStationTo() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr style=\"margin-top: 10px; \">\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Departs At\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getDepartureTime() + "\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Arrives At\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\">\n"
                    + "                        " + bd.getArrivalTime() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "                <tr>\n"
                    + "                    <td class=\"bookingTableTd\">\n"
                    + "                        Date\n"
                    + "                    </td>\n"
                    + "                    <td class=\"bookingTableOtherTd\" colspan=\"4\">\n"
                    + "                        " + bd.getTrainDate() + "\n"
                    + "                    </td>\n"
                    + "                </tr>\n"
                    + "            </table>\n"
                    + "            <div style=\"margin-top: 10px; width:100px; margin: 0 auto;\">\n"
                    + "                <input class=\"newButtonLink\" type=\"submit\" onclick=\"btnConfirmBookingClick()\" value=\"Confirm Booking\" id=\"btnConfirmBooking\" />\n"
                    + "            </div>";
            out.print(innerText);
        }catch(Exception ex){
            System.out.println(ex);
        } 
        finally {
            out.close();
        }
    }

    public void showBookingConfirmation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            TicketBookingMaster tmb = (TicketBookingMaster)request.getSession().getAttribute("FinalTMB");
            TrainTicketBooking ttb = (TrainTicketBooking)request.getSession().getAttribute("FinalTTB");
            
            new TicketBookingMasterData().updateTicketBookingMaster(tmb);
            TrainTicketBookingData objTTB = new TrainTicketBookingData();
            objTTB.insertTrainTicketBooking(ttb);
            int bkId = objTTB.getCurrentBookingId();
            out.print(bkId);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
