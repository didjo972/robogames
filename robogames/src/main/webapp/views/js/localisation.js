//lance AJAX
rgBdd('localhost', function(a,b,c){	
	
	console.log('a =',a);
	console.log('b =',b);
	console.log('c =',c);
	parseRetour(a);
});

$('#debug').on('click', function(){
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

function rgBdd (url, callback){
	var xurl =  'http://'+url+':8080/robobogames/USER/getAllEvenement';
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

function parseRetour(retour){
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
			toModal(obj);
		});
		$('#temp').removeAttr('id');
};

function toModal(evenement){

	$('#mnom').html("Tournoi : "+evenement.nomEvent);
	$('#minfos').html(evenement.infos);
	$('#mstart').html(evenement.dateDebut);
	$('#mend').html(evenement.dateFin);
	$('#mcoord').html(evenement.adresse+", "+evenement.codePostal+" "+evenement.ville);
	if(evenement['debrief'] !== '' && evenement['etat'] === 2){
		console.log('+++++++++++++++++++++++++++++++++++++++++++++++++++++');
		$('#forDebrief').css('display','inline');
		$('#btnDebrief').unbind();
		$('#btnDebrief').on('click', function(){
			fillModal(evenement);
		});
	}else{
		$('#forDebrief').css('display','none');
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
	$('#mcontenue').html(evenement.debrief);
	$('#maModal').modal();
}
