var api = "http://localhost:9090/api/ingredient" ;
//var productId, productName, measurementUnit, stockAmount, minumumLimit, supplier, brand, price, unitPrice;
var ingredientTable;
var productTable;
var menuId;
var menuName;
var newIngId;
/*var selectedProductArray;
var selectedMenuArray;
var selectedIngredientArray;*/

function init(){

    console.log('inside init' );
    menuId= GetURLParameter('menuId');
    getMenuName();
    //getMenuByMenuId();
    //select product after click
    getIngredientByMenuId();

    $("#create-ingredient").click( function ()
    {
        if (productTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a product!");
        }else{
            var product = productTable.row($('.selected')).data();
            newIngId="";
            productId =product.id ;
            $("#productId").val(product.id);
            $("#productName").val(product.productName);
            $("#ingAmount").val('');
            $('#ingredientModal').modal('show');
        }
    });

/*    $("#edit-ingredient").click( function () {
        if (ingredientTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a product!");
        }else{
            var ingredient = ingredientTable.row($('.selected')).data();
            newIngId=ingredient.id;
            $("#id").val(ingredient.id);
            $("#productName").val(ingredient.product.productName);
            $("#ingAmount").val(ingredient.ingAmount);
            $('#ingredientModal').modal('show');
        }
    });*/

    $("#delete-ingredient").click( function () {
        if (ingredientTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a ingredient!");
        }else{
            $('#ingredientDeleteModal').modal('show');
        }
    });
    $("#deleteIngredientConfirmButton").click( function () {
        console.log("Inside click of deleteIngredientButton");
        deleteIngredient();
        $('#ingredientDeleteModal').modal('hide');
    });
           // Add submit event to form
    $("#ingredientForm").submit( function(event) {
        console.log("create ingredient mi");
        event.preventDefault();
        createIngredient();
        getIngredientByMenuId();
/*        if (productTable.row($('.selected')).data() != undefined) {
            createIngredient();
            //getIngredientByMenuId();
        }
        else{
            //var ingName = ingredientTable.row($('.selected')).data().productName;
            //console.log(ingName);
            editIngredient();
            getIngredientByMenuId();
            //ingredientTable.row('.selected').$(this).parents('tr').data()[1].text($("#productName").val());
        }*/

        $('#ingredientModal').modal('hide');
    });

    initIngredientTable();
    getIngredientByMenuId();
    initProductTable();
    getProduct();

}

//invoke the all product data for the datatable
function getProduct(){
    console.log('inside getProduct' );
    $.ajax({
        url:"http://localhost:9090/api/product" ,
        type: "get",
        dataType: "json",
        success: function(products){
            if (products) {
                productTable.clear();
                productTable.rows.add(products);
                productTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}

//For product datatable
function initProductTable() {
    console.log('inside initProductTable' );
    columns = [
        { "title":  "Product ID",
            "data": "id" ,
            "visible": false },
        { "title":  "Product Name",
            "data": "productName" },
        { "title":  "Measurement Unit",
            "data": "measurementUnit"}
    ];

    productTable = $("#productTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns,
        "bLengthChange": false,
        "bFilter": true,
        "bInfo": false,
        "bAutoWidth": false
    });

    $("#productTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else
        {
            productTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

//For ing datatable
function initIngredientTable() {

    console.log('inside initUserTable' );
    columns = [
        { "title":  "Ingredient ID",
            "data": "id" ,
            "visible": false },
        { "title":  "Product ID",
            "data": "product.id" ,
            "visible": false },
        { "title":  "Ingredient Name",
           "data": "product.productName" },
        { "title":  "Amount",
           "data": "ingAmount"},
        { "title":  "Measurement Unit",
           "data": "product.measurementUnit"},
    ];

    ingredientTable = $("#ingredientTable").DataTable( {
        "order": [[ 0, "asc" ]],
        "columns": columns,
        "bPaginate": false,
        "bLengthChange": false,
        "bFilter": true,
        "bInfo": false,
        "bAutoWidth": false
    });

    $("#ingredientTable tbody").on( 'click', 'tr', function () {
        console.log("Clicking on row");
        if ( $(this).hasClass('selected') ) {
          $(this).removeClass('selected');
         }
        else {
            ingredientTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
}

//delete ing
function deleteIngredient(){

    console.log("inside deleteIngredient method")
    if (ingredientTable.row($('.selected')).data() == undefined) {
        alert("You have to select a ingredient!");
    }else{
        var ingredient = ingredientTable.row($('.selected')).data();
        console.log(ingredient.id);
        $.ajax({
            url: api + "/" + ingredient.id,
            type: "delete",
            contentType: "application/json",
            dataType: "text",  // get back from frontend
            success: function(message){
                console.log(message);
                getIngredientByMenuId();
            },
            fail: function (error) {
              console.log('Error: ' + error);
            },
        });
    }
}

//this method is used to write menuname on the title
function getMenuName(){
    $.ajax({
        url: "http://localhost:9090/api/menu/"+menuId,
        type: "get",
        async: false,
        cache: false,
        timeout: 30000,
        dataType: "json",
        success: function(menu){
            console.log("menuname function"+menu);
            document.getElementById('lbl-menuName').innerHTML = "Ingredients List Of "+menu.menuName;
            },
            done: function(xhr,status,error){
                console.log('Text Status:' + status);
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

//This metod is used to show all ingredients that the selected menu has on the 2.datatables
function getIngredientByMenuId(){

    console.log('inside getUsers' );
    $.ajax({
        url: api + "/" +menuId ,
        type: "get",
        async: false,
        cache: false,
        timeout: 30000,
        dataType: "json",
        success: function(ingredients){
            if (ingredients) {
            console.log("inside getIngredientByMenuId to fill in the data "+ingredients);
                ingredientTable.clear();
                ingredientTable.rows.add(ingredients);
                ingredientTable.columns.adjust().draw();
            }
        },
        fail: function (error) {
            console.log('Error: ' + error);
        }
    });
}


function createIngredient(){

    var selectedIngredient={
         id: "",
         ingAmount:  $("#ingAmount").val(),
         product: {
           id: productId
         }
    };
    var selectedIngredientJSON =JSON.stringify(selectedIngredient);

    //New Ingredient adding to db
    $.ajax({
        url: api,
        type: "post",
        async: false,
        cache: false,
        timeout: 30000,
        data: selectedIngredientJSON,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function(ingredient, textStatus, jqXHR){
            newIngId =ingredient.id;
            console.log("save ingredient"+newIngId);
        },
        done: function(xhr,status,error){
            console.log('Text Status:' + status);
        },
        error: function(xhr,status,error){
            console.log('Text Status:' + status);
            console.log("error "+xhr.error);
        },
        fail: function (error) {
            console.log('Text Status:' + status);
        },
    });

    //Ing table a menu id update etme
    $.ajax({
        url: "http://localhost:9090/api/ingredient/"+menuId+"/"+newIngId,
        type: "get",
        async: false,
        cache: false,
        timeout: 30000,
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(ingredient, textStatus, jqXHR){

        },
        done: function(xhr,status,error){
            console.log('Text Status:' + status);
        },
        error: function(xhr,status,error){
            console.log('Text Status:' + status);
            console.log("error "+xhr.error);
        },
        fail: function (error) {
            console.log('Text Status:' + status);
        },
    });
    //getIngredientByMenuId();
}

//This metod is used to get menuid from the url
function addLoadEvent(func)
 {

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


//This metod is used to save new ingridient in the ing db and update menuid in the ingdb
function editIngredient(){
    var ingredient = ingredientTable.row($('.selected')).data();
    productId = ingredient.product.id;
    console.log("update edilecek id"+productId);
    var selectedIngredient={
         id: newIngId,
         ingAmount:  $("#ingAmount").val(),
         product: {
           id: productId
         }
    };
    var selectedIngredientJSON =JSON.stringify(selectedIngredient);

    //New Ingredient adding to db
    $.ajax({
        url: api,
        type: "post",
        async: false,
        cache: false,
        timeout: 30000,
        data: selectedIngredientJSON,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function(ingredient, textStatus, jqXHR){
            //newIngId =ingredient.id;
            console.log("update ingredient");
        },
        done: function(xhr,status,error){
            console.log('Text Status:' + status);
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
