<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formateurs</title>
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
			<h2>Page des formateurs</h2>
			<button type="button" class="btn btn-primary"
				data-bs-toggle="collapse" data-bs-target="#ajoutForm">Ajouter
				un formateur</button>
			<div id="ajoutForm" class="collapse">
				<form action="ajoutFormateurServlet" method="get">
					<div class="mb-3 mt-3">
						<label for="Nom">Nom :</label> <input type="text"
							class="form-control" id="nom" placeholder="Enter Nom" name="nom" />
						<label for="Prenom">Prenom :</label> <input type="text"
							class="form-control" id="prenom" placeholder="Enter Prenom"
							name="prenom" />
					</div>
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</form>
			</div>
			
		</div>
		<br> 
		<div class="row">
			<h5>Liste des formateurs</h5>
			<table class="table table-striped">
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th></th>
				</tr>
				<c:forEach items="${formateurs}" var="f">
					<tr>
						<td>${f.getFormateur_id()}</td>
						<td>${f.getNom()}</td>
						<td>${f.getPrenom()}</td>
						<td>
							<a class="btn btn-secondary" href="FormateurController?q=modif&id=${f.getFormateur_id()}">Modifier</a>
							<a class="btn btn-outline-danger" href="FormateurController?q=delete&id=${f.getFormateur_id()}">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>