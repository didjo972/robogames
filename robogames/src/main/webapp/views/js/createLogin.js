$('#btnSave').on('click', function(){
var mail = $('#inputMail').val();
var pseudo = $('#inputPseudo').val();
var mdp = $('#inputPass').val();
var confirm = $('#inputConfirm').val();
var pattern = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
  console.log("click");
  if(mdp === confirm && mdp !== ''){
  if(pseudo === "insta"){
    swal("Erreur", "Pseudo 'insta' interdit", "error")
    return;
  }
    console.log("mdp === confirm && mdp !== ''");
    if( pattern.test(mail) && pseudo !== ''){
      console.log("pattern.test(mail && pseudo !== '')");
      var obj = {};
      obj['email'] = mail;
      obj['pseudo'] = pseudo;
      obj['password'] = mdp;
      obj['image'] = 'http://letsmakerobots.com/files/userpics/picture-1442.gif';
      request('creerCompte', obj , function(a,b,c){
        console.log('a = ',a);
        getResult(a);
      });
    }
  }else{
    console.log('nop');
  }
});

function request ( requete, mdata, callback){
	var xurl =  'http://172.16.15.42:8080/robobogames/'+requete;
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

function getResult(a){
  if(a.object){
    var idUser = a['object'].idUser;
    $.cookie('rgid', a['object'].idUser);
    $.cookie('rgrole', a['object'].libelleHabilitation);
    $.cookie('rgname', a['object'].nom);
    $.cookie('rgfirst', a['object'].prenom);
    $.cookie('rgpseudo', a['object'].pseudo);
    $.cookie('rgimage', a['object'].image);
    if(a['object'].libelleHabilitation === 'Utilisateur'){
      document.location.href="accueil.html";
    }
    if(a['object'].libelleHabilitation === 'Administrateur'){
      document.location.href="accueil_administration.html";
    }
  }
}
