<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Produit" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<% List<Produit>liste=(List<Produit>)request.getAttribute("products"); %>
<div class="container">
<div class="card">
	<div class="card-header">
	<h2 class="text-danger">Liste des Produits</h2>
	</div>
	<div class="card-body">
		<form action="controlleur" method="get" class="d-flex mb-3">
			<input type="text" name="motCle" class="form-control me-2" placeholder="Rechercher un produit">
			<button type="submit" class="btn btn-primary">Rechercher</button>
		</form>
		<table class="table">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prix</th>
			<th>Qantite</th>
		</tr>
		<%for(Produit p:liste){ %>
		<tr>
		<td><%=p.getId() %></td>
		<td><%=p.getNom() %></td>
		<td><%=p.getPrix() %></td>
		<td><%=p.getQuantite() %></td>
		</tr>
		<%} %>
		</table>
	</div>
</div>
</div>
</body>
</html>