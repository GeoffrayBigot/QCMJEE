<%
String pageTitle = "accueil";
%>
<jsp:include page="/WEB-INF/jsp/header.jsp" >
  <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
    <% if(session.getAttribute("isConnected") != null){ %>
	<p>Bonjour 	<%=session.getAttribute("userNom")%> <%=session.getAttribute("userPrenom")%></p>	
	<p>tu es le GREAT <%=session.getAttribute("userProfil")%> <%=session.getAttribute("userNom")%> </p>	
	<% } %>
    
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" ></jsp:include>
