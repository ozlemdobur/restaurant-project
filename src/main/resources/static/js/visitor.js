var api = "http://localhost:9090/api/visitor" ;
var visitorTable;
function init(){

    console.log('inside init' );

    $("#create-visitor").click( function () {
        $('#visitorModal').modal('show');
    });

    $("#enter-country").click( function () {
        editVisitor();
    });

    $("#leave-country").click( function () {
        deleteVisitor();
    });

    $("#modalButton").click( function() {
        createVisitor();
    });

    initVisitorTable();
    getVisitor();
}

function editVisitor(){
    console.log('inside editVisitor' );


    if (visitorTable.row($('.selected')).data() == undefined) {
        alert("Select visitor first");
    }else{
        var visitor = visitorTable.row($('.selected')).data();
        var visitorData = {
            id: visitor.id,
            firstName: visitor.firstName,
            lastName:visitor.lastName,
            age: visitor.age,
            city:visitor.city ,
            status:visitor.status
        }
        var visitorJson = JSON.stringify(visitorData);
        $.ajax({
            url: api,
            type: "post",
            data: visitorJson,    // json for request body
            dataType: "json", //get back from fronted
            contentType: "application/json; charset=utf-8", // What we send to frontend
            success: function(visitor, textStatus, jqXHR){
                console.log(visitor);
                getVisitor();
            },
            error: function(xhr,status,error){
                console.log('Text Status:' + status);
                console.log("error "+xhr.error);
            },
            fail: function (error) {
                console.log('Text Status:' + status);
            },
        });
    }
}


function createVisitor(){
    console.log('inside createVisitor' );
    var visitorData = {
        id: $("#id").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        age: $("#age").val(),
        city: $("#city").val() ,
        status:  $("#status").val()
    }

    var visitorJson = JSON.stringify(visitorData);
    $.ajax({
        url: api,
        type: "post",
        data: visitorJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(visitor, textStatus, jqXHR){
            console.log(visitor);
            if(visitor.status=="WAITING"){
                alert("You can try again later!Now , you are in the waiting list!");
            }else{
                alert("Welcome to Narnia!");
            }
            // Clear fields in page
            $("#id").val('');
            $("#firstName").val('');
            $("#lastName").val('');
            $("#age").val('');
            $("#city").val('');
            $("#status").val('');
            $('#visitorModal').modal('hide');
            getVisitor();

        },
        error: function(xhr,status,error){
            console.log('Text Status:' + status);
            console.log("error "+xhr.error);
        },
        fail: function (error) {
            console.log('Text Status:' + status);
        },
    });
}

function initVisitorTable() {
    console.log('inside VisitorTable' );
    columns = [
        { "title":  "User ID",
            "data": "id"  },
        { "title":  "First Name",
            "data": "firstName" },
        { "title":  "Last Name",
            "data": "lastName" },
        { "title":  "Age",
            "data": "age" },
        { "title":  "City",
            "data": "city" },
        { "title":  "Status",
                    "data": "status" },
    ];

    // Define new table with above columns
    visitorTable = $("#visitorTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
     $("#visitorTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
         }
        else {
            visitorTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
     });
}

function getVisitor(){
    console.log('inside getUsers' );
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        success: function(visitors){
            if (visitors) {
                visitorTable.clear();
                visitorTable.rows.add(visitors);
                visitorTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}
function deleteVisitor(){
    if (visitorTable.row($('.selected')).data() == undefined) {
        alert("Select visitor first");
    }else{
        var visitor = visitorTable.row($('.selected')).data();
        $.ajax({
            url: api + '/' + visitor.id,
            type: "delete",
            contentType: "application/json",
            dataType: "text",
            success: function(message){
                console.log(message);
                getVisitor();
            },
            fail: function (error) {
                console.log('Error: ' + error);
            },
        });
    }
}

