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
// Sorting the images displayed
$(document).ready(function (event) {
	//sort by date
	if (!event.target.matches('.dropbtn')) {
                $.ajax({
                    type: "GET",
                    url: "",
                    success: function (data, textStatus, xhr) {
                        $("#users").text(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log("Error: " + errorThrown);
                    }
                });
            });