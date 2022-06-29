var api = "http://localhost:9090/api/personnel" ;
var personnelTable;
function init(){
//    $('#passwordPolicy').hide();
    console.log('inside init' );
    //For Role Button
    $("#role").click( function () {
    var ele = document.getElementsByName('rol');
        for(i = 0; i < ele.length; i++) {
            if(ele[i].checked){
            role = ele[i].value;
            //alert(ele[i].value);
            }
        }
    });

    $("#create-personnel").click( function () {
        $('#personnelModal').modal('show');
        $("#Admin").attr('checked',false);
        $("#Chef").attr('checked',false);
        $("#Headwaiter").attr('checked',false);

    });
    $("#edit-personnel").click( function () {
        if (personnelTable.row($('.selected')).data() == undefined) {
            alert("Select customer first");
        }else{
            var personnel = personnelTable.row($('.selected')).data();
            if(personnel.role=="Admin"){
                $("#Admin").attr('checked','checked');
                role="Admin";
            }else if(personnel.role=="Chef"){
                $("#Chef").attr('checked','checked');
                role="Chef";
            }else if(personnel.role=="Headwaiter"){
                 $("#Headwaiter").attr('checked','checked');
                 role="Headwaiter";
            }
            $("#id").val(personnel.id),
            $("#firstName").val(personnel.firstName),
            $("#lastName").val(personnel.lastName),
            $("#username").val(personnel.username),
            $("#password").val(personnel.password),
            $("#role").val(personnel.role),
            $('#personnelModal').modal('show');
        }
    });
    $("#delete-personnel").click( function () {
        if (personnelTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a personnel!");
        }else{
            $('#personnelDeleteModal').modal('show');
        }
    });
    $("#deleteCustomerConfirmButton").click( function () {
        console.log("Inside click of deleteCustomerButton");
        deletePersonnel();
        $('#personnelDeleteModal').modal('hide');
        });
           // Add submit event to form
/*    $("#modalButton").click( function() {
        createPersonnel();
    });*/
        $("#personnelForm").submit( function(event) {
            event.preventDefault();
            createPersonnel();
            $('#personnelDeleteModal').modal('hide');
        });
    initPersonnelTable();
    getPersonnel();
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
            "data": "password",
            "visible": false },
        { "title": "Role",
            "data": "role"},
    ];

    // Define new table with above columns
    personnelTable = $("#personnelTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });
     $("#personnelTable tbody").on( 'click', 'tr', function () {
            console.log("Clicking on row");
            if ( $(this).hasClass('selected') ) {
              $(this).removeClass('selected');
             }
            else {
                personnelTable.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    }
function getPersonnel(){
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
function deletePersonnel(){
    if (personnelTable.row($('.selected')).data() == undefined) {
        alert("Select customer first");
    }else{
        var personnel = personnelTable.row($('.selected')).data();
        $.ajax({
            url: api + '/' + personnel.id,
            type: "delete",
            contentType: "application/json",
            dataType: "text",  // get back from frontend
            // success: function(customer, textStatus, jqXHR){
            success: function(message){
                console.log(message);
                getPersonnel();
                //initPersonnelTable();
            },
            fail: function (error) {
              console.log('Error: ' + error);
            },
        });
    }
}
function createPersonnel(){
    console.log('inside createUser' );
    var personnelData = {
        id: $("#id").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        username: $("#username").val(),
        password: $("#password").val() ,
        role: role
    }
    console.log("ajavtan once");
    // Transform Javascript object to json
    var personnelJson = JSON.stringify(personnelData);
    $.ajax({
        url: api,
        type: "post",
        data: personnelJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(personnel, textStatus, jqXHR){
            console.log(personnel);
            // Clear fields in page
            $("#id").val('');
            $("#firstName").val('');
            $("#lastName").val('');
            $("#username").val('');
            $("#password").val('');
            $("#role").val('');
            $('#personnelModal').modal('hide');
            getPersonnel();
            },
/*            done: function(xhr,status,error){
                console.log('Text Status:' + status);
            },*/
            error: function(xhr,status,error){
                console.log('Text Status:' + status);
                console.log("error "+xhr.error);
                toastr.info('Note the password policy and mandatory fields!');
//                $("#passwordPolicy").attr('class', 'alert alert-danger d-block');
            },
            fail: function (error) {
                console.log('Text Status:' + status);
            },
    });

}

