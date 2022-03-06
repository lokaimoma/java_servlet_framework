<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<jsp:include page="BootstrapInit.jsp"></jsp:include>
</head>
<body>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="container-fluid mt-4">
<div class="alert alert-danger" role="alert">
  <h1>An error occured</h1>
<p><%= request.getAttribute("error") %></p>
</div>
</div>
</body>
</html>