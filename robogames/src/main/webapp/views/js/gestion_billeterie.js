//lance AJAX
//rgBdd('172.16.15.42',{} , 'ADMIN/getAllBillets', function(a,b,c)
rgBdd('localhost',{} , 'ADMIN/getAllBillets', function(a,b,c)
{
	console.log('a =',a);
	console.log('b =',b);
	console.log('c =',c);
	parseRetour(a);
});

function rgBdd (url, mdata, requete, callback)
{
	console.log('mdata = ',mdata);
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
	console.log('url =',xurl);
	console.log('data =',mdata);
	mdata.idAdmin = $.cookie('rgid');
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
			billet(list[i]);
		}
	}
	else
	{
		console.log("erreur pour l'objet : ",retour);
	}
};

function billet(evenement)
{
	var p_place = $('<p></p>');
	p_place.html('Nombres de places restantes : '+evenement.nbPlaceRestant+' / '+evenement.nbPlace);
	var p_prix = $('<p></p>');
	p_prix.html('Prix du billet : '+evenement.prix+' €');
	var strong = $('<strong></strong>');
	strong.html('Nom evenement : '+evenement.nomEvent);
	var p_evenement = $('<p class="m-b-xs"></p>')
	p_evenement.append(strong);
	var p_idEvent = $('<p></p>');
	p_idEvent.html('Id evenement : '+evenement.idEvent);
	var div_last = $('<div class="col-xs-7 content no-top-border"></div>');
	div_last.append(p_idEvent);
	div_last.append(p_evenement);
	div_last.append(p_prix);
	div_last.append(p_place);
	var apart = $('<p></p>');
	apart.html(evenement.pseudo+'<br>'+'<br>'+'Id User : '+evenement.idUser);
	var img_icon = $('<i class="fa fa-ticket"></i>');
	var div_first = $('<div class="col-xs-3 date"></div>');
	div_first.append(img_icon);
	div_first.append(apart);
	var div_2 = $('<div class="row"></div>');
	div_2.append(div_first);
	div_2.append(div_last);
	var div_1 = $('<div class="timeline-item"></div>')
	div_1.append(div_2);	
	
	$('#content_ibox').append(div_1);	
}
