<!DOCTYPE html>
<html>
	<head>
		<base href="/pizzeria-admin-web/" />
		
		<title>Index</title>
	</head>
	<body>
		
		<h1>Page d'accueil temporaire</h1>
		
		<p>Status de connexion actuel : <%= request.getSession().getAttribute("connecte") %></p>
		<p><a href="login?deconnexion">Déconnexion</a></p>
		
		<ul>
			<li><a href="login">Login</a></li>
			<li><a href="pizzas/list">Liste pizzas</a></li>
		</ul>
		
	</body>
</html>
