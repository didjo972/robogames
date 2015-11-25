var role = $.cookie('rgrole');
console.log('role = ',role)
var page = document.location.href;
page = page.split('/');
pageLength = page.length;
page = page[pageLength-1]

var fail = true;
var lAdmin = ['accueil_administration.html','gestion_billeterie.html','gestion_debriefing.html','gestion_live.html','gestion_match.html','gestion_utilisateur.html'];
var lUser = ['billeterie.html','creatematch.html','edituser.html','match.html','accueil.html','createLogin.html','live.html','localisation.html','login.html'];
var lNone = ['accueil.html','createLogin.html','live.html','localisation.html','login.html'];

///////////////////////////////////////////////// ADMIN
if(role === 'Administrateur'){
  $('#pageMatch').css('display','inline');
  $('#createMatch').css('display','inline');
  $('#editUser').css('display','inline');
  $('#btnDeco').on('click', function (){
	  console.log("demande déco");
    $.cookie('rgrole', 'none');
    document.location.href="accueil.html";
  })

  for(var i = 0; i<lAdmin.length; i++){
    if(lAdmin[i] === page){
      fail = false;
    }
  }

  if(fail){
    document.location.href="accueil_administration.html"
  }

///////////////////////////////////////////////// USER

}else if (role === 'Utilisateur') {
  $('#pageMatch').css('display','inline');
  $('#createMatch').css('display','inline');
  $('#pageBilleterie').css('display','inline');
  $('#editUser').css('display','inline');
  $('#spanCo').html('Deconnexion');
  $('#btnCo').on('click', function(){
    $.cookie('rgrole', 'none');
    document.location.href="accueil.html";
  });

  for(var i = 0; i<lUser.length; i++){
    if(lUser[i] === page){
      fail = false;
    }
  }

  if(fail){
    document.location.href="accueil.html"
  }


///////////////////////////////////////////////// NONE

}else{

  $('#pageMatch').css('display','none');
  $('#createMatch').css('display','none');
  $('#pageBilleterie').css('display','none');
  $('#editUser').css('display','none');
  for(var i = 0; i<lNone.length; i++){
    if(lNone[i] === page){

      fail = false;
    }
  }

  if(fail){
    //document.location.href="accueil.html"
  }
}
