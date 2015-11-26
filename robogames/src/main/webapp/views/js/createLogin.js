$('.i-checks').iCheck({
    checkboxClass: 'icheckbox_square-green',
    radioClass: 'iradio_square-green',
});

$('#btnSave').on('click', function(){
var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
  if($('#inputPass').val() === $('#inputConfirm').val() && $('#inputPass').val() !== ''){
    if( pattern.test($('#inputMail').val())){
      request('172.16.15.42','creerCompte', function(a,b,c){
        console.console.log('a = ',a);
        getResult(a);
      });
    }
  }else{
    console.log('nop');
  }
});

function request (url, requete, callback){
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
	console.log('url =',xurl);
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
		data: {"idUser": "2"},
		success : function(output, status, xhr) {
			callback(output, status, xhr);
		},
		error : function(err) {
			console.log("erreur =", err);
		}
	});
};

function getResult(a){
  if(a.object){
    var idUser = a['object'].idUser;
    $.cookie('RGId', idUser);
    if(a['object'].libelleHabilitation === 'Utilisateur'){
      document.location.href="http://www.web.site/";
    }
    if(a['object'].libelleHabilitation === 'Administrateur'){
      document.location.href="http://www.web.site/";
    }
  }
}
