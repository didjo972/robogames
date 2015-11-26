//lance AJAX
rgBdd('172.16.15.42',{} ,'ADMIN/getAllUtilisateur', function(a,b,c)
{
	console.log('a =',a);
	console.log('b =',b);
	console.log('c =',c);
	parseRetour(a);
});

createDatatable();

function rgBdd (url, mdata, requete, callback)
{
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
		for(var i = 0; i<lg; i++){
				goDatatable(list[i]);
		}
	}
	else
	{
		console.log("erreur pour l'objet : ",retour);
	}
};

function goDatatable(obj){
	 $('#tableUser').DataTable().row.add( [
			obj.idUser,
            obj.nom,
            obj.prenom,
            obj.pseudo,
			obj.dateInscription,
			'<a id="edit" class="btn btn-white btn-pencil"><i class="fa fa-pencil"></i></a> <a id="ban" class="btn btn-white btn-ban"><i class="fa fa-ban"></i></a>'
        ] ).draw( false );
		$('#edit').on('click', function(idUser)
		{
			edit(obj);
		});	
		$('#ban').on('click', function(idUser)
		{
			if(obj.etatHabilitation == 1)
			{
				Ban(obj);
			}
			else
			{
				Deban(obj);
			}
		});	
		$('#supp').on('click', function(idUser)
		{
			$('#temp').attr('id',obj.idEvent);
			thisEvent = obj; 
			toModal(obj);
		});	
		$('#edit').removeAttr('id');
		$('#ban').removeAttr('id');
		$('#supp').removeAttr('id');
};

function edit(utilisateur)
{
	console.log(utilisateur);
	$('#id_info').val(utilisateur.idUser);
	$('#nom_info').val(utilisateur.nom);
	$('#prenom_info').val(utilisateur.prenom);
	$('#pseudo_info').val(utilisateur.pseudo);
	$('#role_info').val(utilisateur.libelleHabilitation);
	$('#modal_edit').modal();
	
	$('#save').on('click', function ()
	{
		console.log('click =');
		modifier_edit(utilisateur);
	});
}

function modifier_edit(utilisateur)
{
	console.log(utilisateur);
	var obj = {};
	obj.idUser = $('#id_info').val();
	obj.nom = $('#nom_info').val();
	obj.prenom = $('#prenom_info').val();
	obj.pseudo = $('#pseudo_info').val();
	obj.libelleHabilitation = $('#role_info').val();
	
	setUser(obj);
	refresh();
}

function Ban(utilisateur)
{
	console.log(utilisateur);
	$('#id_infoBan').val(utilisateur.idUser);
	$('#name_infoBan').val(utilisateur.nom+' '+utilisateur.prenom);
	$('#modal_ban').modal();
	
	$('#save_ban').on('click', function ()
	{
		console.log('click =');
		modifier_Ban(utilisateur);
	});
	refresh();
}

function modifier_Ban(utilisateur)
{
	console.log(utilisateur);
	var obj = {};
	obj.idUser = $('#id_infoBan').val();
	obj.infos = $('#infoBan').val();
	obj.nbJourBan = $('#jour_infoBan').val();
	
	setBan(obj);
}

function Deban(utilisateur)
{
	console.log(utilisateur);
	$('#idUser_deban').val(utilisateur.idUser);
	$('#name_deban').val(utilisateur.nom+' '+utilisateur.prenom);
	$('#infoBan').val(utilisateur.infosHabilitation);
	$('#modal_deban').modal();
	
	$('#save_deban').on('click', function ()
	{
		console.log('click =');
		modifier_deBan(utilisateur);
	});
	refresh();
}

function modifier_deBan(utilisateur)
{
	console.log(utilisateur);
	var obj = {};
	obj.idUser = $('#idUser_deban').val();
	
	setDeBan(obj);
}

function setUser(obj)
{
	rgBdd('172.16.15.42', obj, 'ADMIN/modifierUser', function(a,b,c)
	{
		console.log(a);
	});
}

function setBan(obj)
{
	rgBdd('172.16.15.42', obj, 'ADMIN/bannirUser', function(a,b,c)
	{
		console.log(a);
	});
}

function setDeBan(obj)
{
	rgBdd('172.16.15.42', obj, 'ADMIN/debannirUser', function(a,b,c)
	{
		console.log(a);
	});
}

function createDatatable()
{
	$('#content_ibox').append($('<table id="tableUser" class="display" cellspacing="0" width="100%"></table>'));
	$('#tableUser').DataTable( 
	{
		"paging": false,
		"info": false,
		"bFilter": false,
		columns: 
		[
			{ title: "Id" },
			{ title: "Nom" },
			{ title: "Prénom" },
			{ title: "Pseudo" },
			{ title: "date d'inscription" },
			{ title: "options" }
		]
	});
}

function refresh()
{
	$('#tableUser').remove();
	createDatatable();
	rgBdd('172.16.15.42',{} ,'ADMIN/getAllUtilisateur', function(a,b,c)
	{
		parseRetour(a);
	});
}