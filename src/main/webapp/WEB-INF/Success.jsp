<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	String message = (String) request.getAttribute("message");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
<jsp:include page="BootstrapInit.jsp"></jsp:include>
</head>
<body>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="container-fluid mt-4">
<% if (message != null && message != "null") { %>
		<div class="alert alert-success" role="alert">
			<p><%= message %></p>
		</div>
<% } %>
<p>Redirecting in 3 seconds</p>
<script>
setTimeout(_ => window.location.replace("/todo_web_app"), 3000)
</script>
</div>
</body>
</html>