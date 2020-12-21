<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

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
        <th scope="col">Birthday</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="hoss" items="${list}">
        <tr>
            <td>${hoss.id}</td>
            <td>${hoss.firstName}</td>
            <td>${hoss.secondName}</td>
            <td>${hoss.roomNumber}</td>
            <td>${hoss.faculty}</td>
            <td>${hoss.birthday}</td>
            <td><a href="edit?id=${hoss.id}">Edit</a></td>
            <td><a href="delete/${hoss.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/form" class="btn btn-dark btn-lg active" style="margin-left: 89%" role="button" aria-pressed="true">Add new
    student</a>
</body>
</html>
