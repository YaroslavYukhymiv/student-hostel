<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<%--    <meta charset="UTF-8">--%>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <title>List of students</title>
</head>

<body>

<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">First name</th>
        <th scope="col">Last name</th>
        <th scope="col">Room Number</th>
        <th scope="col">Faculty</th>
        <sec:authorize access="hasRole('ADMIN')">
        <th scope="col">Birthday</th>
        </sec:authorize>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="hoss" items="${list}" >
            <tr>
                <td>${hoss.id}</td>
                <td>${hoss.firstName}</td>
                <td>${hoss.secondName}</td>
                <td>${hoss.roomNumber}</td>
                <td>${hoss.faculty}</td>
                <sec:authorize access="hasRole('ADMIN')">
                <td>${hoss.birthday}</td>
                </sec:authorize>
                <td><a href="edit?id=${hoss.id}">Edit</a></td>
                <td><a href="delete/${hoss.id}">Delete</a></td>
            </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/form" class="btn btn-dark btn-lg active" style="margin-left: 89%" role="button" aria-pressed="true">Add new student</a>

<form:form method="post" action="/search_all" modelAttribute="studentAll">
    <tr>
        <td><form:input path="firstName"/></td>
        <td><form:input path="secondName"/></td>
        <td><form:input path="roomNumber"/></td>
        <td><form:input path="faculty"/></td>
        <td><form:input path=""/></td>
        <td><button type="submit">Find</button></td>

    </tr>
</form:form>
<a href="/logout">
    <button class="btn btn-lg btn-primary btn-block mt-3 bg-light text-dark" style="margin-left: 50%; width: 185px" type="submit">Log out</button>
</a>

<a href="/"></a>

<div>
    <form:form method="post" action="/search" modelAttribute="command">
        <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" style="margin-left: 89%; width: 185px" placeholder="First name" required="" path="firstName"/>
        <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" style="margin-left: 89%; width: 185px" placeholder="Faculty" required="" path="faculty"/>

        <button class="btn btn-lg btn-primary btn-block mt-3 bg-light text-dark" style="margin-left: 89%; width: 185px" type="submit">Find</button>
    </form:form>
</div>

<sec:authorize access="hasRole('ADMIN')">
<div>
    <form:form method="post" action="/search_birthday" modelAttribute="studentsBirthday">
        <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" style="margin-left: 89%; width: 185px" placeholder="Birthday from" required="" path="birthdayOne"/>
        <form:input type="text" id="inputPassword" class="form-control mt-3 text-white bg-dark" style="margin-left: 89%; width: 185px" placeholder="Birthday to" required="" path="birthdayTwo"/>

        <button class="btn btn-lg btn-primary btn-block mt-3 bg-light text-dark" style="margin-left: 89%; width: 185px" type="submit">Find by birthday</button>
    </form:form>
</div>
</sec:authorize>

</body>
</html>
