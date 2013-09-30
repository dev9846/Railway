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
    alert("hi");
    window.location.href = "BookingConfirmation.jsp";
}


