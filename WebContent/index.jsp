<%
String pageTitle = "Accueil";
%>
<jsp:include page="/WEB-INF/jsp/header.jsp" >
  <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
<h1>Accueil</h1>

<% 
/* 	username = request.getAttribute("sessionUtilisateur");
	if(username != null ){
  		out.println( username.getNom() );
	} */
%>

</body>
</html>