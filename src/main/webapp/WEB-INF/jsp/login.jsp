<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<%--    <meta name="_csrf" content="${_csrf.token}"/>--%>
<%--    <meta name="_csrf_header" content="${_csrf.headerName}"/>--%>

</head>

<body>

<div class="container mt-5" >
    <div class="row align-items-center mt-5">
        <div class="col" style="margin-left: 33%; margin-top: 10%">
    <h1>Login</h1>

    <form name='f' action="/login" method='POST'>  <!-- name question -->

        <table>
            <tr>
                <td>User:</td>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <td><input type='text' name='username' value='' class="form-control text-white bg-dark"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' class="form-control text-white bg-dark" /></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="submit" class="form-control text-white bg-dark" /></td>
            </tr>
        </table>

    </form>

    <a href="/registration">Registration</a>
        </div>
    </div>
</div>

</body>
</html>