<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Le plus beau site</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
</head>
<body>
	<h1>Le plus beau site</h1>
	<%--Je commente ici en jsp--%>
	<!--Je commente ici en html-->
<%-- 	<p>
		<%for (int i=0;i<5;i++){ %>
		<h2> <%=i%> : Bonjour <%=request.getParameter("username") %></h2>
		<%} %>
	</p> --%>
	
	<p>
		<%for (int i=0;i<5;i++){ %>
		<h2> <%=i%> : Bonjour ${param.username}</h2>
		<%} %>
	</p>
</body>
</html>