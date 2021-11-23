

var array = [];
var x  = document.createElement("cart");
function intoCart()
{
    
    var row =0;
    var display  = document.getElementById("display");

    if(document.getElementById("check1").checked == true)
    {
        var newRow  = display.insertRow(row);  
        newRow.innerHTML = document.getElementById("check1").value;
        row++;
    }

    if(document.getElementById("check2").checked == true)
    {
        var newRow  = display.insertRow(row);  
        newRow.innerHTML = document.getElementById("check2").value;
        row++;
    }

    if(document.getElementById("check3").checked == true)
    {
        var newRow  = display.insertRow(row);  
        newRow.innerHTML = document.getElementById("check3").value;
        row++;
    }

    
}