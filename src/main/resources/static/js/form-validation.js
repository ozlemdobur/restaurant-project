var api = "http://localhost:9090/api/reservation";
var reservationTable;

function init(){
    console.log('inside init');
        // Add submit event to form for new
            $("#reservationForm").on('submit', function() {
                console.log("Submitting");
                makeReservation();
            });
}

function makeReservation(){
    console.log('inside makeReservation' );
    // Put reservation data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            id: $("#id").val(),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            email: $("#email").val(),
            phone: $("#phone").val(),
            date: $("#date").val(),
            time: $("#time").val(),
            howManyPeople: $("#howManyPeople").val()
    }

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);
    console.log(reservationJson);
    alert("Reservation is successfully made!");
    $.ajax({
        url: api,
        type: "post",
        data: reservationJson,    // json for request body
        contentType:"application/json; charset=utf-8", // What we send to frontend
        dataType: "json", // get back from frontend
        success: function(reservation) {
            console.log(reservation);
            // Clear fields in page
            $("#id").val('');
            $("#firstName").val('');
            $("#lastName").val('');
            $("#email").val('');
            $("#phone").val('');
            $("#date").val('');
            $("#time").val('');
            $("#howManyPeople").val('');

          // Refresh table data
//          getReservationData();
        },
        fail: function (error) {
          console.log('Error: ' + error);
        }
    });
}

function initReservationTable() {
    console.log('inside initReservationTable' );
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Reservation ID",
            "data": "id",
             "visible": false},
        { "title":  "First Name",
            "data": "firstName" },
        { "title":  "Last Name",
            "data": "lastName" },
        { "title":  "Email",
            "data": "email" },
        { "title": "Phone",
            "data": "phone"},
        { "title":  "Date",
            "data": "date" },
        { "title":  "Time",
            "data": "time" },
        { "title":  "How Many People",
            "data": "howManyPeople" }
    ];

    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });

    $("#reservationTable tbody").on( 'click', 'tr', function () {
            console.log("Clicking on row");
            if ( $(this).hasClass('selected') ) {
                $(this).removeClass('selected');
            } else {
                reservationTable.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
}

function getReservationData(){
    console.log('inside getReservationData' );
    // http:/localhost:9090/api/reservation
    // json list of reservations
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(customers, textStatus, jqXHR){
        success: function(reservations){
 //           console.log('Data: ' + reservations );
            if (reservations) {
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