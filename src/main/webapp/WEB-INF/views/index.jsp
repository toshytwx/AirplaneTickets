<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Airplane Tickets</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../../resources/css/style.css" rel="stylesheet">
    <link href="../../resources/css/half-slider.css" rel="stylesheet">

</head>

<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Airplane Tickets</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li role="presentation" class="list-group-item" data-toggle="modal" data-target="#myModal"><a href="#">Find ticket</a></li>
            </ul>
        </div>
    </div>
</nav>

<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item active" style="background-image: url('../../resources/images/slider-1.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Travel with our company, get maximum of comfort.</h3>
                </div>
            </div>
            <div class="carousel-item" style="background-image: url('../../resources/images/slider-2.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>We work with the biggest air companies of the world.</h3>
                </div>
            </div>
            <div class="carousel-item" style="background-image: url('../../resources/images/slider-3.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Rich safety and comfort flight for miser money.</h3>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</header>


<form id="regForm" action="${contextPath}/buyticket" method="post">
    <div class="tab">
        <h1>Customer info:</h1>
        <p><label for="customerFirstName">Name</label></p>
        <p><input name="customerFirstName" type="text" class="form-control" id="customerFirstName"></p>
        <p><label for="customerSecondName">Surname</label></p>
        <p><input name="customerSecondName" type="text" class="form-control" id="customerSecondName"></p>
        <p><label for="customerPhoneNumber">Phone number</label></p>
        <p><input name="customerPhoneNumber" type="text" class="form-control" id="customerPhoneNumber"></p>
        <p><label for="customerPassportCode">Passport code</label></p>
        <p><input name="customerPassportCode" type="text" class="form-control" id="customerPassportCode"></p>
        <p><label for="birthDay">Birthday</label></p>
        <p><input name="birthDay" type="date" class="form-control" id="birthDay"></p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>

    <div class="tab">
        <p><h1>Luggage info:</h1></p>
        <p><label for="luggageWeight">Weight</label></p>
        <p><input name="luggageWeight" type="number" class="form-control" id="luggageWeight"></p>
        <p><label for="luggageType">Is it hand-luggage?</label></p>
        <p><select name="luggageType" class="form-control" id="luggageType">
            <option>Yes</option>
            <option>No</option>
        </select></p>
    </div>

    <div class="tab">
        <p><h1>Flight info:</h1></p>
        <p><label for="departureAirport">Departure airport</label></p>
        <p><select name="departureAirport" class="form-control" id="departureAirport">
                <c:forEach var="departureAirport" items="${departureAirportsList}">
                    <option>${departureAirport}</option>
                </c:forEach>
            </select></p>
        <p><label for="arrivalAirport">Arrival airport</label></p>
        <p><select name="arrivalAirport" class="form-control" id="arrivalAirport">
                <c:forEach var="arrivalAirport" items="${arrivalAirportsList}">
                    <option>${arrivalAirport}</option>
                </c:forEach>
            </select></p>
        <p><label for="flightDate">Date</label></p>
        <p><input name="flightDate" type="date" class="form-control" id="flightDate"></p>
        <p><label for="ticketType">Type</label></p>
        <p><select name="ticketType" class="form-control" id="ticketType">
                <option>Business</option>
                <option>First</option>
                <option>Second</option>
                <option>Econom</option>
            </select></p>
    </div>

    <div style="overflow:auto;">
        <div style="float:right;">
            <button class="formbutton" type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
            <button class="formbutton" type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
        </div>
    </div>

    <!-- Circles which indicates the steps of the form: -->
    <div style="text-align:center;margin-top:40px;">
        <span class="step"></span>
        <span class="step"></span>
        <span class="step"></span>
    </div>

</form>
<div id="map"></div>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-m">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <form method="get" action="${contextPath}/findTicket" class="form-signin">
                    <p><h3>Enter your phone number:</h3></p>
                    <p><input type="text" id="phoneNumber" value="+380" name="phoneNumber"/></p>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; KrivoAnton Company 2018</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../../resources/jquery/jquery.min.js"></script>
<script src="../../resources/js/bootstrap.bundle.min.js"></script>

<!-- Google maps JavaScript -->
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIDQbJF1uK_Ec99TSNBDM_wuuEkMapyRQ&callback=initMap">
</script>
<script src="../../resources/js/custom.js"></script>
</body>

</html>
