<%@ page import="java.util.List" %>
<%@ page import="fr.pizzeria.model.Pizza" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
	<head>
		<base href="/pizzeria-admin-web/" />
    	
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
		
		Connect&eacute; ? <%= request.getSession().getAttribute("connecte") %><br />
		
		<form action="" method="post">
			
			<table class="table">
				<tr>
					<td>
						<label>Identifiant</label>
					</td>
					<td>
						<input type="text" name="identifiant" />
					</td>
				</tr>
				<tr>
					<td>
						<label>Mot de passe</label>
					</td>
					<td>
						<input type="password" name="mot_de_passe" /><br />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Valider" />
					</td>	
				</tr>
			</table>
			
		</form>
		
		
	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    <script>window.jQuery || document.write('<script src="<%=request.getContextPath() %>/bootstrap/js/vendor/jquery.min.js"><\/script>')</script>
	    <script src="<%= request.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <!-- <script src="<%= request.getContextPath() %>/bootstrap/js/ie10-viewport-bug-workaround.js"></script> -->
	    
	</body>
</html>