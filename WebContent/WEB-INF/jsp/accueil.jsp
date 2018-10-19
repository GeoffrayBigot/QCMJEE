
<%
	String pageTitle = "accueil";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 mt-3 mb-3 text-center">
				<h1>Accueil</h1>
			</div>
			<c:if test="${isConnected.profil.codeProfil == 1 }">
				<div class="col-sm-6">
					<a class="btn btn-info" href="gestionQuestion">Gestion des
						Questions</a>
				</div>
				<div class="col-sm-6">Page de resultat des élèves</div>
			</c:if>
			<c:if test="${isConnected.profil.codeProfil == 2 }">
				<div class="col-sm-6">inscrire un élève</div>
				<div class="col-sm-6">
					<a class="btn btn-info" href="gestionQuestion">Gestion des
						Questions</a>
				</div>
			</c:if>
			<c:if test="${isConnected.profil.codeProfil == 3 }">
				<div class="col-sm-6">
					<a class="btn btn-info" href="choixTest">Passer une epreuves</a>
				</div>
			</c:if>
		</div>
	</div>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


