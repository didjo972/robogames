var ip = '';
var bool = false;
var ludotest = ["uvresp","03AHJ_VuvzkdC5hj6C-EUHE30uSJZkAbGsfkwXnScDZhGy4XT9YCeFgZ5-X4H6zH0AeBrhs2qsjXW5N4qRyRnJtSkb5Hl3DTJeZ8fm9LC4zvqzGUcwEU7gtXGYzYs63AZ35-ksY3JI5CmXQ4SEPsfuRecmriF8OydWw2PyZKVQkGVJmlUC3qJQIAKyidc5S7PTlujHk-UMBM1mb3rJaMAIqwdMROfdWwNUAkxe80LpRRfBqBOsr6ybcxKDfhTtSOxScpVwFF0nXOdsk0RNMJNAxPMlp_OFXZlqAswAibJTPG7AdXe-q0tcc2gQ6MLLiZyvPAxGjk95c4D_LyhFENmOOqTsNC9Jp3UFYsL28TtLDU0Ol3FQ_Z5uqDMep_KORBBqSlKN8cxyXmoNjOHfIxxOOeh7NC8YpTrpnneh1eeOc4FvFN-yuZ_bZNd0iiw3QHCc_GCIZ_PbOeN2-yvyqeVatDjkwy2gxT0Tl1WS6J6QP8HxhZILiBJPCv9eR66ckDzExt9b86BkvXr3KiIyCt6hba69VA10gUScQ-EjeIhED8rsvqDxMgcbtDzKCFASQg7trk5FAFQNxQaLZLchLwbnohTGNBRbMcIYKxkP6jslYpdbRhQ1O8_XZJND1cWjI8Cp6La_sgcLs8denusCwQBMeS1-gchI-Fkq1E5IDfZ3Sqc2W_VNYn-azslN4_r-qKxDvytxhFrSQqrfqLKD932BRwYrmz1WVG65lpXwXLc8232c0AQ8_mGcBJgxb8bVRkzw0NvnmOKzkekyjpDl1EJWtq4QHLu7VPP-sQpHF_CO01KWB9IpORUkon0WTV5pZQrF701rpLe9oLfx7kcAIBYhKtnG0ypbZkUC7U-vtu3TEJ6EZz5CgE8M2ndu7HrjcV_QYbvdZ0kNCFN6uLQE3ibDmtlYBMaJYekFojdgBt-hxdQMnxx7xS4mlDWj_5P1G7J4cI3gWXX-ujMo",1,120];
$('#btnLogin').on('click', function(){
  var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
	if(!bool){
		swal("Erreur", "Captcha non valide", "error")
	}
	if($('#inputPass').val()!== '' && pattern.test($('#inputMail').val()) && bool){
    var obj = {};
    obj.mail = $('#inputMail').val();
    obj.password = $('#inputPass').val();
		obj.image = 'http://letsmakerobots.com/files/userpics/picture-1442.gif';
    request  ('172.16.15.42',obj,'login',function(a,b,c){
      console.log('a = ',a);
      if(a['object']){
				if(a['object'].etatHabilitation === "1"){
	        $.cookie('rgid', a['object'].idUser);
	        $.cookie('rgrole', a['object'].libelleHabilitation);
					$.cookie('rgname', a['object'].nom);
					$.cookie('rgfirst', a['object'].prenom);
					$.cookie('rgpseudo', a['object'].pseudo);
          $.cookie('rgimage', a['object'].image);
					document.location.href="accueil.html"
				}else{
					$.cookie('rgid', 'none');
					swal("Bannis", "Vous êtes Bannis", "error")
          $.cookie('rgrole', 'none');
				}
      }else{
        $.cookie('rgid', 'none');
				$.cookie('rgrole', 'none');
				swal("Erreur", "Connexion impossible", "error")
			}
    });
  }else if($('#inputPass').val()=== '' && $('#inputMail').val() === ''){
		swal("Erreur", "Champs non saisie", "error")
	};
});

function request (url, mdata, requete, callback){
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
		data: mdata,
		success : function(output, status, xhr) {
			callback(output, status, xhr);
		},
		error : function(err) {
			console.log("erreur =", err);
		}
	});
};
$.get("http://ipinfo.io", function(response) {
    ip = response.ip;
}, "jsonp");


function backCaptcha(retour){
  bool = true;
}
