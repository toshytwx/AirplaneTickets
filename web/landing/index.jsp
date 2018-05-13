<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Half Slider - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/demo_style.css" rel="stylesheet">
    <link href="css/half-slider.css" rel="stylesheet">

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
                <li class="nav-item">
                    <a href="#2b" class="list-group-item" data-toggle="tab">Find ticket</a>
                </li>
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
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('./img/slider-1.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>First Slide</h3>
                    <p>This is a description for the first slide.</p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('./img/slider-2.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Second Slide</h3>
                    <p>This is a description for the second slide.</p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('./img/slider-3.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Third Slide</h3>
                    <p>This is a description for the third slide.</p>
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

<div class="form">
    <input id="one" type="radio" name="stage" checked="checked" />
    <input id="two" type="radio" name="stage" />
    <input id="three" type="radio" name="stage" />
    <input id="four" type="radio" name="stage" />
    <input id="five" type="radio" name="stage" />
    <input id="six" type="radio" name="stage" />

    <div class="stages">
        <label for="one">1</label>
        <label for="two">2</label>
        <label for="three">3</label>
        <label for="four">4</label>
    </div>
    <div class="panels">
        <div data-panel="one">
            <h4>Customer info</h4>
            <form action="${contextPath}/buy_ticket_customer?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="POST">
                <label for="customerFirstName">Name</label>
                <input name="customerFirstName" type="text" class="form-control" id="customerFirstName">
                <label for="customerSecondName">Surname</label>
                <input name="customerSecondName" type="text" class="form-control" id="customerSecondName">
                <label for="customerPhoneNumber">Phone number</label>
                <input name="customerPhoneNumber" type="text" class="form-control" id="customerPhoneNumber">
                <label for="customerPassportCode">Passport code</label>
                <input name="customerPassportCode" type="text" class="form-control" id="customerPassportCode">
                <label for="birthDay">Birthday</label>
                <input name="birthDay" type="date" class="form-control" id="birthDay">
            </form>
        </div>
        <div data-panel="two">
            <h4>Luggage info</h4>
            <form action="${contextPath}/buy_ticket_luggage?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="POST">
                <label for="luggageWeight">Weight</label>
                <input name="luggageWeight" type="number" class="form-control" id="luggageWeight">
                <label for="luggageType">Is it hand-luggage?</label>
                <select name="luggageType" class="form-control" id="luggageType">
                    <option>Yes</option>
                    <option>No</option>
                </select>
            </form>
        </div>
        <div data-panel="three">
            <h4>Flight info</h4>
            <form action="${contextPath}/buy_ticket_flight?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="POST">
                <label for="departureAirport">Departure airport</label>
                <select name="luggageType" class="form-control" id="departureAirport">
                    <c:forEach var="departureAirport" items="${departureAirportsList}">
                        <option>${departureAirport.name}</option>
                    </c:forEach>
                </select>
                <label for="arrivalAirport">Arrival airport</label>
                <select name="luggageType" class="form-control" id="arrivalAirport">
                    <c:forEach var="arrivalAirport" items="${arrivalAirportsList}">
                        <option>${arrivalAirport.name}</option>
                    </c:forEach>
                </select>
                <label for="flightDate">Date</label>
                <input name="luggageWeight" type="date" class="form-control" id="flightDate">
                <label for="ticketType">Type</label>
                <select name="ticketType" class="form-control" id="ticketType">
                    <option>Business</option>
                    <option>First</option>
                    <option>Second</option>
                    <option>Econom</option>
                </select>
            </form>
        </div>
        <div data-panel="four">
            <h4>Stage 4</h4>
            <input type="text" placeholder="Email" />
        </div>
    </div>

    <button type="submit" class="btn btn-default">Next</button>
</div>

<div id="exTab" class="container pad">
    <div class="tab-content clearfix">
        <div class="tab-pane tab" id="2b">
            <div class="form-group">
                <label for="customerPhone">Enter your phone number here</label>
                <input name="customerPhone" type="tel" class="form-control" id="customerPhone">
                <button id="findTickets" type="submit" class="btn btn-default pad" data-toggle="modal">
                    Find my tickets
                </button>
                <table class="table table-hover table-bordered tableTickets pad">
                    <tr>
                        <th>#</th>
                        <th>Flight</th>
                        <th>Price</th>
                        <th>Luggage</th>
                    </tr>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr class="">
                            <td></td>
                            <td><c:out value="${ticket.flight}"/></td>
                            <td><c:out value="${ticket.price}"/></td>
                            <td><c:out value="${ticket.luggage}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<div id="map"></div>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; KrivoAnton Company 2018</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Google maps JavaScript -->
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCIDQbJF1uK_Ec99TSNBDM_wuuEkMapyRQ&callback=initMap">
</script>
<script src="./js/custom.js"></script>
</body>

</html>
