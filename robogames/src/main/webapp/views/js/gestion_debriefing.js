//lance AJAX
//rgBdd('172.16.15.42',{} , 'ADMIN/getAllEvenement', function(a,b,c)
rgBdd('localhost',{} , 'ADMIN/getAllEvenement', function(a,b,c)
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
			console.log('PUTINDEMOTHERFUCKER',list[i]);
			debrifBox(list[i]);
		}
	}
	else
	{
		console.log("erreur pour l'objet : ",retour);
	}
};

function debrifBox(evenement)
{
	var img_edit = $('<i class="fa fa-pencil"></i> ');
	var a_edit = $('<a class="btn btn-white btn-sm"></a>');
	var edit = $('<a></a>')
	edit.html(' Edit');
	a_edit.append(img_edit);
	a_edit.append(edit);
	var td_last = $('<td class="project-actions"></td>');
	td_last.append(a_edit);
	var img_img = $('<img alt="image" class="img-circle" src="img/combat.jpg">');
	var a_img = $('<a></a>');
	a_img.append(img_img);
	var td_tree = $('<td class="project-people"></td>');
	td_tree.append(a_img);
	var small = $('<small></small>');
	small.html(evenement.dateDebut);
	var br = $('<br>');
	var a_name = $('<a></a>');
	a_name.html(evenement.nomEvent);
	var td_two = $('<td class="project-title"></td>');
	td_two.append(a_name);
	td_two.append(br);
	td_two.append(small);
	var span = $('<span class="label label-primary"></span>');
	span.html('active');
	var td_first = $('<td class="project-status"></td>');
	td_first.append(span);
	var tr = $('<tr></tr>');
	tr.append(td_first);
	tr.append(td_two);
	tr.append(td_tree);
	tr.append(td_last);
	var tbody = $('<tbody></tbody>');
	tbody.append(tr);
	var table = $('<table class="table table-hover"></table">');
	table.append(tbody);
	var div = $('<div class="project-list"></div>')
	div.append(table);
	
	console.log('debrifBox',evenement);
	
	a_edit.on('click', function ()
	{
		console.log('click =',evenement);
		editeur(evenement);
	});
	
	$('#content_idbox').append(div);
}

function editeur(evenement)
{
	console.log("ludo test = ",evenement);
	$('#idEvent_modif').val(evenement.idEvent);
	$('#nom_modif').val(evenement.nomEvent);
	$('#adress_modif').val(evenement.adresse+' '+evenement.codePostal+' '+evenement.ville);
	$('#code_modif').val(evenement.codePostal);
	$('#ville_modif').val(evenement.ville);
	$('#DTF_modif').val(evenement.dateFin);
	$('#debrief_modif').val(evenement.debrief);
	$('#modal_edit').modal();
	
	$('#save_edit').on('click', function ()
	{
		console.log('click =',evenement);
		modifier_edit(evenement);
	});
}

function modifier_edit(evenement)
{
	console.log(evenement)
	var obj = {};
	obj.idEvent = $('#idEvent_modif').val();
	obj.debrief = $('#debrief_modif').val();
	
	rgBdd('172.16.15.42', obj, 'ADMIN/modifierDebrief', function(a,b,c)
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


//<div class="project-list">
//	<table class="table table-hover">
//		<tbody>
//			<tr>
//				<td class="project-status">
//					<span class="label label-primary">
//						Active
//					</span>
//				</td>
//				<td class="project-title">
//					<a>
//						Robot Cat
//					</a>
//					<br/>
//					<small>
//						Created 14.08.2014
//					</small>
//				</td>
//				<td class="project-people">
//					<a>
//						<img alt="image" class="img-circle" src="img/a7.jpg">
//					</a>
//				</td>
//				<td class="project-actions">
//					<a class="btn btn-white btn-sm">
//						<i class="fa fa-folder"></i> 
//						View 
//					</a>
//					<a class="btn btn-white btn-sm">
//						<i class="fa fa-pencil"></i> 
//						Edit 
//					</a>
//				</td>
//			</tr>
//		</tbody>
//	</table>
//</div>