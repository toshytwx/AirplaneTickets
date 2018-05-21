function mapLocation() {
    var directionsDisplay;
    var directionsService = new google.maps.DirectionsService();
    var map;

    function initialize() {
        directionsDisplay = new google.maps.DirectionsRenderer();
        var latStart = Number(document.getElementById('latStart').value);
        var lngStart = Number(document.getElementById('lngStart').value);
        var chicago = new google.maps.LatLng(latStart, lngStart);
        var mapOptions = {
            zoom: 7,
            center: chicago
        };
        map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
        directionsDisplay.setMap(map);
        google.maps.event.addDomListener(document.getElementById('calcRouteBtn'), 'click', calcRoute);
    }

    function calcRoute() {
        var latStart = Number(document.getElementById('latStart').value);
        var lngStart = Number(document.getElementById('lngStart').value);
        var start = new google.maps.LatLng(latStart, lngStart);
        var latEnd = Number(document.getElementById('latEnd').value);
        var lngEnd = Number(document.getElementById('lngEnd').value);
        var end = new google.maps.LatLng(latEnd, lngEnd);
        var request = {
            origin: start,
            destination: end,
            travelMode: google.maps.TravelMode.DRIVING
        };
        directionsService.route(request, function(response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
                directionsDisplay.setMap(map);
            } else {
                alert("Directions Request from " + start.toUrlValue(6) + " to " + end.toUrlValue(6) + " failed: " + status);
            }
        });
    }

    google.maps.event.addDomListener(window, 'load', initialize);
}
mapLocation();