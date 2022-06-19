var api = "http://localhost:9090/api/personnel" ;
var personnelTable;
function init(){

    console.log('inside init' );
    initPersonnelTable();
    // Add click event to button
/*
    $("#create-user").click(function (){
        createUser();
    });
    $("#delete-user").click(function (){
        deleteUser();
    });
    $("#update-user").click(function (){
        deleteUser();
    });
*/
    // Get customers from backend and update DOM
   $("#create-personnel").click( function () {
               console.log("Inside click of newUserButton");
               $('#personnelModal').modal('show');
           });
           $("#editpersonnelButton").click( function () {
               console.log("Inside click of editUserButton");
               // Get the data from selected row and fill fields in modal
                $("#firstName").val('test'),
                $("#lastName").val('test'),
                $("#username").val('test'),
                $("#password").val('test'),
                $("#role").val('test')
               // if (customerTable.row($('.selected')).data() != undefined) {


               $('#personnelModal').modal('show');
           });
           // Add submit event to form
           $("#personnelForm").on('submit', function() {
               createPersonnel();
               $('#personnelModal').modal('hide');
           });
       getPersonnels();

}





function initPersonnelTable() {
    console.log('inside initUserTable' );
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "User ID",
            "data": "id" ,
            "visible": false },
        { "title":  "First Name",
            "data": "firstName" },
        { "title":  "Last Name",
            "data": "lastName" },
        { "title":  "Username",
            "data": "username" },
        { "title":  "Password",
            "data": "password" },
        { "title": "Role",
            "data": "role"},
    ];

    // Define new table with above columns
    personnelTable = $("#personnelTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
}
function getPersonnels(){

    console.log('inside getUsers' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        success: function(personnels){
            if (personnels) {
                personnelTable.clear();
                personnelTable.rows.add(personnels);
                personnelTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}
/*function deleteUser(){

    console.log('inside createUser' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var userData = {
            Id: $("#firstName").val(),
            lastName: $("#lastName").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            role: $("#role").val()
    }

    // Transform Javascript object to json
    var userJson = JSON.stringify(userData);

    console.log(userJson);

    $.ajax({
        url: api,
        type: "post",
        data: userJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(user, textStatus, jqXHR){

          console.log(user);

          // Clear fields in page
          $("#firstName").val('');
          $("#lastName").val('');
          $("#username").val('');
          $("#password").val('');
          $("#role").val('');


          // Refresh table data
          getUsers();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });*/
/*
function updateUser(){

    console.log('inside updateUser' );

    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var userData = {
            id: $("#id").val(),
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            role: $("#role").val()
    }

    // Transform Javascript object to json
    var userJson = JSON.stringify(userData);

    console.log(userJson);

    $.ajax({
        url: api,
        type: "put",
        data: userJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(user, textStatus, jqXHR){

          console.log(user);

          // Clear fields in page
          $("#id").val('');
          $("#firstName").val('');
          $("#lastName").val('');
          $("#username").val('');
          $("#password").val('');
          $("#role").val('');


          // Refresh table data
          getUsers();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });
}
*/

function createPersonnel(){

    console.log('inside createUser' );
    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var personnelData = {
            firstName: $("#firstName").val(),
            lastName: $("#lastName").val(),
            username: $("#username").val(),
            password: $("#password").val(),
            role: $("#role").val()
    }

    // Transform Javascript object to json
    var personnelJson = JSON.stringify(personnelData);

    console.log(personnelJson);

    $.ajax({
        url: api,
        type: "post",
        data: personnelJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(personnel, textStatus, jqXHR){

          console.log(personnel);

          // Clear fields in page
          $("#firstName").val('');
          $("#lastName").val('');
          $("#username").val('');
          $("#password").val('');
          $("#role").val('');


          // Refresh table data
          getPersonnels();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });
}

