var api = "http://localhost:9090/api/reservationAdministration";
var reservationTable;
var newTableId="";
var newTableNumber, newTableReserveEndTime, newTableReserveStartDate,newTableReserveStartTime;
var babyChair;

function init(){
    console.log('inside init');

    $(".datepicker").datepicker({
        firstDay: 1,
        minDate: new Date(),
        dateFormat: 'yy-mm-dd'
    });

    $('.time').timepicker({
        timeFormat: 'HH:mm',
        interval: 30,
        show2400: true,
        minTime: '10:00',
        maxTime: '22:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true,
        zindex: 9999999
    });

    $("#isBabyChair").click( function () {
        babyChair = document.getElementById('isBabyChair');
        babyChair.value = babyChair.checked;
    });

    $("#newReservationButton").click(function () {
        console.log("Inside click of newReservationButton");
        $("#id").val('');
        $("#firstName").val('');
        $("#lastName").val('');
        $("#email").val('');
        $("#phone").val('');
        $("#date").val('');
        $("#time").val('');
        $("#howManyPeople").val('');
        $("#isBabyChair").val('');
        $('#reservationModal').modal('show');
    });

    $("#editReservationButton").click( function () {
        console.log("Inside click of editReservationButton");
        // Get the data from selected row and fill fields in modal
        if (reservationTable.row($('.selected')).data() == undefined) {
            alert("Select reservation first");
        } else {
            var reservation = reservationTable.row($('.selected')).data();
            $("#id").val(reservation.id);
            $("#firstName").val(reservation.firstName);
            $("#lastName").val(reservation.lastName);
            $("#email").val(reservation.email);
            $("#phone").val(reservation.phone);
            $("#date").val(reservation.date);
            $("#time").val(reservation.time);
            $("#howManyPeople").val(reservation.howManyPeople);
            $("#isBabyChair").attr('checked', reservation.babyChair);
            $('#reservationModal').modal('show');
        }
    });

    $("#deleteReservationButton").click( function () {
        console.log("Inside click of deleteReservationButton");
        if (reservationTable.row($('.selected')).data() == undefined) {
            alert("Select reservation first");
        }else{
            $('#reservationDeleteModal').modal('show');
        }
    });

    // Button in modal
    $("#deleteReservationConfirmButton").click( function () {
        console.log("Inside click of deleteReservationButton");
        deleteReservation();
        $('#reservationDeleteModal').modal('hide');
    });

    // Add submit event to form for new and edit
    $("#sbmt").on('click', function() {
        console.log("Submitting");

        createReservation();
        $('#reservationModal').modal('hide');

    });

    initReservationTable();
    // Get reservations from backend and and update table
    getReservationData();
}
function createReservation(){
    console.log('inside createReservation' );
    var resData = {
        id: $("#id").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        email: $("#email").val(),
        phone: $("#phone").val(),
        date: $("#date").val(),
        time: $("#time").val(),
        howManyPeople: $("#howManyPeople").val(),
        babyChair: $("#isBabyChair").val()
    }

    var resJson = JSON.stringify(resData);
    $.ajax({
        url: "http://localhost:9090/api/makeReservation",
        type: "post",
        data: resJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(reservation, textStatus, jqXHR){
            getReservationData();
            console.log(reservation);
            alert("Your booked successesfully!");
        },
        error: function(xhr,status,error){
            alert("All tables are booked. Please try again another day!");
        },
        fail: function (error) {
            alert("All tables are booked. Please try again another day!");
        },
    });

}

function getFreeTable(){
/*    String strDate= $("#date").val().toString();
    String strTime = $("#time").val().toString();*/
    alert("inside getFreeTable");
    console.log('inside checkFreeTable' );
    $.ajax({
        url: "http://localhost:9090/api/tableRestaurant/"+$("#howManyPeople").val()+"/"+ $("#date").val()+"/"+$("#time").val(),
        type: "post",
        dataType: "json",
        success: function(tables){
            console.log("success");
            if (tables) {
                alert("inside getFreeTable.There is a free table"+tables.id);
                newTableId =tables.id;
                /*newTableNumber= tables.tableNumber;
                newTableReserveEndTime = tables.tableReserveEndTime;
                newTableReserveStartDate =tables.tableReserveStartDate;
                newTableReserveStartTime =tables.tableReserveStartTime;*/

                makeReservation();
            }
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
        { "title":  "Table No",
            "data": "tableId" },
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
        { "title":  "Person",
            "data": "howManyPeople" },
        { "title":  "Baby Chair",
            "data": "babyChair",
            render: function(data, type, row){
                        if(data == true) {
                            return '<span>Yes</span>';
                        } else {
                            return '<span>No</span>';
                        }
                    }
        }
    ];

    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 6, "asc" ]],
        "columns": columns
    });

    $("#reservationTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
        }
        else {
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
        howManyPeople: $("#howManyPeople").val(),
        babyChair: $("#isBabyChair").val(),
       tableRestaurant: {
            id :newTableId
/*            tableNumber : newTableNumber,
            tableReserveEndTime : newTableReserveEndTime,
            tableReserveStartDate :newTableReserveStartDate,
            tableReserveStartTime :newTableReserveStartTime*/
            }
        }
    console.log(reservationData);

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);
    console.log(reservationJson);
//    alert($("Dear " + "#firstName").val() + " Your reservation is succeeded!");
    $.ajax({
        url: api,
        type: "post",
        data: reservationJson,    // json for request body
        contentType:"application/json; charset=utf-8", // What we send to frontend
        dataType: "json", // get back from frontend
//        success: function(reservation, textStatus, jqXHR){
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
            $("#isBabyChair").val('');
          // Refresh table data
          getReservationData();
        },
        fail: function (error) {
          console.log('Error: ' + error);
        }
    });
}

function deleteReservation(){
    if (reservationTable.row($('.selected')).data() == undefined) {
        alert("Select reservation first");
    }else{
        var reservation = reservationTable.row($('.selected')).data();
// http:9090/api/reservation/2
        console.log(api + '/' + reservation.id);
            $.ajax({
                url: api + '/' + reservation.id,
                type: "delete",
                contentType: "application/json",
                dataType: "text",  // get back from frontend
                // success: function(customer, textStatus, jqXHR){
                success: function(message){
                  console.log(message);
                  // Refresh table data
                  getReservationData();
                },
                fail: function (error) {
                  console.log('Error: ' + error);
                }
            });
    }
}