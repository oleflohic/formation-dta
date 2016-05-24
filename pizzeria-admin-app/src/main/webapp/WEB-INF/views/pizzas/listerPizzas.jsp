<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
		
		<table>
			<tr>
				<td>ID</td>
				<td>CODE</td>
				<td>NOM</td>
				<td>IMAGE</td>
				<td>PRIX</td>
				<td></td>
				<td></td>
			</tr>
		
		<%
		List<Pizza> listePizzas = (List<Pizza>) request.getAttribute("listePizzas");
		
		for (Pizza p : listePizzas) {
		
		%>
		
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getCode() %></td>
				<td><%= p.getLibelle() %></td>
				<td><%= p.getNom() %></td>
				<td><%= p.getUrlImage() %></td>
				<td><%= p.getPrix() %></td>
				<td></td>
			</tr>
		
		
		<%
		}
		%>
		
		</table>
		
	</body>
</html>