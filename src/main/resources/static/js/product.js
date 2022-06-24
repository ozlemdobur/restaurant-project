var api = "http://localhost:9090/api/product" ;
var productTable;
var measurementUnit;
function init(){
//    $('#passwordPolicy').hide();
    console.log('inside init' );
    $("#measurementUnit").click( function () {
    var ele = document.getElementsByName('unit');
        for(i = 0; i < ele.length; i++) {
            if(ele[i].checked){
            measurementUnit = ele[i].value;
            //alert(ele[i].value);
            }
        }
   });

    $("#create-product").click( function () {
        $("#id").val('');
        $("#productName").val('');
        $("#stockAmount").val('');
        $("#minumumLimit").val('');
        $("#supplier").val('');
        $("#piece").attr('checked',false);
        $("#gram").attr('checked',false);
        $("#litre").attr('checked',false);
        $('#productModal').modal('show');
    });
    $("#edit-product").click( function () {
        if (productTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a product!");
        }else{
            var product = productTable.row($('.selected')).data();
            if(product.measurementUnit=="piece"){
                $("#piece").attr('checked','checked');
                measurementUnit="piece";
            }else if(product.measurementUnit=="gram"){
                $("#gram").attr('checked','checked');
                measurementUnit="gram";
            }else if(product.measurementUnit=="litre"){
                 $("#litre").attr('checked','checked');
                 measurementUnit="litre";
            }

            $("#id").val(product.id),
            $("#productName").val(product.productName),
            $("#stockAmount").val(product.stockAmount),
            $("#minumumLimit").val(product.minumumLimit),
            $("#supplier").val(product.supplier),
            $('#productModal').modal('show');
        }
    });
    $("#delete-product").click( function () {
        if (productTable.row($('.selected')).data() == undefined) {
            alert("You have to choose a product!");
        }else{
            $('#productDeleteModal').modal('show');
        }
    });
    $("#deleteProductConfirmButton").click( function () {
        console.log("Inside click of deleteproductButton");
        deleteProduct();
        $('#personnelDeleteModal').modal('hide');
        });
           // Add submit event to form
    $("#modalButton").click( function() {
        createProduct();
    });
    initProductTable();
    getProduct();
}

function initProductTable() {
    console.log('inside initUserTable' );
    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Product ID",
            "data": "id" ,
            "visible": false },
        { "title":  "Product Name",
            "data": "productName" },
        { "title":  "Stock Amount",
            "data": "stockAmount" },
        { "title":  "Minumum Limit",
            "data": "minumumLimit"},
        { "title":  "Measurement Unit",
            "data": "measurementUnit"},
        { "title": "Supplier",
            "data": "supplier",
                    render: function(data,type,row){
                          var supplier = row.supplier;
//                          var html_part ="target="\"_blank"
                          if(row.stockAmount<row.minumumLimit){
                           return "<span style='color:red'>!!!     <a style='color:red' href="+supplier+" target=\"_blank\">"+supplier+"</a></span>";
                          } else {
                            return supplier;
                          }
                    }
            },
    ];

    // Define new table with above columns
    productTable = $("#productTable").DataTable( {
        //"order": [[ 0, "asc" ]],
        "ordering": false,
        "columns": columns
    });
     $("#productTable tbody").on( 'click', 'tr', function () {
            console.log("Clicking on row");
            if ( $(this).hasClass('selected') ) {
              $(this).removeClass('selected');
             }
            else {
                productTable.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    }

function getProduct(){
    console.log('inside getUsers' );
    // http:/localhost:9090/api/customer
    // json list of customers
    $.ajax({
        url: api,
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
function deleteProduct(){
    if (productTable.row($('.selected')).data() == undefined) {
        alert("You have to select a product!");
    }else{
        var product = productTable.row($('.selected')).data();
        $.ajax({
            url: api + '/' + product.id,
            type: "delete",
            contentType: "application/json",
            dataType: "text",  // get back from frontend
            // success: function(customer, textStatus, jqXHR){
            success: function(message){
                console.log(message);
                getProduct();
                //initPersonnelTable();
            },
            fail: function (error) {
              console.log('Error: ' + error);
            },
        });
    }
}
function createProduct(){
    console.log('inside createProduct' );
    var productData = {
        id: $("#id").val(),
        productName: $("#productName").val(),
        stockAmount: $("#stockAmount").val(),
        minumumLimit: $("#minumumLimit").val() ,
        measurementUnit: measurementUnit,
        supplier: $("#supplier").val()
    }
    console.log("ajavtan once");
    // Transform Javascript object to json
    var productJson = JSON.stringify(productData);
    $.ajax({
        url: api,
        type: "post",
        data: productJson,    // json for request body
        dataType: "json", //get back from fronted
        contentType: "application/json; charset=utf-8", // What we send to frontend
        success: function(product, textStatus, jqXHR){
            console.log(product);/*
            // Clear fields in page
            $("#id").val('');
            $("#productName").val('');
            $("#stockAmount").val('');
            $("#minumumLimit").val('');
            $("#unit").val('');
            $("#supplier").val('');*/
            $('#productModal').modal('hide');
            getProduct();
            },
            done: function(xhr,status,error){
                console.log('Text Status:' + status);
            },
            error: function(xhr,status,error){
                console.log('Text Status:' + status);
                console.log("error "+xhr.error);
                //toastr.info('Enter the strong password! Password must be min 8 character.(1 upper, 1 lower, 1 numeric, 1 character)');
//                $("#passwordPolicy").attr('class', 'alert alert-danger d-block');
            },
            fail: function (error) {
                console.log('Text Status:' + status);
            },
    });

}

