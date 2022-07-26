var customerTable;
function init(){
    $('#passwordsNoMatchRegister').hide();
    $("#login-system").click(function (){
        $('#passwordsNoMatchRegister').hide();
        getPersonnels();
    });
}

function getPersonnels(){
    var api = "http://localhost:9090/api/login" ;
    var username = $("#username").val();
    var password = $("#password").val();
    $.ajax({
            url: api + "/" + username + "/" + password,
            type: "get",
            dataType: "text",
            success: function(view){ top.location.href = view; },
            error: function(xhr,status,error){
                $("#username").val('');
                $("#password").val('');
                $("#passwordsNoMatchRegister").attr('class', 'alert alert-danger d-block');
            },
        });
}