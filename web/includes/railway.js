function btnFindClick(){
    $.ajax({
        type: "POST",
        url: 'PlanTravelController',
        data: {
            listOrFare: "List",
            txtStationFrom: document.getElementById("txtStationFrom").value,
            txtStationTo: document.getElementById("txtStationTo").value,
            txtDate: document.getElementById("txtDate").value
        },
        success: function(data) {
            $('#divListOfTrains').html(data);
        }
    });
}
/*
function getValues(){
    $("#divSuggest").show(1000);
    $("#divSuggest").html("<table><tr><td>Manas</td></tr><tr><td>Krupal</td></tr></table>");
}

$("#divSuggest").focusout(function(){
    $("#divSuggest").hide(1000);
});

$("#divSuggest").blur(function(){
    $("#divSuggest").hide(1000);
});
*/
function rdoClick(id){
    $.ajax({
        type: "POST",
        url: 'PlanTravelController',
        data: {
            listOrFare: "Fare",
            rdId: id
        },
        success: function(data) {
            $('#divFareAndSeats').html(data);
        }
    });
}

function btnBookTicketClick(){
    var qty = document.getElementById("txtQty").value;
    window.location = "BookingConfirmation.jsp?qty=" + qty;
}

function btnConfirmBookingClick(){
     $.ajax({
        type: "POST",
        url: 'BookingConfirmationController',
        data: {
            load: "False"
        },
        success: function(data) {
            alert("Your Ticket has been Confirmed..\nBooking Id = " + data);
            window.location = "index.jsp";
        }
    });
}



