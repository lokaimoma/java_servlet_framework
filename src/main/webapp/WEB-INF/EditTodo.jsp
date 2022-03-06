<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.koc.webapp.entities.Todo" %>
<%
	Todo todo = (Todo) request.getAttribute("todo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Todo</title>
<jsp:include page="BootstrapInit.jsp"></jsp:include>
</head>
<body>
<jsp:include page="Nav.jsp"></jsp:include>
<% if (todo != null) { %>
<div class="container-fluid mt-4">
<form action="update" method="post">
		<input type="hidden" name="id" value="<%= todo.getId() %>" />
		<div class="field-wrapper mb-3">
			<input class="form-control" type="text" name="title" value="<%= todo.getTitle() %>" id="title" required/>
		</div>
		<div class="field-wrapper mb-3">
			<textarea class="form-control" name="description" required><%= todo.getDescription() %></textarea>
		</div>
		<div class="field-wrapper mb-3">
			<input class="form-control" type="date" name="date-time" value="<%= todo.getDateTime() %>" required/>
		</div>
		<input class="btn btn-primary" type="submit" value="Submit">
	</form>
<% } %>
</div>
</body>
</html>