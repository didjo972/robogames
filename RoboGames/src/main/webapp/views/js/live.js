$('#iframe').attr('height',
	($(window).height()+"px")
);
document.body.style.overflow = 'hidden';

rgBdd('172.16.15.42','USER/recupererUrlLive',function(a,b,c){
	$('#iframe').attr('src',a['object'].url);
});

function rgBdd (url, requete, callback){
var xurl =  'http://'+url+':8080/robobogames/'+requete;
$.ajax({
	type : 'POST',
	url : xurl,
	dataType : 'json',
	success : function(output, status, xhr) {
		callback(output, status, xhr);
	},
	error : function(err) {
		console.log("erreur =", err);
	}
});
};
