function login() {
  var mail = document.getElementById("email").value;
  var pass = document.getElementById("password").value;
  var rd1 = document.getElementById("admin");
  var rd2 = document.getElementById("student");
  let submitOk = true;

  if (mail.length == 0) {
    alert("Invalid email");
    submitOk = false;
  }

  if (pass.length < 10 || submitOk == false) {
    alert("Invalid password");
    submitOk = false;
  }
  if (submitOk == true) {
    if (rd1.checked == true) {
      window.open("Admin.html");
    } else if (rd2.checked == true) {
      window.open("student.html");
    } else {
      alert("Nothing is selected!!");
    }
  }
}
