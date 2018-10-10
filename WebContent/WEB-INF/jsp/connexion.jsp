<%
String pageTitle = "Connexion";
%>
<jsp:include page="/WEB-INF/jsp/header.jsp" >
  <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
    <form method="post" action="connexion">
        <p>
            <label for="email">Adresse email : </label>
            <input type="email" name="email" id="email" />
        </p>
        <p>
            <label for="password">Mot de passe : </label>
            <input type="password" name="password" id="password" />
        </p>
        
        <input type="submit" />
    </form>
</body>
</html>