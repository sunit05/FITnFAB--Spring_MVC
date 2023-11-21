<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>FIT & FAB</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
	<header> </header>
	<nav>
		<ul>

			<li><a href="home.jsp"><img class="gym-logo"
					src="logogym.png" alt=""></a></li>
		</ul>


	</nav>
	<h1 class="h">
		<a href="goToAdminLogin"> Admin Login</a><br> <a
			href="goToBMLogin"> Branch Manager Login</a>
	</h1>

	<h1 class="a">WELCOME TO FIT & FAB</h1>

	<section class="login-container">

		<h1>${saved}</h1>
		<h1>${loginstatus}</h1>

		<br> <a href="goToCustomerLogin"> Customer Login</a><br> <br>

		<a href="createcust" class="letsgetstarted" src="lets_get_started.jpg"
			alt=""></a>
	</section>
	<footer>
		<p>&copy; 2023 Fit & Fab</p>
		<p class="created">CREATED BY SUNIT & DHRUVA</p>
	</footer>
</body>
</html>