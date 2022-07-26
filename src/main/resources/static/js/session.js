function initMenu(){
    console.log('Inside initMenu');

    // Hide all menu items
    $("#menuPersonnel").hide();
    $("#menuReservation").hide();
    $("#menuTableRestaurant").hide();
    $("#menuMenu").hide();
    $("#menuProduct").hide();
//    $("#menuLogin").hide();
    $("#menuLogout").hide();

    // get role from backend and assign to role
    getRole();
}

function getRole(){
    console.log('Inside getRole');
    $.get({
        url: "/api/getrole" ,
        dataType: "text",
        success: function(role){
            showMenu(role);
        },
        error: function(jqXHR, textStatus, errorThrown){
            console.log('Error: ' + textStatus);
        }
    });
}

function showMenu(role){
    if( role === 'Visitor'){
        $("#menuLogin").show();
        return;
    }

    if(role === 'Admin'){
        $("#menuPersonnel").show();
        $("#menuReservation").show();
        $("#menuTableRestaurant").show();
        $("#menuMenu").show();
        $("#menuProduct").show();
        $("#menuLogout").show();
        return;
    }

    if(role === 'Chef'){
        $("#menuMenu").show();
        $("#menuLogout").show();
        return;
    }

    if(role === 'Headwaiter'){
        $("#menuProduct").show();
        $("#menuLogout").show();
        return;
    }

    if(role === 'Waiter'){
        $("#menuTable").show();
        $("#menuLogout").show();
        $("#newTableButton").hide();
        $("#editTableButton").hide();
        $("#deleteTableButton").hide();
    }
}