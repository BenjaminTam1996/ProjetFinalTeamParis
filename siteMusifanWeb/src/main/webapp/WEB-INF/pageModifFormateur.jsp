<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification formateur</title>
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
<body>
	<div class="container">
		<div class="row">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger alert-dismissible fade show"">
					<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
					<strong>Warning!</strong> Veuillez compléter l'ensemble des champs.
				</div>
			</c:if>
			<br> <br>
			<h2>Page modification du formateur</h2>
			<br>
			<h4>Modification du formateur ${formateurNom} ${formateurPrenom}</h4>
			<form action="modifFormateurServlet" method="get">
				<div class="mb-3 mt-3">
					<label for="id">Id :</label> <input value="${idmodif}"
						type="text" class="form-control" id="id"
						name="id" readonly /> 
					<label for="Nom">Nom :</label> <input
						value="${formateurNom}" type="text" class="form-control" id="nom"
						placeholder="Enter Nom" name="nom" /> 
					<label for="Prenom">Prenom :</label> <input value="${formateurPrenom}" type="text"
						class="form-control" id="prenom" placeholder="Enter Prenom"
						name="prenom" />
				</div>
				<button type="submit" class="btn btn-primary">Modifier</button>
			</form>
		</div>
	</div>
</body>
</html>