$(function(){
	$('div[data-role="page"]').each(function(){
		$(this).prepend('<div data-role="header"><h1>' + $(this).attr('title') + '</h1><a href="#home" data-transition="slide" data-icon="home" data-direction="reverse">Início</a></div>');
	    $(this).append("<div data-role='footer'><img src='images/icon.png'/><a href='tel:082 8116-2800' data-role='button' data-icon='info' class='ui-btn-right'>Contato</a></div>");
	});
	
	mapa();
});



function onSuccess(pos){
	calcRota(pos.coords.latitude, pos.coords.longitude);
}

function onError(pos){
	alert('Sua localização falhou. Mostrando rota partindo de Maceió.');
	calcRota(casa_do_pipoca);
}

function calcRota(latitude, longitude){
	var position = new google.maps.LatLng(latitude, longitude);
    var directionsService = new google.maps.DirectionsService();
    var directionsDisplay = new google.maps.DirectionsRenderer();
    directionsDisplay.setMap(map);
	var request = {
    	origin: position,
    	destination: casa_do_pipoca,
    	travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
    	if (status == google.maps.DirectionsStatus.OK) {
    		directionsDisplay.setDirections(response);
    	}
    });
}
    
var map;
var casa_do_pipoca;
function mapa(){
	casa_do_pipoca = new google.maps.LatLng(-9.416901,-35.508964);
    var mapOptions = {
      center: casa_do_pipoca,
      zoom: 18,
      mapTypeId: google.maps.MapTypeId.SATELLITE
    };
    map = new google.maps.Map(
    	document.getElementById("map_canvas"),
        mapOptions
    );


	navigator.geolocation.getCurrentPosition(onSuccess, onError, { enableHighAccuracy: true });
}