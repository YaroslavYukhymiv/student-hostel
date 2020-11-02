<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <c:url value="/images/bg_image.jpg" var="img"/>
    <title>Form</title>
</head>

<body style="background-image: url('${img}');">
<div class="container mt-5">
    <div class="row align-items-center mt-5">
        <div class="col"></div>
        <div class="col-5 mt-5">

            <form:form method="POST" action="/editsave">
                <form class="form-signin">

                    <h1 class="h3 mb-3 font-weight-normal text-center">Edit student</h1>
                    <form:hidden  path="id"/>    <!--question-->
                    <form:input type="text" id="inputEmail" class="form-control text-white bg-dark" placeholder="FirstName" required="" autofocus="" path="firstName"/>
                    <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" placeholder="Second name" required="" path="secondName"/>
                    <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" placeholder="RoomNumber" required="" path="roomNumber"/>
                    <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" placeholder="Faculty" required="" path="faculty"/>
                    <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" placeholder="Birthday" required="" path="birthday"/>

                    <button class="btn btn-lg btn-primary btn-block mt-3 bg-light text-dark" type="submit">Edit</button>

                </form>
            </form:form>
        </div>

        <div class="col"></div>
    </div>
</div>

</body>
</html>
