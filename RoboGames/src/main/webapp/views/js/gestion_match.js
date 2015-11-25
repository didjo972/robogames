//lance AJAX
rgBdd('172.16.15.42',{} , 'ADMIN/getAllEvenement', function(a,b,c)
{
	console.log('a =',a);
	console.log('b =',b);
	console.log('c =',c);
	parseRetour(a);
});

$('.contact-box').each(function() 
{
    animationHover(this, 'pulse');
 });

function rgBdd (url, mdata, requete, callback)
{
	console.log('mdata = ',mdata);
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
	console.log('url =',xurl);
	console.log('data =',mdata);
	mdata.idAdmin = '107';
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
		data: mdata,
		success : function(output, status, xhr) 
		{
			callback(output, status, xhr);
		},
		error : function(err) 
		{
			console.log("erreur =", err);
		}
	});
};

function parseRetour(retour)
{
	console.log('parseRetour = ',retour);
	if(retour.retour.message === 'OK')
	{
		var list = retour.object;
		var lg = list.length;
		for(var i = 0; i<lg; i++)
		{
			contactBox(list[i]);
		}
	}
	else
	{
		console.log("erreur pour l'objet : ",retour);
	}
};

function contactBox(evenement)
{
	var div1 = $('<div class="clearfix"></div>');
	var address = $('<address></address>');
	address.html(evenement.dateDebut+ '<br>'+ evenement.dateFin+ '<br>');
	var p = $('	<p></p>');
	p.html('<i class="fa fa-map-marker"></i>'+' '+evenement.adresse);
	var h3 = $('<h3></h3>');
	var strong = $('<strong></strong>');
	strong.html(evenement.nomEvent);
	h3.append(strong);
	var div2 = $('<div class="col-sm-8"></div>');
	div2.append(h3);
	div2.append(p);
	div2.append(address);
	var div3 = $('<div class="m-t-xs font-bold"></div>');
	div3.html(evenement.idEvent);
	var imag = $('<img alt="image" class="img-circle m-t-xs img-responsive" src="img/combat.jpg">');
	var div4 = $('<div class="text-center"></div>');
	div4.append(div3);
	div4.append(imag);
	var div5 = $('<div class="col-sm-4"></div>');
	div5.append(div4);
	var a = $('<a id="boite"></a>');
	a.append(div5);
	a.append(div2);
	a.append(div1);
	var div6 = $('<div class="contact-box"></div>');
	div6.append(a);
	var div7 = $('<div class="col-lg-4"></div>');
	div7.append(div6);
	animationHover(div7, 'pulse');
	
	a.on('click', function (idEvent)
	{
		if(evenement.valide == true)
		{
			$('#modal_trueValid').modal();
		}
		else
		{
			console.log('click =');
			edit(evenement);
		}
	});

	$('#content-contact-box').append(div7);
}

function edit(evenement)
{
	console.log(evenement);
	$('#label_id').val(evenement.idEvent);
	$('#label_Nom').val(evenement.nomEvent);
	$('#label_date').val(evenement.dateDebut+' / '+evenement.dateFin);
	$('#label_adresse').val(evenement.adresse+' '+evenement.codePostal+' '+evenement.ville);
	$('#label_nbPlace').val(evenement.nbPlace);
	$('#label_prix').val(evenement.prix);
	$('#label_infos').val(evenement.infos);
	$('#modal_edit').modal();
	
	$('#btnValider').on('click', function ()
	{
		console.log('click =',evenement);
		ValidEvent(evenement.idEvent);
	});
	$('#btnInValider').on('click', function ()
	{
		console.log('click =',evenement);
		modalRaison(evenement);
	});
}

function ValidEvent(idEvent)
{
	console.log('idEvent = ',idEvent)
	var obj = {};
	obj.idEvent = idEvent;
	rgBdd('172.16.15.42', obj, 'ADMIN/validerEvenement', function(a,b,c)
	{
		console.log(a);
	});
}

function modalRaison(evenement)
{
	$('#label_idRaison').val(evenement.idEvent);
	$('#myModal').modal();
	
	$('#soumis_raison').on('click', function ()
	{
		console.log('click =',evenement);
		inValidEvent(evenement);
	});
}

function inValidEvent(evenement)
{
	console.log(evenement)
	var obj = {};
	obj.idEvent = $('#label_idRaison').val();
	obj.raison = $('#label_raison').val();
	rgBdd('172.16.15.42', obj, 'ADMIN/invaliderEvenement', function(a,b,c)
	{
		console.log(a);
	});
}






	
$('#debug').on('click', function ()
{
	var obj = 
	{
	   "object":[
		{
			"idEvent": "103",
			"nomEvent": "Premier Combat",
			"dateDebut": "Wed Nov 18 14:59:42 CET 2015",
			"dateFin": "Wed Nov 18 14:59:42 CET 2015",
			"adresse": "17 rue linné",
			"codePostal": 75005,
			"ville": "Paris",
			"nbPlace": 50,
			"nbPlaceRestant": 5,
			"prix": 15,
			"etat": "2",
			"infos": "Venez avec un parapluie.",
			"valide": true,
			"idUser": "10001",
			"debrief": ""
		},
		{
			"idEvent": "103",
			"nomEvent": "Deuxième Combat",
			"dateDebut": "Wed Nov 18 14:59:42 CET 2015",
			"dateFin": "Wed Nov 18 14:59:42 CET 2015",
			"adresse": "36 rue du faubourg",
			"codePostal": 75003,
			"ville": "Paris",
			"nbPlace": 50,
			"nbPlaceRestant": 45,
			"prix": 15,
			"etat": "2",
			"infos": "Venez comme vous êtes",
			"valide": true,
			"idUser": "10001",
			"debrief": "Ceci est un debrief."
		}
	   ],
	   "retour": {"message": "OK"}
	}
	
	parseRetour(obj);
});


//var cadre = $('.contact-box');
//var nbactif = 0;
//var list = [];
//cadre.each(function()
//{
//	list.push(this);
//});
//var actif = list[0];
//actif = $(actif);
		
//$(document).keypress(function(e) 
//{
//	if(e.keyCode === 37) 
//	{
//		cadre.closest;
//		cadre.prev();
//		actif.css('border','1px solid #0066FF');
//	}
//	if(e.keyCode === 39) 
//	{
//		cadre.closest;
//		cadre.next();
//		actif.css('border','1px solid #0066FF');
//	}
//});
		