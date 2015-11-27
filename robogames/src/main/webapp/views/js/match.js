rgBdd('localhost',{}, '/USER/getEvenementByUser', function(a,b,c){
	console.log('a =',a);
	console.log('b =',b);
	console.log('c =',c);
	parseRetour(a);
});

var summernote, thisEvent;

$('#debug').on('click', function(){
	var cookie = $.cookie('rgid');
	console.log(cookie);
});

$('#close').on('click', function(){
	$('#ludoModal').css('display','none');
});

 var monDTT = $('#matable').DataTable( {
	"paging": false,
    "info": false,
	"bFilter": false,
	columns: [
		{ title: "Evenement" },
		{ title: "debut" },
		{ title: "fin" },
		{ title: "Capacitée max" },
		{ title: 'plus' }
	]
} );

function rgBdd (url, mdata, requete, callback){
	mdata.idUser = $.cookie('rgid');
	var xurl =  'http://'+url+':8080/robobogames'+requete;
	console.log('url =',xurl);
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

$('#saveDebrief').on('click', function(){
	var text = summernote.code();
	saveDebrief(text);
});

function parseRetour(retour){
console.log('parseRetour = ',retour);
	if(retour.retour.message === 'OK'){
		var list = retour.object;
		var lg = list.length;
		for(var i = 0; i<lg; i++){
				goDatatable(list[i]);
		}
	}else{
		console.log("erreur pour l'objet : ",retour);
	}
};

function goDatatable(obj){
	 monDTT.row.add( [
            obj.nomEvent,
            obj.dateDebut,
            obj.dateFin,
            obj.nbPlace+" personnes",
			'<button id="temp" type="button" class="btn btn-outline btn-primary">Details</button>'
        ] ).draw( false );
		$('#temp').on('click', function(id){
			$('#temp').attr('id',obj.idEvent);
			thisEvent = obj;
			toModal(obj);
		});
		$('#temp').removeAttr('id');
};

function toModal(evenement){
	console.log('ludoDEBUG = ',evenement);
	console.log(evenement.etat);
	$('#mnom').html("Tournoi : "+evenement.nomEvent);
	$('#minfos').html(evenement.infos);
	$('#mstart').html(evenement.dateDebut);
	$('#mend').html(evenement.dateFin);
	$('#mcoord').html(evenement.adresse+", "+evenement.codePostal+" "+evenement.ville);
	if(evenement.etat === 2){
		console.log('evenement.etat === "2"');
		$('#makeDebrief').css('display','inline');
		$('#btnMakeDebrief').unbind();
		$('#btnMakeDebrief').on('click', function(){
			fillModal(evenement);
		});
	}else{
		$('#makeDebrief').css('display','none');
	}
	$('#ludoModal').css('display','inline-block');
    var map = new GMaps({
        div: '#basic_map',
        lat: 46.6977000,
        lng:  2.4820137,
        width: '100%',
        height: '300px',
        zoom: 5,
        zoomControl: true,
        zoomControlOpt: {
            style: 'SMALL',
            position: 'TOP_LEFT'
        },
        panControl: false
    });
	var rue = evenement.adresse;
	var url = "http://maps.googleapis.com/maps/api/geocode/json?address="+evenement.adresse+"%20"+evenement.ville+"&sensor=true"
	$.ajax({
		url:  url,
		success: function(data){
			var lat = data.results[0].geometry.location.lat;
			var lng = data.results[0].geometry.location.lng;
			map.addMarker({
				lat: lat,
				lng:lng,
				title: 'Lima',
				click: function(e) {
					alert("bouh");
				},
				dataType: 'json'
			});
		}
	});
};

function fillModal(evenement){
	$('#summernote').html(evenement.debrief);
	summernote = $('#summernote').summernote();
	$('#maModal').modal();
}

function saveDebrief(text){
	var obj = {};
	obj['idEvent'] = thisEvent.idEvent;
	obj['debrief'] = text;
	console.log('obj = ',obj);
	
	rgBdd('localhost',obj, '/USER/modifierDebrief', function(a,b,c){
		console.log("retour = ",a);
		if(a['retour'].message === 'OK'){
			swal("Modification faite", "", "success")
		}else{
			swal("Erreur", "Modification invalide", "error")
		};
	});
	thisEvent.debrief = text;
	var idBtn = '#'+thisEvent.idEvent;
	var newBtn = $(idBtn);
	newBtn.unbind();
	newBtn.on('click',function(){
		toModal(thisEvent);
	});
};
