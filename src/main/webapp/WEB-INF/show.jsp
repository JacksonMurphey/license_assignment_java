<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>User Details</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<h1 class="m-4">${person.firstName} ${person.lastName}</h1>

<p class="m-4">License Number: ${person.license.returnLicenseNumbers()} </p>
<p class="m-4">Expiration Date: ${person.license.expiration_date} </p>
<p class="m-4">State: ${person.license.state} </p>
<%-- <a href="/books/edit/${book.id}" class="m-4">Edit Book</a>
<form action="/books/${book.id}" method="post" class="m-4">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form> --%>
<a class="m-4 btn btn-primary" href="/">Home</a>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>