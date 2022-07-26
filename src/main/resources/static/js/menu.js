var api = "http://localhost:9090/api/menu" ;
var menuTable;
var menuType;

function init(){

    console.log('inside init' );
    $("#menuType").click( function () {
    var ele = document.getElementsByName('mType');
        for(i = 0; i < ele.length; i++) {
            if(ele[i].checked){
                menuType = ele[i].value;
            }
        }
   });

    $("#create-menu").click( function () {

        variableMenuType = "";
        console.log("create menu inside mtype"+variableMenuType );
        clearForm();
        $('#menuModal').modal('show');

    });

    $("#edit-menu").click( function () {
        if (menuTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a menu!");
        }else{
            var menu = menuTable.row($('.selected')).data();

            //Radio button is adjusted check value
            menuType = menu.menuType;
            $("#"+menuType+"").attr('checked','checked');

            $("#id").val(menu.id),
            $("#menuName").val(menu.menuName),
            $("#price").val(menu.price),
            $("#menuType").val(menu.menuType),
            $("#imagePath").val(menu.imagePath),
            $('#menuModal').modal('show');
        }
    });

    $("#upload-menu").click( function () {
        if (menuTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a menu!");
        }else{
            var menu = menuTable.row($('.selected')).data();
            console.log(menu.imagePath);
            showImage(menu.imagePath);
            $('#menuUploadModal').modal('show');
        }
    });

    $("#delete-menu").click( function () {
        if (menuTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a menu!");
        }else{
            $('#menuDeleteModal').modal('show');
        }
    });

    $("#deleteMenuConfirmButton").click( function () {
        console.log("Inside click of deletemenuButton");
        deleteMenu();
        $('#menuDeleteModal').modal('hide');
        });

    $("#uploadMenuConfirmButton").click( function () {
        console.log("Inside click of uploadMenuConfirmButton");
        uploadFile();
        $('#menuUploadModal').modal('hide');
        });
           // Add submit event to form

    $("#menuForm").submit( function(event) {
        console.log("required control");
        event.preventDefault();
        console.log("required control");
        createMenu();
    });
/*    $("#modalButton").click( function() {
        event.preventDefault();
        createMenu();
    });*/
    initMenuTable();
    getMenu();
}

function showImage(imagePath) {

    console.log('inside showImage' );
    console.log(api+"/getImage/"+imagePath);
    document.getElementById('menuPicture').src = api+"/getImage/"+imagePath;
    console.log(api+"/getImage/"+imagePath);

}

async function uploadFile() {
    var menu = menuTable.row($('.selected')).data();
    console.log("inside uploadfile function")    ;
    let formData = new FormData();
    formData.append("file", fileupload.files[0]);
    formData.append("id", menu.id);
    formData.append("menuName", menu.menuName);
    let response = await fetch(api+"/upload", {
        method: "POST",
        body: formData
    });

    if (response.status == 200) {
        alert("File successfully uploaded.");
        getMenu();
    }
}

function clearForm(){

    $('#menuForm input[type="text"]').each(function(){
      $(this).val("");
    });

    $('#menuForm input[type="number"]').each(function(){
        $(this).val("");
    });

   var ele = document.getElementsByName("mType");
   for(var i=0;i<ele.length;i++)
      ele[i].checked = false;
 }

function initMenuTable() {
    console.log('inside initUserTable' );

    columns = [
        { "title":  "Menu ID",
            "data": "id" ,
            "visible": false },
        { "title":  "Image Path",
            "data": "imagePath" ,
            "visible": false },
        { "title":  "Menu Name",
            "data": "menuName" },
        { "title":  "Price",
            "data": "price" },
        { "title":  "Menu Type",
            "data": "menuType"},
        {   "title":  "Ingredients",
            targets: -1,
            data: null,
            defaultContent: '<button>Click!</button>',
        },
    ];

    // Define new table with above columns
    menuTable = $("#menuTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns
    });

     $("#menuTable tbody").on( 'click', 'tr', function () {
            console.log("Clicking on row");
            if ( $(this).hasClass('selected') ) {
              $(this).removeClass('selected');
             }
            else {
                menuTable.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });

        $('#menuTable tbody').on('click', 'button', function () {
            $(this).removeClass('selected');
            var menu = menuTable.row($(this).parents('tr')).data();
            top.location.href="/ingredient?menuId="+menu.id;
        });

    }

function getMenu(){

    console.log('inside getMenus' );

    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        success: function(menus){
            if (menus) {
                menuTable.clear();
                menuTable.rows.add(menus);
                menuTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}

function deleteMenu(){
    if (menuTable.row($('.selected')).data() == undefined) {
        alert("You have to select a menu!");
    }else{
        var menu = menuTable.row($('.selected')).data();
        $.ajax({
            url: api + '/' + menu.id,
            type: "delete",
            contentType: "application/json",
            dataType: "text",  // get back from frontend
            success: function(message){
                console.log(message);
                getMenu();
                //initPersonnelTable();
            },
            fail: function (error) {
              console.log('Error: ' + error);
            },
        });
    }
}
function createMenu(){
    console.log("menuid in the createMenu : " +$("#id").val());
    var MenuData = {
        id: $("#id").val(),
        menuName: $("#menuName").val(),
        price: $("#price").val(),
        menuType: menuType,
        imagePath:$("#imagePath").val()
    }

    var menuJson = JSON.stringify(MenuData);
    $.ajax({
        url: api,
        type: "post",
        data: menuJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(menu, textStatus, jqXHR){
            console.log(menu);
            $('#menuModal').modal('hide');
            getMenu();
            },
            done: function(xhr,status,error){
                console.log('Text Status:' + status);
            },
            error: function(xhr,status,error){
                responseText = jQuery.parseJSON(xhr.responseText);
                console.log('Text Status:' + status);
                console.log(' - message: ' + responseText.message);
                //console.log("error "+xhr.);
                toastr.info(responseText.message);
                //alert(xhr.responseText);//"This menu name exist.Please change the menu name!"
            },
            fail: function (error) {
                console.log('Text Status:' + status);
            },
    });

}

