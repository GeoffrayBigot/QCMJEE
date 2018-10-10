<%
String pageTitle = "Accueil";
%>
<jsp:include page="/WEB-INF/jsp/header.jsp" >
  <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
<h1>Accueil</h1>

<% if(session.getAttribute("userNom") != null){ %>
	<p>Bonjour 	<%=session.getAttribute("userNom")%> <%=session.getAttribute("userPrenom")%></p>
<% } %>

</body>
</html>