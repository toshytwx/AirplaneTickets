<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Ticket info</title>
    <link href="../../resources/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/css/ticket.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="panel panel-primary" id="panel">
        <p><h2>Ticket info:</h2></p>
        <p><h4>${surname} ${name}</h4></p>
        <p><h4>Flight signature: ${signature}</h4></p>
        <p><h4>Seat: ${seat} | Class: ${ticketClass} | Price: ${ticketPrice}</h4></p>
        <p><h4>Departure airport: ${departureAirportName} | Arrival airport: ${arrivalAirportName}</h4></p>
        <p><div id="map-canvas"></div></p>
        <input type="text" id="latStart" value="${latStart}" hidden/>
        <input type="text" id="lngStart" value="${lngStart}" hidden/>
        <input type="text" id="latEnd" value="${latEnd}" hidden/>
        <input type="text" id="lngEnd" value="${lngEnd}" hidden/>
        <p><input type="button" id="calcRouteBtn" class="routebtn" value="Show route"/></p>
        <p><h2>Luggage info:</h2></p>
        <p><h4>Weight: ${luggageWeight} | HandOn: ${handLuggage}</h4></p>
        <p><h2>Company and plane info:</h2></p>
        <p><h4>You will be serviced by the company: ${companyName}</h4></p>
        <p><h4>Plane: Boeing-${bortNumber} and capacity ${planeCapacity}</h4></p>
        <p><h4>Departure will be made from terminal: ${terminalSignature}</h4></p>
        <p>
            <a class="routebtn" href="${contextPath}/" role="button">Home</a>
        </p>
    </div>
</div>

<script src="../../resources/jquery/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.bundle.min.js"></script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIDQbJF1uK_Ec99TSNBDM_wuuEkMapyRQ&callback=mapLocation">
</script>
<script src="../../resources/js/map.js"></script>
</body>
</html>
