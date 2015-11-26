var file = '';
document.getElementById('fileinput').addEventListener('change', function(){
    file = this.files[0];
    console.log("name : " + file.name);
    console.log("size : " + file.size);
    console.log("type : " + file.type);
    console.log("date : " + file.lastModified);
}, false);

$('#debug').on('click', function(){
    console.log("name : " + file.name);
    console.log("size : " + file.size);
    console.log("type : " + file.type);
    console.log("date : " + file.lastModified);
    request('upload', file)
});

function uploadFile(file){
var xhr = new XMLHttpRequest();
var fd = new FormData();
xhr.open("POST", 'http://172.16.15.42:8080/robobogames/upload', true);
xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        console.log(xhr.responseText); // handle response.
    }
};
fd.append("upload_file", file);
xhr.send(fd);
}

function request( requete, mdata){
    test = JSON.stringify(getBase64Image(mdata));
	var xurl =  'http://172.16.15.42:8080/robobogames/'+requete;
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
		data: test,
		success : function(output, status, xhr) {
			callback(output, status, xhr);
		},
		error : function(err) {
			console.log("erreur =", err);
		}
	});
};

function getBase64Image(imgElem) {
// imgElem must be on the same server otherwise a cross-origin error will be thrown "SECURITY_ERR: DOM Exception 18"
    var canvas = document.createElement("canvas");
    canvas.width = imgElem.clientWidth;
    canvas.height = imgElem.clientHeight;
    var ctx = canvas.getContext("2d");
    ctx.drawImage(imgElem, 0, 0);
    var dataURL = canvas.toDataURL("image/png");
    return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
}
