<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan My Travel</title>
        <link rel="stylesheet" href="css/railway.css" type="text/css" />
        <script type="text/javascript" src="includes/railway.js"></script>
        <script type="text/javascript" src="includes/jquery-1.10.2.min.js"></script>
    </head>
    <body>
        <div class="center">
            <%@include file="includes/header.jsp" %>
            <br/>
            <div class="fromTo">
                <h4 style="font-family: calibri">Station From</h4>
                <input type="text" name="txtStationFrom" id="txtStationFrom" value="Pune" placeholder="Station From" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Station To</h4>
                <input type="text" name="txtStationTo" placeholder="Station To" value="Dadar" id="txtStationTo" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Date</h4>
                <input type="text" name="txtDate" placeholder="Date" id="txtDate" value="29/09/2013" class="textbox"/>
                <br/>
                <br/>
                <div style="margin: 0 auto; width: 100px ">
                    <input type="submit" name="Find" value="Find" onclick="btnFindClick();" class="newButtonLink" />
                </div>
            </div>
            <div id="divFareAndSeats">
                <div class="seatInfo" id="divSeatInfo">
                    <div style="margin: 0 auto; width: 70px" ><h4 style="color: #4391df">Seat Info</h4></div>
                    <table style="width: 280px; padding: 0px; margin: 0px">
                        <tr>
                            <td style="">
                                <h5>28/9/2013</h5>
                            </td>
                            <td>
                                <h5>Available - 100</h5>
                            
                        <input type="text" class="textbox" style="width: 30px; height: 25px;" id="txtQty" placeholder="Qty" />
                        <input type="submit" style="width: 70px; height:25px; float: right" value="Book" class="bookButtonLink"/>
                        </td>
                        </tr>
                    </table>
                </div>

                <div class="fareInfo" id="divFareInfo">
                    <div style="margin: 0 auto; width: 70px" ><h4 style="color: #4391df">Fare Info</h4></div>
                    <table style="width: 280px">
                        <tr>
                            <td>
                                <b>Fare: </b> Rs. 100

                            </td>
                            <td>
                                <b>Class: </b> 2S
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>From: </b> PUNE
                            </td>
                            <td>
                                <b>To: </b>  Dadar
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Train Name: </b> Intercity
                            </td>
                            <td>
                                <b>Train No: </b> 10111
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <b>Train: </b> Super Fast
                            </td>
                            <td>
                                <b>Distance: </b> 200 KMS
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <br/>
            <div class="trainList" id="divListOfTrains">
                <div style="margin: 0 auto; width: 150px" ><h4 style="color: #4391df">List of Trains</h4></div>
                <br />
                <table>
                    <th style="width: 80px;">Train No</th>
                    <th style="width: 150px;">Train Name</th>
                    <th style="width: 80px;">Departs</th>
                    <th style="width: 80px;">Arrives</th>
                    <th style="width: 40px;">1A</th>
                    <th style="width: 40px;">FC</th>
                    <th style="width: 40px;">2A</th>
                    <th style="width: 40px;">3A</th>
                    <th style="width: 40px;">3E</th>
                    <th style="width: 40px;">CC</th>
                    <th style="width: 40px;">SL</th>
                    <th style="width: 40px;">2S</th>
                    <tr>
                        <td>11020</td>
                        <td>Singhgad Express</td>
                        <td style="text-align: center;">07:00</td>
                        <td style="text-align: center;">11:00</td>
                        <td style="text-align: center;">X</td>
                        <td style="text-align: center;">X</td>
                        <td style="text-align: center;"><input name="rd1" type="radio" id="rd2A1"/></td>
                        <td style="text-align: center;">X</td>
                        <td style="text-align: center;"><input name="rd1" type="radio" id="rd3E1"/></td>
                        <td style="text-align: center;">X</td>
                        <td style="text-align: center;"><input type="radio" name="rd1" id="rdSL1"/></td>
                        <td style="text-align: center;"><input type="radio" name="rd1" id="rd2S1"/></td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
