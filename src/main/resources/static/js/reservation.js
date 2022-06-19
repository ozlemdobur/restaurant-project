var api = "http://localhost:9090/api/reservation";
var reservationTable;

function init(){
    console.log('inside init');
    // Add submit event to form
        $("#reservationForm").on('submit', function() {
            makeReservation();
//            $('#reservationModal').modal('hide');
        });

    initReservationTable();
    // Get customers from backend and update DOM
    getReservations();
}

function initReservationTable() {
    console.log('inside initReservationTable' );
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Reservation ID",
            "data": "reservationId",
             "visible": false},
        { "title":  "Date",
            "data": "reservationDate" },
        { "title":  "Time",
            "data": "reservationTime" },
        { "title":  "Amount Person",
            "data": "amountPerson" },
        { "title":  "First Name",
            "data": "firstName" },
        { "title":  "Last Name",
            "data": "lastName" },
        { "title":  "Email",
            "data": "email" },
        { "title": "Phone",
            "data": "phoneNumber"},
    ];
    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
//    getReservations();
}

function getReservations(){
    // http:/localhost:9090/api/reservation
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        success: function(reservations) {
            if(reservations) {
                reservationTable.clear();
                reservationTable.rows.add(reservations);
                reservationTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}

function makeReservation(){
    // Put reservation data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            reservationId: $("#reservationId").val(),
            reservationDate: $("#reservationDate").val(),
            reservationTime: $("#reservationTime").val(),
            amountPerson: $("#amountPerson").val(),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            email: $("#email").val(),
            phoneNumber: $("#phoneNumber").val()

//            babyChair: $("babyChair").val()
    }
    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);
    $.ajax({
        url: api,
        type: "post",
        data: reservationJson,    // json for request body
        contentType:'application/json',
        dataType: "json",
//        success: function(reservation, textStatus, jqXHR){
        success: function(reservation) {
          // Clear fields in page
          $("#reservationId").val('');
          $("#reservationDate").val('');
          $("#reservationTime").val('');
          $("#amountPerson").val('');
          $("#firstName").val('');
          $("#lastName").val('');
          $("#email").val('');
          $("#phoneNumber").val('');
//          $("babyChair").val('')

          // Refresh table data
          getReservations();
        },
        fail: function (error) {
          console.log('Error: ' + error);
        }
    });
}