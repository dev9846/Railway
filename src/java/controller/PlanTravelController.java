/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DbClasses.*;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Dhara
 */
@WebServlet(name = "PlanTravelController", urlPatterns = {"/PlanTravelController"})
public class PlanTravelController extends HttpServlet {

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

        String listOrFare = request.getParameter("listOrFare");
        if (listOrFare.equals("List")) {
            showTrainList(request, response);
        } else if (listOrFare.equals("Fare")) {
            showFareAndAvailability(request, response);
        }

    }

    public void showTrainList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String stnFrom = request.getParameter("txtStationFrom");
            String stnTo = request.getParameter("txtStationTo");
            String date = request.getParameter("txtDate");

            StationMasterData objSMD = new StationMasterData();
            StationMaster stationFrom = objSMD.getStation(stnFrom);
            StationMaster stationTo = objSMD.getStation(stnTo);

            BookingDetails bookingDetails;
            /*
             if(request.getSession().getAttribute("BookingDetails") == null){
             bookingDetails = new BookingDetails();
             }
             else{
             bookingDetails = (BookingDetails)request.getSession().getAttribute("BookingDetails");
             }*/

            ArrayList<TrainMaster> arrTrains = new TrainMasterData().getTrains();
            ArrayList<TrainSchedule> arrSchedules = new TrainScheduleData().getSchedules();

            ArrayList<BookingDetails> arrBookingDetails = new ArrayList<BookingDetails>();

            int count, fromDistance, toDistance;

            for (TrainMaster train : arrTrains) {
                count = 0;
                toDistance = 0;
                fromDistance = 0;
                bookingDetails = new BookingDetails();
                for (TrainSchedule schedule : arrSchedules) {
                    if (schedule.getTrainId() == train.getTrainId() && schedule.getTrainDate().equals(date)) {
                        if (schedule.getStationId() == stationFrom.getStationId()) {
                            count = 1;
                            bookingDetails.setDepartureTime(schedule.getDeparture());
                            fromDistance = schedule.getDistance();
                            continue;
                        }
                        if (schedule.getStationId() == stationTo.getStationId()) {
                            if (count == 1) {
                                count = 2;
                                bookingDetails.setArrivalTime(schedule.getArrivalTime());
                                toDistance = schedule.getDistance();
                                break;
                            }
                        }
                    }
                }
                if (count == 2) {
                    bookingDetails.setTrainDate(date);
                    bookingDetails.setTrainName(train.getTrainName());
                    bookingDetails.setTrainNo(train.getTrainNumber());
                    bookingDetails.setTrainType(train.getTrainType());
                    bookingDetails.setStationFrom(stnFrom);
                    bookingDetails.setStationTo(stnTo);
                    bookingDetails.setTrainId(train.getTrainId());
                    bookingDetails.setDistance(toDistance - fromDistance);
                    arrBookingDetails.add(bookingDetails);
                }
            }

            TicketBookingMaster objTBM;
            TicketBookingMasterData objTBMData = new TicketBookingMasterData();
            String innerList = "<div style=\"margin: 0 auto; width: 150px\" ><h4 style=\"color: #4391df\">List of Trains</h4></div>\n<br />\n";
            innerList += "                <table>\n"
                    + "                    <th style=\"width: 80px;\">Train No</th>\n"
                    + "                    <th style=\"width: 150px;\">Train Name</th>\n"
                    + "                    <th style=\"width: 80px;\">Departs</th>\n"
                    + "                    <th style=\"width: 80px;\">Arrives</th>\n"
                    + "                    <th style=\"width: 40px;\">1A</th>\n"
                    + "                    <th style=\"width: 40px;\">FC</th>\n"
                    + "                    <th style=\"width: 40px;\">2A</th>\n"
                    + "                    <th style=\"width: 40px;\">3A</th>\n"
                    + "                    <th style=\"width: 40px;\">3E</th>\n"
                    + "                    <th style=\"width: 40px;\">CC</th>\n"
                    + "                    <th style=\"width: 40px;\">SL</th>\n"
                    + "                    <th style=\"width: 40px;\">2S</th>\n";
            count = 1;

            for (BookingDetails bd : arrBookingDetails) {
                objTBM = objTBMData.getTBMDetails(bd.getTrainId(), bd.getTrainDate());
                innerList += "                    <tr>\n"
                        + "                        <td>" + bd.getTrainNo() + "</td>\n"
                        + "                        <td>" + bd.getTrainName() + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + bd.getDepartureTime() + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + bd.getArrivalTime() + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("1A", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("FC", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("2A", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("3A", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("3E", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("CC", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("SL", objTBM, count) + "</td>\n"
                        + "                        <td style=\"text-align: center;\">" + getTrainClassValue("2S", objTBM, count) + "</td>\n"
                        + "                    </tr>\n";
                count++;
            }
            innerList += "</table>";

            request.getSession().setAttribute("BookingDetails", arrBookingDetails);
            out.print(innerList);
            //ArrayList<StationMaster> arrStations = request.getSession();
        } finally {
            out.close();
        }
    }

    public void showFareAndAvailability(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            ArrayList<BookingDetails> arrBookingDetails = (ArrayList<BookingDetails>) request.getSession().getAttribute("BookingDetails");

            String rdId = request.getParameter("rdId");
            
            int index = Integer.parseInt(rdId.substring(4));

            BookingDetails bd = arrBookingDetails.get(index - 1);
            
            bd.setSeatClass(rdId.substring(2, rdId.length() - 1));
             
            TicketFare ticketFare = new model.TicketFareData().getTicketFare(bd.getTrainId());

            TicketBookingMaster tbm = new model.TicketBookingMasterData().getTBMDetails(bd.getTrainId(), bd.getTrainDate());

            String innerText = "<div class=\"seatInfo\" id=\"divSeatInfo\">\n"
                    + "                    <div style=\"margin: 0 auto; width: 70px\" ><h4 style=\"color: #4391df\">Seat Info</h4></div>\n"
                    + "                    <table style=\"width: 330px; padding: 0px; margin: 0px\">\n"
                    + "                        <tr>\n"
                    + "                            <td>\n"
                    + "                                <h5>" + bd.getTrainDate() + "</h5>\n"
                    + "                            </td>\n"
                    + "                            <td>\n"
                    + "                                <h5>Available - " + getTicketsAvailable(bd.getSeatClass(), tbm) + "</h5>\n"
                   // + "                            </td>\n"
                    //+ "                            <td>\n" 
                    //+ "                        </tr>\n"
                    //+ "                        <tr>\n"
                    + "                            </td>\n"
                    + "                            <td>\n"
                    + "                            <input style=\"width: 30px; height: 22px\" type=\"text\" id=\"txtQty\" placeholder=\"Qty\" class=\"textbox\" />"
                    + "                            </td>\n"
                    + "                            <td>\n"
                    + "                                <input type=\"submit\" style=\"width: 70px; height:25px; float: right\" value=\"Book\" onclick=\"btnBookTicketClick();\" class=\"bookButtonLink\"/>\n"
                    + "                            </td>\n"
                    + "                        </tr>\n"
                    + "                    </table>\n"
                    + "                </div>\n"
                    + "\n"
                    + "                <div class=\"fareInfo\" id=\"divFareInfo\">";
            innerText += " <div style=\"margin: 0 auto; width: 70px\" ><h4 style=\"color: #4391df\">Fare Info</h4></div>\n"
                    + "                  <table style=\"width: 280px\">\n"
                    + "                      <tr>\n"
                    + "                          <td>\n"
                    + "                              <b>Fare: </b> " + getFare(ticketFare, bd.getSeatClass()) + "\n"
                    + "                              \n"
                    + "                          </td>\n"
                    + "                          <td>\n"
                    + "                              <b>Class: </b> " + bd.getSeatClass() + "\n"
                    + "                          </td>\n"
                    + "                      </tr>\n"
                    + "                      <tr>\n"
                    + "                          <td>\n"
                    + "                              <b>From: </b> " + bd.getStationFrom() + "\n"
                    + "                          </td>\n"
                    + "                          <td>\n"
                    + "                              <b>To: </b>  " + bd.getStationTo() + "\n"
                    + "                          </td>\n"
                    + "                      </tr>\n"
                    + "                      <tr>\n"
                    + "                          <td>\n"
                    + "                              <b>Train Name:<br /> </b> " + bd.getTrainName() + "\n"
                    + "                          </td>\n"
                    + "                          <td>\n"
                    + "                              <b>Train No:<br /> </b> " + bd.getTrainNo() + "\n"
                    + "                          </td>\n"
                    + "                      </tr>\n"
                    + "                      <tr>\n"
                    + "                          <td>\n"
                    + "                              <b>Train Type: </b> " + bd.getTrainType() + "\n"
                    + "                          </td>\n"
                    + "                          <td>\n"
                    + "                              <b>Distance: </b> " + bd.getDistance() + " Kms\n"
                    + "                          </td>\n"
                    + "                      </tr>\n"
                    + "                  </table></div>";
            
            //ArrayList<BookingDetails> arr = new ArrayList<BookingDetails>();
            //arr.add(bd);
            
            arrBookingDetails.set(index - 1, bd);
             request.getSession().setAttribute("BookingDetails", arrBookingDetails);
             request.getSession().setAttribute("SelectedBooking", bd);
            out.print(innerText);
        }catch(Exception ex){
            
        }
        finally {
            out.close();
        }
    }

    public void showBooking(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            response.sendRedirect(request.getContextPath() + "/BookingConfirmation.jsp");
        }catch(Exception ex){
            
        }
        finally {
            out.close();
        }
    }
    
    public int getTicketsAvailable(String seatClass, TicketBookingMaster tbm) {
        if (seatClass.equals("1A")) {
            return tbm.get1A();
        } else if (seatClass.equals("2A")) {
            return tbm.get2A();
        } else if (seatClass.equals("3A")) {
            return tbm.get3A();
        } else if (seatClass.equals("3E")) {
            return tbm.get3E();
        } else if (seatClass.equals("CC")) {
            return tbm.getCC();
        } else if (seatClass.equals("SL")) {
            return tbm.getSL();
        } else {
            return tbm.get2S();
        }
    }

    public int getFare(TicketFare tf, String seatClass) {
        if (seatClass.equals("1A")) {
            return tf.get1A();
        } else if (seatClass.equals("2A")) {
            return tf.get2A();
        } else if (seatClass.equals("3A")) {
            return tf.get3A();
        } else if (seatClass.equals("3E")) {
            return tf.get3E();
        } else if (seatClass.equals("CC")) {
            return tf.getCC();
        } else if (seatClass.equals("SL")) {
            return tf.getSL();
        } else {
            return tf.get2S();
        }
    }

    public String getTrainClassValue(String trainClass, TicketBookingMaster tmb, int count) {
        String value = "";
        if (trainClass.equals("1A")) {
            if (tmb.get1A() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rd1A" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("2A")) {
            if (tmb.get2A() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rd2A" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("2S")) {
            if (tmb.get2S() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rd2S" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("3A")) {
            if (tmb.get3A() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rd3A" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("3E")) {
            if (tmb.get3E() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rd3E" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("CC")) {
            if (tmb.getCC() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rdCC" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("FC")) {
            if (tmb.getFC() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rdFC" + count + "\"/ onclick=\"rdoClick(this.id)\" />";
            }
        }
        if (trainClass.equals("SL")) {
            if (tmb.getSL() == 0) {
                value = "X";
            } else {
                value = "<input name=\"rd\" type=\"radio\" id=\"rdSL" + count + "\" onclick=\"rdoClick(this.id)\" />";
            }
        }

        return value;
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
