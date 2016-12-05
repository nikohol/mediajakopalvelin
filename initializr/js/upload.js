/* var xhr = new XMLHttpRequest();
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
xhr.send */

/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
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