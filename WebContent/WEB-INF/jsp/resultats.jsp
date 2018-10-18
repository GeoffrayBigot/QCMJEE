
<%
String pageTitle = "resultats";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
<c:forEach items="${QuestionsCorrectes}" var="q">
							<div class="col-6 form-group">
								<c:out value="${q}"></c:out>
							</div>
					</c:forEach>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


