
<%
	String pageTitle = "resultats";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					Note : <c:out value="${epreuve.note}"></c:out>
				</p>
			</div>
		</div>
	</div>

	<c:forEach items="${QuestionsCorrectes}" var="c">
		<div class="col-6 form-group">
			<c:out value="${c}"></c:out>
		</div>
	</c:forEach>

	<c:forEach items="${AllQuestions}" var="q">
		<div class="col-6 form-group">
			<c:out value="${q}"></c:out>
		</div>
	</c:forEach>


</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


