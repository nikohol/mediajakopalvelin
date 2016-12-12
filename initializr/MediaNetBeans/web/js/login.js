function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}
// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
// Login validation

function validateLogin(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
var realusername = "";
var realpword = "";
var user = fetch('getUserJson(@FormParam("username") String username))').then(function(response) {
    // Convert to JSON
    return response.json();
}).then(function(j) {
    // Yay, `j` is a JavaScript object
    realuname = user.username;
	realpword = user.pword;
});

if ( username == realuname && password == realpword){
alert ("Welcome "+username+", enjoy your stay!");
window.location = "index.html"; // Redirecting to main page.
return false;
}
else if(realuname == 'null'){
// turn username form red
alert("Login failed! Check your username and/or password!");
}
else{
	// turn password from red!
}
}