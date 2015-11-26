$('#btnLogin').on('click', function(){
  var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
  if($('#inputPass').val()!== '' && pattern.test($('#inputMail').val())){
    var obj = {};
    obj.mail = $('#inputMail').val();
    obj.password = $('#inputPass').val();
    request  ('172.16.15.42',obj,'login',function(a,b,c){
      console.log('a = ',a);
      if(a['object']){
				if(a['object'].etatHabilitation === "1"){
	        $.cookie('rgid', a['object'].idUser);
	        $.cookie('rgrole', a['object'].libelleHabilitation);
					$.cookie('rgname', a['object'].nom);
					$.cookie('rgfirst', a['object'].prenom);
					$.cookie('rgpseudo', a['object'].pseudo);
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
