<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MusiFan - Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${auth}">
				<div class="alert alert-danger">informations incorrectes</div>
			</c:if>
			<c:if test="${isNull}">
				<div class="alert alert-danger">informations obligatoires</div>
			</c:if>
			<c:if test="${filter}">
				<div class="alert alert-danger">il faut d'abord etre
					authentifié</div>
			</c:if>
			<br> <br>
			<h2>Login Page</h2>
			<br>
			<form action="${ctx}/login" method="post">
				<div class="mb-3 mt-3">
					<label for="Id">Id :</label> <input value="${formateurNom}"
						type="text" class="form-control" id="id" placeholder="Enter id"
						name="id" /> <label for="Password">Mot de passe :</label> <input
						value="${formateurPrenom}" type="text" class="form-control"
						id="password" placeholder="Enter Mot de passe" name="password" />
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
				<a href="public/page1" class="btn btn-primary">Retour</a>
			</form>
		</div>
	</div>
</body>
</html>