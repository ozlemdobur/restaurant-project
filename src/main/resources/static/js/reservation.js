var api = "http://localhost:9090/api/reservationAdministration";
var babyChair;
function init(){
    console.log('inside init');

    $("#isBabyChair").click( function () {
        babyChair = document.getElementById('isBabyChair');
        babyChair.value = babyChair.checked;
    });

    $(".datepicker").datepicker({
        firstDay: 1,
        minDate: new Date(),
        dateFormat: 'yy-mm-dd'
    });

    $('.timepicker').timepicker({
        timeFormat: 'HH:mm',
        interval: 30,
        show2400: true,
        minTime: '10:00',
        maxTime: '22:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });

    $("#reservation-button").click( function () {
        console.log("Inside click of reservation-button");
        $('#reservationModal').modal('show');
    });

    $("#submit-reservation").click( function () {
        console.log("Inside click of submit-reservation");
        makeReservation();
        $('#reservationModal').modal('hide');
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
        babyChair: $("#isBabyChair").val()
    }

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);
    alert("Dear " + $("#firstName").val() + " Your reservation is succeeded!");
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
        },
        fail: function (error) {
          console.log('Error: ' + error);
        }
    });
}