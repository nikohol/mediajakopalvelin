var xhr = new XMLHttpRequest();
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
xhr.send;
