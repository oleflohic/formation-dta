<%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Pizza" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<base href="/pizzeria-admin-app/" />
    	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="favicon.ico">
	
	    <title>Pizzeria</title>
	
	    <!-- Bootstrap core CSS -->
		<link href="<%= request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		
	</head>
	<body>
		
		<table class="table">
			<thead>
				<tr class="text-center">
					<td class="span1">ID</td>
					<td>CODE</td>
					<td>NOM</td>
					<td>CAT&Eacute;GORIE</td>
					<td>IMAGE</td>
					<td>PRIX</td>
					<td class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></td>
					<td class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></td>
				</tr>
			</thead>
		
			<tbody>
		
			<c:forEach var="pizza" items="${listePizzas}">
				
				<tr>
					<td class="text-center">${pizza.id}</td>
					<td class="text-center">${pizza.code}</td>
					<td>${pizza.nom}</td>
					<td class="text-center">${pizza.categorie.getLibelle()}</td>
					<td class="text-center"><img class="img-circle" src="${pizza.urlImage}" /></td>
					<td class="text-center">${pizza.prix} &euro;</td>
					<td><a class="btn btn-info" href="pizzas/edit?code=${pizza.code}">&Eacute;diter</a></td>
					<td><a class="btn btn-danger" href="pizzas/delete?code=${pizza.code}">Supprimer</a></td>
				</tr>
				
			</c:forEach>
			
			</tbody>
			
		</table>
		
	</body>
</html>