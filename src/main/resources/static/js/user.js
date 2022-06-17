var api = "http://localhost:9090/api/user" ;
var userTable;
function init(){

    console.log('inside init' );
    initUserTable();
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
   $("#newUserButton").click( function () {
               console.log("Inside click of newUserButton");
               $('#userModal').modal('show');
           });
           $("#editUserButton").click( function () {
               console.log("Inside click of editUserButton");
               // Get the data from selected row and fill fields in modal
                $("#firstName").val('test'),
                $("#lastName").val('test'),
                $("#username").val('test'),
                $("#password").val('test'),
                $("#role").val('test')
               // if (customerTable.row($('.selected')).data() != undefined) {


               $('#userModal').modal('show');
           });
           // Add submit event to form
           $("#userForm").on('submit', function() {
               createUser();
               $('#userModal').modal('hide');
           });
           initUserTable();
       getUsers();

}





function initUserTable() {
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
    userTable = $("#userTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
}
function getUsers(){

    console.log('inside getUsers' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        success: function(users){
            if (users) {
                userTable.clear();
                userTable.rows.add(users);
                userTable.columns.adjust().draw();
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

function createUser(){

    console.log('inside createUser' );
    // Put customer data from page in Javascript object --- SIMILAR TO JSON
    var userData = {
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

    });
}

