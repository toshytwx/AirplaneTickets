<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="css/rating.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/half-slider.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
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

<div id="exTab" class="container pad">
    <ul class="nav nav-pills">
        <li class="list-inline-item">
            <a href="#1b" class="list-group-item" data-toggle="tab">Buy ticket</a>
        </li>
        <li class="list-inline-item">
            <a href="#2b" class="list-group-item" data-toggle="tab">Find ticket</a>
        </li>
    </ul>

    <div class="tab-content clearfix">
        <div class="tab-pane active tab" id="1b">
            <form action="${contextPath}/buy_ticket?${_csrf.parameterName}=${_csrf.token}"
                  enctype="multipart/form-data" method="POST">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="customerFirstName">First name</label>
                        <input name="customerFirstName" type="text" class="form-control" id="customerFirstName">
                    </div>
                    <div class="form-group">
                        <label for="customerSecondName">Second name</label>
                        <input name="customerSecondName" type="text" class="form-control" id="customerSecondName">
                    </div>
                    <div class="form-group">
                        <label for="customerPhoneNumber">Phone number</label>
                        <input name="customerPhoneNumber" type="text" class="form-control"
                               id="customerPhoneNumber">
                    </div>
                    <div class="form-group">
                        <label for="customerPassportCode">Passport code</label>
                        <input name="customerPassportCode" type="text" class="form-control"
                               id="customerPassportCode">
                    </div>
                    <div class="form-group">
                        <label for="BirthDay">Birthday</label>
                        <input name="BirthDay" type="text" class="form-control" id="BirthDay">
                    </div>
                    <div class="form-group">
                        <label for="ticketType">Type</label>
                        <select name="ticketType" class="form-control" id="ticketType">
                            <option>Business class</option>
                            <option>First class</option>
                            <option>Second class</option>
                            <option>Econom class</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default">Buy ticket</button>
                </div>
            </form>
        </div>

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
                            <td>
                                <button id="${ticket.id}_del" type="button"
                                        class="btn btn-primary btn-lg outline action" data-toggle="modal"
                                        data-target="#deleteTicket${ticket.id}">Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
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
