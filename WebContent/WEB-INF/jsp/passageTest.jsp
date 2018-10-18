
<%
	String pageTitle = "questions";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>

	<div class="container">
		<form method="post" action="resultats">
		<c:set var="incr" value="0" scope="page" />
		<c:set var="quest" value="1" scope="page" />
		
			<c:forEach items="${listQuestionsEpreuve}" var="q">
				<div class="form-row">
					<div class="col-12 form-group">
						<h2>
							<c:out value="${q.enonce}"></c:out>
						</h2>
						<input class="d-none" type="hidden"  value="<c:out value="${q.idQuestion}"></c:out>" name="q-<c:out value="${quest}"></c:out>"> 
						<input class="d-none" type="hidden"  value="<c:out value="${idEpreuve}"></c:out>" name="idEpreuve"> 
						<c:set var="quest" value="${quest + 1}" scope="page"/>
					</div>
					<c:forEach items="${listReponsesEpreuve}" var="r">
						<c:if test="${r.idQuestion == q.idQuestion}">
							<div class="col-6 form-group">
								<label for="rep<c:out value="${incr}"></c:out>"><c:out value="${r.libelle}"></c:out></label>
								<input type="checkbox" id ="rep<c:out value="${incr}"></c:out>" name="<c:out value="${incr}"></c:out>" value="<c:out value="${r.idReponse}"></c:out>">
								<c:set var="incr" value="${incr + 1}" scope="page"/>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:forEach>
			<input class="d-none" type="hidden"  value="<c:out value="${quest}"></c:out>" name="nbQuestions"> 
			<button type="submit" class="btn btn-info">valider</button>
		</form>
	</div>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
