<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<%--    <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <c:url value="/images/403.jpg" var="img"/>
    <title>403</title>
</head>
<h1>HTTP Status 403 - Access is denied</h1>

<div style="width: 800px; height: 800px">
    <body style="background-image: url('${img}'); background-repeat: no-repeat; background-size: cover">


    <div style="margin: auto;">
    </div>
</div>
</body>
</html>