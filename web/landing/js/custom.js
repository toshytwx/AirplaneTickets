var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: {lat: 50.865427, lng: 14.196123},
        mapTypeId: 'terrain'
    });
}