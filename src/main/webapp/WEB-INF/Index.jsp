<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.koc.webapp.entities.Todo" %>
<%@page import="java.util.List" %>
<%
	List<Todo> todos = (List<Todo>)request.getAttribute("todos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos</title>
<jsp:include page="BootstrapInit.jsp"></jsp:include>
<style>
	.flex {
		display: flex;
		align-items: stretch;
		gap: 0.5rem;
		flex-wrap: wrap;
	}
</style>
</head>
<body>
<jsp:include page="Nav.jsp"></jsp:include>
<div class="container-fluid mt-4 flex">
<% for (Todo todo : todos) { %>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title"><%= todo.getTitle() %></h5>
    <h6 class="card-subtitle mb-2 text-muted"><%= todo.getDateTime() %></h6>
    <p class="card-text"><%= todo.getDescription() %></p>
    <a href="edit?id=<%= todo.getId()%>" class="btn btn-secondary">Edit</a>
    <a href="delete?id=<%= todo.getId()%>" class="btn btn-danger">Delete</a>
  </div>
</div>
<% } %>
</div>
</body>
</html>