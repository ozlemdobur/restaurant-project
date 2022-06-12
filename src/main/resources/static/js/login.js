var customerTable;
var user2;
function init(){
    $('#passwordsNoMatchRegister').hide();
    //console.log('inside init' );
    // Add click event to button
    $("#login-system").click(function (){
        $('#passwordsNoMatchRegister').hide();
        getUsers();
        if(user2==null){
            $("#username").val('');
            $("#password").val('');
            $('#passwordsNoMatchRegister').show();
        }
    });

}

function getUsers(){
    var api = "http://localhost:9090/api/login" ;
    var username = $("#username").val();
    var password = $("#password").val();
    console.log('inside getCustomerData' +username );
    api = api + "/" +username + "/" +password
    // http:/localhost:9090/api/login
    // json list of customers
    $.ajax({
            url: api,
            type: "get",
            dataType: "json",
            success: function(user, textStatus, jqXHR){
                // process the data (json) and modify the DOM
                console.log('Text Status:' + textStatus);
                console.log('User:' + user);
                user2 = user;
                top.location.href="/mainsystem";

            },

        });


}
