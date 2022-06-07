


    getCustomers();

}

var api = "http://localhost:9090/api/product" ;

init();

function init(){

    $("#list-product").click(function (){
        listProduct();
    });
    listProduct();

}

function listProduct(){

    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        contentType: "application/json",
        success: function(products, textStatus, jqXHR){

/*            $.each(products, function(index, product) {
                console.log(product.productName + ' ' + product.measurementUnit + ' yrs');
            });

            // process the data (json) and modify the DOM
            console.log('status: ' + jqXHR.status + ', data: '
            + products[0].id
            + products[0].productName
            + products[0].newAmount);*/

            $("#id").val(products[0].id);
            $("#productName").val(products[0].productName);
            $("#newAmount").val(products[0].newAmount);
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}

function createCustomer(){

    console.log('inside createCustomer' );

}
