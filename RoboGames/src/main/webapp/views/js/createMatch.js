$('#dateStart').datepicker({
  format: 'dd/mm/yyyy',
  startDate: '+3d'
});
$('#dateEnd').datepicker({
  format: 'dd/mm/yyyy',
  startDate: '+3d'
});
$('#nbPlace').mask('99999');
$('#prixPlace').mask('99999');
$('#codePostal').mask('99999');

$('div').on('keyup', function(){
  testForm();
})

$('#btn').on('click', function(){
  console.log(testForm())
  if(testForm()){
    var obj = {};
    obj.adresse = $('#adresse').val();
    obj.codePostal = $('#codePostal').val();
    obj.ville = $('#ville').val();
    obj.nbPlace = $('#nbPlace').val();
    obj.prix = $('#prixPlace').val();
    if($('#infos').val() !== ''){
      obj.infos = $('#infos').val();
    }
    obj.idUser = '' //todo
    obj.dateDebut = $('#dateStart').val();
    obj.dateFin = $('#dateEnd').val();
    obj.nomEvent = $('#eventName').val();
    console.log('todo id user');
    console.log('obj =',obj);
    rgBdd('172.16.15.42', obj, '/USER/creerEvenement');
  }else{
    swal("Erreur", "Au moins un champs est incorrect.", "error")
  }
})

function rgBdd (url, mdata, requete, callback){
	var xurl =  'http://'+url+':8080/robobogames/'+requete;
  mdata.idUser = '105';
	$.ajax({
		type : 'POST',
		url : xurl,
		dataType : 'json',
    data: mdata,
		success : function(output, status, xhr) {
			console.log(output, status, xhr);
		},
		error : function(err) {
			console.log("erreur =", err);
		}
	});
};

function testForm(){
  var bool = true;
  if($('#eventName').val() === ''){
    bool = false;
    $('#eventName').css('border-color','red');
  }else{
    $('#eventName').css('border-color','');
  }
  if($('#nbPlace').val() === ''){
    bool = false;
    $('#nbPlace').css('border-color','red');
  }else{
    $('#nbPlace').css('border-color','');
  }
  if($('#prixPlace').val() === ''){
    bool = false;
    $('#prixPlace').css('border-color','red');
  }else{
    $('#prixPlace').css('border-color','');
  }
  if($('#adresse').val() === ''){
    bool = false;
    $('#adresse').css('border-color','red');
  }else{
    $('#adresse').css('border-color','');
  }
  if($('#codePostal').val() === ''){
    bool = false;
    $('#codePostal').css('border-color','red');
  }else{
    $('#codePostal').css('border-color','');
  }
  if($('#ville').val() === ''){
    bool = false;
    $('#ville').css('border-color','red');
  }else{
    $('#ville').css('border-color','');
  }
  var start = $('#dateStart').datepicker("getDate");
  var end = $('#dateEnd').datepicker("getDate");
  if(end - start < 0){
    bool = false;
    $('#dateStart').css('border-color','red');
    $('#dateEnd').css('border-color','red');
  }else{
    $('#dateStart').css('border-color','');
    $('#dateEnd').css('border-color','');
  }
  if($('#dateStart').val() === ''){
    bool = false;
    $('#dateStart').css('border-color','red');
  }else{
    $('#dateStart').css('border-color','');
  }
  if($('#dateEnd').val() === ''){
    bool = false;
    $('#dateEnd').css('border-color','red');
  }else{
    $('#dateEnd').css('border-color','');
  }

  return bool;
}
