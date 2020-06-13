<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%!

String name;


%>


<%
	name = (String) request.getAttribute("username");
%>

Username is <%= name %> <br>

Today is <%= (LocalDate)request.getAttribute("date") %>


Email ID  is <%= (String)session.getAttribute("session_email") %>




</body>
</html>