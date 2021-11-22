<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	variable session: ${sessionScope['session1']}
	${session1}
	variable application: ${applicationnScope['application1']}
	${application1}
	
	<% 
		Cookie tab [] = request.getCookies(); 
		if(tab != null){
			for(Cookie c:tab){
	%>
				
	<%			
			}
		}
	%>
</body>
</html>