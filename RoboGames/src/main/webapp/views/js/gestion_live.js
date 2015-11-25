//lance AJAX
rgBdd('172.16.15.42', '', 'ADMIN/recupererUrlLive', function(a,b,c)
{
	console.log('a =',a.object.url);
	console.log('b =',b);
	console.log('c =',c);
	$('#input_live').attr('placeholder',a.object.url);
});

$('#btn_live').on('click', function ()
{
	var url = $('#input_live').val();
	setUrl(url);
});

function rgBdd (url, mdata, requete, callback)
{
	var data = {};
	data.idAdmin = '107';
	if(mdata !== ''){
		data.url = mdata;
	}
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
	console.log('url =',xurl);
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
		data: data,
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

function setUrl(url)
{
	rgBdd('172.16.15.42', url, 'ADMIN/updateUrlLive', function(a,b,c)
	{
		console.log(a);
	});
}