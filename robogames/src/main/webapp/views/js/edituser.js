$('#inputName').attr('placeholder',$.cookie('rgname'));
$('#inputFirst').attr('placeholder',$.cookie('rgfirst'));
$('#inputImage').attr('placeholder',$.cookie('rgimage'));
$('#smallName').html($.cookie('rgpseudo'));
$('#btnModif').on('click', function(){
	verifModif();
})

function rgBdd (mdata, request, callback){
	$.ajax({
		type : 'POST',
		data : mdata,
		url : 'http://172.16.15.42:8080/robobogames/'+request,
		dataType : 'json',
		success : function(output, status, xhr) {
			callback(output, status, xhr);
		},
		error : function(err) {
			console.log("erreur =", err);
		}
	});
};

function verifModif(){
	var modif = false;
	obj = {};
	obj['idUser'] = $.cookie('rgid');
		if($('#inputName').val()){
			$.cookie('rgname', $('#inputName').val());
			obj['nom'] = $('#inputName').val();
			modif = true;
		}
		if($('#inputFirst').val()){
			$.cookie('rgfirst', $('#inputFirst').val());
			obj['prenom'] = $('#inputFirst').val();
			modif = true;
		}
		if($('#inputImage').val()){
			$.cookie('rgimage', $('#inputImage').val());
			obj['image'] = $('#inputImage').val();
			modif = true;
		}
		if($('#inputMdp').val() !== '' && $('#inputMdp').val() === $('#inputConfirm').val() && $('#inputMdp').val() !== '' ){
			obj['newPassword'] = $('#inputMdp').val()
			obj['oldPassword'] = $('#inputOld').val()
			modif = true;
		}else if($('#inputMdp').val() !== '' && $('#inputConfirm').val() !== '' && $('#inputMdp').val() === $('#inputConfirm').val()){
			swal("Erreur", "Mot de passe invalide", "error")
		}

		if(modif){
			rgBdd (obj, '/USER/modifierCompte', function(){
				swal("Modifiaction faite", "", "success");
				document.location.href='edituser.html'
			});
		}else{
			swal("Erreur", "Aucune modification demandé", "error")
		}
}
