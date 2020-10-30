<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

    <title>List of students</title>
</head>

<body class="bg-dark">
<div class="container-fluid" >


    <div class="row text-white bg-dark text-center">
         <span class="border"><div class="col-sm border-1 border-white" style="width: 230px">Id</div></span>
         <span class="border"> <div class="col text-center" style="width: 230px">First name</div></span>
         <span class="border"><div class="col col-sm" style="width: 230px">Second name</div></span>
         <span class="border"><div class="col-sm" style="width: 230px">Room number</div></span>
         <span class="border"><div class="col-sm" style="width: 230px">Faculty</div></span>
         <span class="border"><div class="col-sm" style="width: 230px">Birthday</div></span>
         <span class="border"><div class="col-sm" style="width: 230px">Edit</div></span>
         <span class="border"><div class="col-sm" style="width: 225px">Delete</div></span>
    </div>

<%--    <div class="row mb-3">--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--        <div class="col-4 themed-grid-col">.col-4</div>--%>
<%--    </div>--%>


    <c:forEach var="hos" items="${list}">
    <div class="row text-white bg-dark border-1 border-white text-center">
        <div class="col-sm text-center" style="border: whitesmoke solid 1px">${hos.id}</div>
        <div class="col-sm " style="border: aliceblue solid 0.1px">${hos.firstName}</div>
        <div class="col-sm text-center" style="border: aliceblue solid 0.1px">${hos.secondName}</div>
        <div class="col-sm" style="border: aliceblue solid 1px">${hos.roomNumber}</div>
        <div class="col" style="border: aliceblue solid 1px">${hos.faculty}</div>
        <div class="col" style="border: aliceblue solid 1px">${hos.birthday}</div>
        <div class="col-sm" style="border: aliceblue solid 1px"><a href="edit/${hos.id}">Edit</a></div>
        <div class="col-sm" style="border: aliceblue solid 1px"><a href="delete/${hos.id}">Delete</a></div>
    </div>
    </c:forEach>
</div>


</div>

</body>
</html>

<%--__________________________________________________________________________________________________---%>


<%--<h1>Table of students</h1>--%>
<%--<table border="2" width="70%" cellpadding="2">--%>
<%--    <tr>--%>
<%--        <th>Id</th>--%>
<%--        <th>First name</th>--%>
<%--        <th>Second name</th>--%>
<%--        <th>Room number</th>--%>
<%--        <th>Faculty</th>--%>
<%--        <th>Birthday</th>--%>
<%--    </tr>--%>
<%--    <c:forEach var="hos" items="${list}">--%>
<%--        <tr>--%>
<%--            <td>${hos.id}</td>--%>
<%--            <td>${hos.firstName}</td>--%>
<%--            <td>${hos.secondName}</td>--%>
<%--            <td>${hos.roomNumber}</td>--%>
<%--            <td>${hos.faculty}</td>--%>
<%--            <td>${hos.birthday}</td>--%>
<%--            <td><a href="edit/${hos.id}">Edit</a></td>--%>
<%--            <td><a href="delete/${hos.id}">Delete</a></td>--%>

<%--        </tr>--%>

<%--    </c:forEach>--%>
<%--    <br/>--%>

<%--</table>--%>

