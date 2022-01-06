<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
                crossorigin="anonymous">
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<jsp:include page="base.jsp"></jsp:include>

<h1 class="m-4">Create a New License</h1>
<form:form action="/license/new" method="POST" modelAttribute="license" class="m-4">
    <p>
        <form:label path="person">Select Who the License is For:</form:label>
        <form:errors path="person"/>
        <form:select path="person">
        <c:forEach items="${people}" var="person"> 
        <option value="${person.id}">${person.firstName} ${person.lastName}</option>
        </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="expiration_date">Expiration Date:</form:label>
        <form:errors path="expiration_date"/>
        <form:input type="date" path="expiration_date"/>
    </p>
    <p>
        <form:label path="state">State:</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <input type="submit" value="Add License"/>
</form:form>   


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</body>
</html>