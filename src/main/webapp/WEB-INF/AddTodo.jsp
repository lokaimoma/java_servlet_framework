<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% 
	String message = String.valueOf(request.getAttribute("message"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Add todo</title>
<jsp:include page="BootstrapInit.jsp"></jsp:include>
</head>
<body>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="container-fluid mt-4">
	<% if (message != null && message != "null") { %>
		<div class="alert alert-success" role="alert">
  			<%= message %>
		</div>
<% } %>
	<form action="" method="post">
		<div class="field-wrapper mb-3">
			<input class="form-control" type="text" name="title" placeholder="Todo title" id="title" required/>
		</div>
		<div class="field-wrapper mb-3">
			<textarea class="form-control" name="description" placeholder="Todo description" required></textarea>
		</div>
		<div class="field-wrapper mb-3">
			<input class="form-control" type="date" name="date-time" required/>
		</div>
		<input class="btn btn-primary" type="submit" value="Submit">
	</form>
</div>
</body>
</html>
