<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>
	<h1>Name: ${ student.name }</h1>
	<h1>ID is ${ student.id }</h1>
	<h1>DOB is ${ student.dob }</h1>
	<h1>Courses ${ student.courses }</h1>
	<h1>Gender is ${ student.gender }</h1>
	<h1>Type is ${ student.type }</h1>
	<h1>Address: ${ student.address.street } ${ student.address.city }</h1>
</body>
</html>