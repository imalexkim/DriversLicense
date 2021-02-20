<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New License</h1>

<form:form action="/license" method="post" modelAttribute="license">
    <p>
		<form:label path="person">Name</form:label>
		<form:errors path="person"></form:errors>
		<form:select path="person">
			<option value="" disabled selected>Select a name!</option>
			<c:forEach items="${ persons }" var="p">
				<form:option value="${p}">
					<c:out value="${p.firstName} ${p.lastName }"></c:out>
				</form:option>
    		</c:forEach>
		</form:select>
		
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="expirationDate" path="expirationDate"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>    

</body>
</html>