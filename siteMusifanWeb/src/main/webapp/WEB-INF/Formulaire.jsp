<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container mb-3">
	<c:if test ="${param.error != null}">
		<p> Veuillez entrer un prénom</p>
	</c:if>
<%-- 	<c:choice>
		<c:when test =""></c:when>
		<c:when test =""></c:when>
		<c:otherwise>erreur</c:otherwise>
	</c:choice>
	<%if(request.getParameter("error") != null){ %>
	<p> Veuillez entrer un prénom</p>
	<%} %> --%>
	 <h2>Fomulaire</h2>
      <form action="bonjour" method = "get">
        <div class="mb-3 mt-3">
          <label for="NomPrenom">Prenom :</label>
          <input
            type="text"
            class="form-control"
            id="preom"
            placeholder="Enter Prenom"
            name="prenom"
          />
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
	</div>
</body>
</html>