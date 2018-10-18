
<%
	String pageTitle = "resultats";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
	<div class="container">
		<div class="row text-center">
			<div class="col-12">
				<h1>
					<c:out value="${epreuve.test.nom}"></c:out>
				</h1>
			</div>
			<div class="col-12">
				<p>
					<c:out value="${epreuve.test.description}"></c:out>
				</p>
			</div>
			<div class="col-12">
				<p>
					Note :
					<c:out value="${epreuve.note}"></c:out>
					<c:out value="${epreuve.niveauAcquisition}"></c:out>
				</p>
			</div>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Numéro</th>
					<th scope="col">Question</th>
					<th scope="col">Valide</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach begin="0" end="${fn:length(AllQuestions)-1}" var="v">
					<c:if test="${QuestionsCorrectes[v] == AllQuestions[v].idQuestion}">
						<tr>
							<th scope="row"><c:out value="${v+1}"></c:out></th>
							<td><c:out value="${AllQuestions[v].enonce}"></c:out></td>
							<td class="text-success">Oui</td>
						</tr>

					</c:if>
					<c:if test="${QuestionsCorrectes[v] != AllQuestions[v].idQuestion}">
						<tr>
							<th scope="row"><c:out value="${v+1}"></c:out></th>
							<td><c:out value="${AllQuestions[v].enonce}"></c:out></td>
							<td class="text-danger">Non</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<div class="col-12">
			<p class="text-center">
				<a class="btn btn-info" href="<%=request.getContextPath() %>/choixTest">Liste des épreuves</a>
			</p>			
		</div>
	</div>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


