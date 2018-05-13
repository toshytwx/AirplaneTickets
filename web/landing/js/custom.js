var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: {lat: 50.865427, lng: 14.196123},
        mapTypeId: 'terrain'
    });
}

$('.form .stages label').click(function() {
    var radioButtons = $('.form input:radio');
    var selectedIndex = radioButtons.index(radioButtons.filter(':checked'));
    selectedIndex = selectedIndex + 1;
});

$('.form button').click(function() {
    var radioButtons = $('.form input:radio');
    var selectedIndex = radioButtons.index(radioButtons.filter(':checked'));

    selectedIndex = selectedIndex + 2;

    $('.form input[type="radio"]:nth-of-type(' + selectedIndex + ')').prop('checked', true);

    if (selectedIndex == 4) {
        $('button').html('Submit');
    }
});