<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plan My Travel</title>
        <link rel="stylesheet" href="css/railway.css" type="text/css" />
        <script type="text/javascript" src="includes/jquery-1.10.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
            });
            $(window).load(function() {
                $.ajax({
                    type: "POST",
                    url: 'BookingConfirmationController',   
                    data: {
                        load: "True"
                    },
                    success: function(data) {
                        $('#divBookingInfo').html(data);
                    }
                });
            });
        </script>
        <script type = "text/javascript" src = "includes/railway.js" ></script>
    </script>
</head>
<body>
    <div class="center">
        <%@include file="includes/header.jsp" %>
        <br/>
        <div class="bookingInfo" id="divBookingInfo">
            <input type="hidden" id="txtHiddenQty" />
            <h2 style="color: #4391df; font-family: 'calibri', cursive; font-size: 30px; margin: 0 auto; width: 290px">Booking Confirmation</h2>
            <table class="bookingTable">
                <tr>
                    <td class="bookingTableTd" style="font-size: 20px;" colspan="4">
                        Booking Id: 200
                    </td>
                </tr>
                <tr>
                    <td class="bookingTableTd">
                        Passenger Name:
                    </td>
                    <td class="bookingTableOtherTd">Manas</td>
                    <td class="bookingTableTd">
                        Total Passengers: 
                    </td>
                    <td class="bookingTableOtherTd">
                        8
                    </td>
                </tr>
                <tr style="margin-top: 10px; ">
                    <td class="bookingTableTd">
                        Train No
                    </td>
                    <td class="bookingTableOtherTd">
                        11001
                    </td>
                    <td class="bookingTableTd">
                        Train Name: 
                    </td>
                    <td class="bookingTableOtherTd">
                        Singhgad Express
                    </td>
                </tr>
                <tr style="margin-top: 10px; ">
                    <td class="bookingTableTd">
                        Ticket Fare
                    </td>
                    <td class="bookingTableOtherTd">
                        Rs. 450
                    </td>
                    <td class="bookingTableTd">
                        Train Class 
                    </td>
                    <td class="bookingTableOtherTd">
                        2s
                    </td>
                </tr>
                <tr style="margin-top: 10px; ">
                    <td class="bookingTableTd">
                        Distance
                    </td>
                    <td class="bookingTableOtherTd">
                        450 Kms
                    </td>
                    <td class="bookingTableTd">
                        Train Type 
                    </td>
                    <td class="bookingTableOtherTd">
                        Super-Fast
                    </td>
                </tr>
                <tr style="margin-top: 10px; ">
                    <td class="bookingTableTd">
                        From
                    </td>
                    <td class="bookingTableOtherTd">
                        Pune
                    </td>
                    <td class="bookingTableTd">
                        To
                    </td>
                    <td class="bookingTableOtherTd">
                        Dadar
                    </td>
                </tr>
                <tr style="margin-top: 10px; ">
                    <td class="bookingTableTd">
                        Departs At
                    </td>
                    <td class="bookingTableOtherTd">
                        12:00
                    </td>
                    <td class="bookingTableTd">
                        Arrives At
                    </td>
                    <td class="bookingTableOtherTd">
                        15:00
                    </td>
                </tr>
                <tr>
                    <td class="bookingTableTd">
                        Date
                    </td>
                    <td class="bookingTableOtherTd" colspan="4">
                        29/09/2013
                    </td>
                </tr>
            </table>
            <div style="margin-top: 10px; width:100px; margin: 0 auto;">
                <input class="newButtonLink" type="submit" onclick="btnConfirmBookingClick()" value="Confirm Booking" id="btnConfirmBooking" />
            </div>
        </div>
    </div>
</body>
</html>
