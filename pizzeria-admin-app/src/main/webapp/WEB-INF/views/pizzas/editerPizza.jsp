<%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Pizza" %>
<%@ page import="fr.pizzeria.model.CategoriePizza" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

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
		
	    <title>&Eacute;diter une pizza</title>
		
	    <!-- Bootstrap core CSS -->
		<link href="<%= request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
		
	</head>
	<body>
		
		<form action="" method="post">
			
			<input name="ancien_code" type="hidden" value="${pizza.code}" />
			
			<table class="table">
				<tr>
					<td><label>Code</label></td>
					<td><input name="code" type="text" placeholder="Code" value="${pizza.code}" /></td>
				</tr>
				<tr>
					<td><label>Nom</label></td>
					<td><input name="nom" type="text" placeholder="" value="${pizza.nom}" /></td>
				</tr>
				<tr>
					<td><label>Cat&eacute;gorie</label></td>
					<td>
						<select name="categorie">
							
							<%
							/*
								for(CategoriePizza ctg : CategoriePizza.values()) {
									out.print("- " + ctg + "; " + ctg.name() + ";" + ctg.getLibelle());
								}
							*/
							%>
							
							
							<c:forEach var="categoriePizza" items="${CategoriePizza.values()}">
								<option value="${categoriePizza.name()}" <c:if test="${pizza.categorie == categoriePizza}" >selected</c:if>>
									${categoriePizza.getLibelle()}
								</option>
							</c:forEach>
							
						</select>
					</td>
				</tr>
				<tr>
					<td><label>Prix</label></td>
					<td><input name="prix" type="number" placeholder="Prix" value="${pizza.prix}" class="text-right" /> &euro;</td>
				</tr>
				<tr>
					<td><label>URL de l'image</label></td>
					<td><input name="url_image" type="url" placeholder="URL" value="${pizza.urlImage}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-success" value="Confirmer" /><a href="pizzas/list" class="btn btn-warning">Annuler</a></td>
				</tr>
			</table>
			
		</form>
		
	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script>window.jQuery || document.write('<script src="<%=request.getContextPath() %>/bootstrap/js/vendor/jquery.min.js"><\/script>')</script>
	    <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <!-- <script src="<%=request.getContextPath() %>/bootstrap/js/ie10-viewport-bug-workaround.js"></script> -->
	    
	</body>
</html>