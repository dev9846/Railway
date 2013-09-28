<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan My Travel</title>
        <link rel="stylesheet" href="css/railway.css" type="text/css" />
    </head>
    <body>
        <div class="center">
            <%@include file="includes/header.jsp" %>
            <br/>
            <div class="fromTo">
                <h4 style="font-family: calibri">Station From</h4>
                <input type="text" name="txtFrom" placeholder="Station From" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Station To</h4>
                <input type="" name="txtTo" placeholder="Station To" class="textbox"/>
                <br/>
                <br/>
                <h4 style="font-family: calibri">Date</h4>
                <input type="datetime" name="txtDate" placeholder="Date" class="textbox"/>
                <br/>
                <br/>
                <div style="margin: 0 auto; width: 100px ">
                    <input type="submit" name="Find" value="Find" class="newButtonLink" />
                </div>
            </div>
             <div class="seatInfo">
                  <div style="margin: 0 auto; width: 70px" ><h4 style="color: #4391df">Seat Info</h4></div>
                  <table></table>
            </div>
            <div class="fareInfo">
                  <div style="margin: 0 auto; width: 70px" ><h4 style="color: #4391df">Fare Info</h4></div>
            </div>
            <br/>
            <div class="trainList">
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
