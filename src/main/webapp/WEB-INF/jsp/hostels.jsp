<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <title>List of students</title>
</head>

<body>

<table class="table table-striped">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Rooms</th>
        <th scope="col">Reference</th>

    </tr>
    </thead>

    <tbody>
    <c:forEach var="hoss" items="${hostels}">
        <tr>
            <td>${hoss.id}</td>
            <td>${hoss.name}</td>
            <td>${hoss.rooms}</td>
            <td><a href="/students">Show students</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/new_hostel" class="btn btn-dark btn-lg active" style="margin-left: 89%" role="button" aria-pressed="true">Add new hostel</a>

</body>
</html>