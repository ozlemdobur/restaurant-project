var username;
function init(){
console.log('inside getCustomerData');
username= GetURLParameter('username');
console.log(username);

}
function addLoadEvent(func) {
      var oldonload = window.onload;
      if (typeof window.onload != 'function') {
        window.onload = func;
      } else {
        window.onload = function() {
          if (oldonload) {
            oldonload();
          }
          func();
        }
      }
}

addLoadEvent(function() {
    document.getElementById('lbl-username').innerHTML = "Welcome    "+username;
});

function GetURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++)
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam)
        {
            return sParameterName[1];
        }
    }
}
/*
function getUser(){
    var api = "http://localhost:9090/api/mainsystem" ;
    var username = "odobur";
    console.log('inside getCustomerData' +username );
    console.log('inside getUsers' );
    api = api + "/" +username;
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
            url: api,
            type: "get",
            dataType: "json",
            success: function(personnel, textStatus, jqXHR){
                // process the data (json) and modify the DOM
                console.log('Text Status:' + textStatus);
                console.log('User:' + personnel);

            },

        });

}*/
