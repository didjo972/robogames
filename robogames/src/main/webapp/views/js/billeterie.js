var mSteps = $("#buyTicket");
var panier = [];
var toPay = 0;
var monDTT = '';
var panierDTT = '';
var cb = {};
var moyenPaiement = false;
mSteps.steps({
	headerTag: "h3",
	bodyTag: "section",
	transitionEffect: "fade",
	autoFocus: true,
	enableFinishButton: false,
	labels: {
			 current: "current step:",
			 pagination: "Pagination",
			 next: "Suivant",
			 previous: "Précédant",
			 loading: "Chargement ..."
	 },
	onStepChanged: function (event, currentIndex, priorIndex)
{
		if (currentIndex === 2)
		{
				$('#paypalPrice').html(toPay+' €');
				$('#cbPrice').html(toPay+' €');
				$('#cbNumber').mask('9999-9999-9999-9999');
				$('#cbDate').mask('99-99');
				$('#cdCode').mask('999');
		}
		if (currentIndex === 3)
		{
				if(!moyenPaiement){
					mSteps.steps("previous");
					swal("Erreur", "Aucun moyen de paiement précisé", "error");
				}
				if(cb.cbNumber){
					console.log(cb);
					$('#p4Pay').html('carte numero'+cb.cbNumber);
					remplirPageQuatre();
					$('#btnValidAchat').css('display','inline-block');
				}else{
					$('#btnValidAchat').css('display','none');
				}
		}
},
});

$('.actions').css('padding-bottom','40px');

monDTT = $('#matable').DataTable( {
 "paging": false,
	 "info": false,
 "bFilter": false,
 columns: [
	 { title: "Evenement" },
	 { title: "debut" },
	 { title: "fin" },
	 { title: "places restantes" },
		{ title: "Prix" },
	 { title: 'Acheter' }
 ]
} );

rgBdd({},'USER/getAllEvenement', function(a,b,c){
	parseRetour(a);
});

$('#btnModal').on('click', function(){
	$('#modalPanier').modal();
	fillModalPanier();
});

$('#btnEmpty').on('click', function(){
	viderPanier();
});

$('#btnValidCb').on('click', function(){
	valideCb();
});

$('#btnValidAchat').on('click', function(){
	valideAchat();
});

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

function parseRetour(retour){
	if(retour.retour.message === 'OK'){
		var list = retour.object;
		var lg = list.length;
		for(var i = 0; i<lg; i++){
				goDatatable(list[i]);
				console.log('evenement = ',list[i])
		}
	}else{
		console.log("erreur pour l'objet : ",retour);
	}
};

function goDatatable(obj){
	 monDTT.row.add( [
            obj.nomEvent,
            obj.dateDebut.split(' '),
            obj.dateFin,
            obj.nbPlaceRestant+" personnes",
						obj.prix+" €",
			'<div class="input-group m-b"><input id="tempInput" class="form-control" type="text" placeholder="Nombre places"> <a id="temp" class="input-group-addon"><i class="fa fa-shopping-cart"></i></a></div>'
        ] ).draw( false );
		$('#temp').on('click', function(id){
			var input = $(this).parent().children().first();
			addPanier(input, obj, $(this));
		});
		$('#temp').removeAttr('id');
		$('#tempInput').mask('000');
		$('#tempInput').removeAttr('id');
};

function addPanier(input, evenement, btnA){
	var nbTicket = parseInt(input.val());
	var nbRestant = parseInt(evenement.nbPlaceRestant);
	if(nbTicket <= nbRestant && nbTicket>0){
		swal("Reservation faite", "", "success");
		input.attr('disabled', 'disabled');
		btnA.remove();
		reservation(nbTicket, evenement);
	}else{
		swal("Erreur", "Nombre de place invalide", "error")
	}
}

function reservation (nbPlaces, evenement){
	evenement.reservation = nbPlaces;
	panier.push(evenement);
	toPay = toPay + (nbPlaces*evenement.prix);
	$('#toPay').html(toPay+" €&nbsp;&nbsp;");
}

function fillModalPanier(){
	var papa = $('#panierTable').parent();
	$('#panierTable').remove();
	papa.append($('<table id="panierTable" class="display" width="100%"></table>'));
	panierDTT = $('#panierTable').DataTable( {
	 "paging": false,
		 "info": false,
	 "bFilter": false,
	 columns: [
		 { title: "Evenement" },
		 { title: "nombre de places" },
		 { title: "prix" }
	 ]
	} );
	for(var i =0; i<panier.length; i++){
	toPanierModal(panier[i]);
	}
	$('#resultToPay').html(toPay);
}

function toPanierModal(obj){
	panierDTT.row.add( [
					 obj.nomEvent,
					 obj.reservation,
					 obj.prix
			 ] ).draw( false );
}

function viderPanier(){
	panier = [];
	toPay = 0;
	monDTT.clear();
	rgBdd({},'USER/getAllEvenement', function(a,b,c){
		parseRetour(a);
	});
	$('#toPay').html(toPay);
}

function valideCb(){
	var cbNumber = $('#cbNumber').val();
	var cbDate = $('#cbDate').val();
	var cdCode = $('#cdCode').val();
	var cbPossessor = $('#cbPossessor').val();
	if(cbNumber && cbDate && cdCode && cbPossessor	){
		cb.cbNumber = cbNumber;
		cb.cbDate = cbDate;
		cb.cdCode = cdCode;
		cb.cbPossessor = cbPossessor;
		moyenPaiement = true;
			swal("Valide", "Paiement par carte bancaire", "success");
	}else{
		cb = {};
		moyenPaiement = false;
		swal("Erreur", "Carte bancaire non valide", "error");
	}
}

function remplirPageQuatre(){
	$('#p4Liste').childrens.remove();
	for(var i =0; i<panier.length; i++){
		var match = panier[i];
		var span = $('<span></span>');
		span.attr('class','form-control-static');
		span.html(match.reservation+"place(s) pour l'événement "+match.nomEvent);
		console.log(match);
		$('#p4Liste').append('<br>');
		$('#p4Liste').append(span);
	}

};

function valideAchat(){
	for(var i = 0; i<panier.length; i++){
		var match = panier[i];
		console.log(match);
		var obj = {};
		obj.idUser = '105';
		obj.idEvent = match.idEvent;
		obj.nbPlace = match.reservation;
		rgBdd(obj,'/USER/acheterBillet', function(a,b,c){
			console.log('retour reservation = ',a);
		});
	}

}
