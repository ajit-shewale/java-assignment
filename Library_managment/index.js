function login() {
    
    var rd1 = document.getElementById("admin");
    var rd2 = document.getElementById("student");
  
   
        if(rd1.checked == true)
        {
            console.log("i am admin");
            window.open("Admin.html");
        }
        else if(rd2.checked == true)
        {
            console.log("i am student");
            window.open("student.html");
        }
        else
        {
            alert("Nothing is selected!!")
        }
    
  

}