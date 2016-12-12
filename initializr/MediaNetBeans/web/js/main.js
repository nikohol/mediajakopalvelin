/*var xhr = new XMLHttpRequest();
// Create XMLHttpRequest object. Name it xhr.
function showImages() {
	if (this.readyState == 4 && this.status == 200) {
		var arr = JSON.parse(this.responseText);
		for (var i = 0; 1 < arr.length; i++) {
			var img = document.createElement('img');
			img src = 'img/recent' + arr[i].mediaRecent;
			console.log(arr[0]);
		}
	}
}
xhr.open('GET', 'images.json', true);
xhr.send;*/
/*function myFunction() {
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
}*/
/* Set the width of the side navigation to 250px */


/*

*/
$('.vasen-navi li:first-child').click(function(evt){
				evt.preventDefault();
				$('.vasen-navi li:not(:first)').slideToggle(400);
			});
/*
Top right menu button and it's caleld withv myFunction();
*/
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
function changeContent(showing){
        document.getElementById("pageContent").innerHTML = showing;
}
/*
// Sorting the images displayed
$(document).ready(function (event) {
	//sort by Most recent
	if (!event.target.matches('.recent')) {
                $.ajax({
                    type: "GET",
					//add url
                    url: "",
                    success: function (data, textStatus, xhr) {
                        $("#users").text(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log("Error: " + errorThrown);
                    }
                });
            });
	
	//sort by most popular (most likes)
	if (!event.target.matches('.popular')) {
		
	}
	//show friends uploads by date
	if (!event.target.matches('.friends')) {
		
	}
*/
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
function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
