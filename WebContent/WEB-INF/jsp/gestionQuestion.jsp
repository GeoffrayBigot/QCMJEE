
<%
String pageTitle = "Gestion Question";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
	<h1>Gestion Question</h1>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Numéro Question</th>
				<th scope="col">Question</th>
				<th scope="col">Theme</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listQuestion}" var="item">				
				<tr>
					<th scope="row"><c:out value="${item.idQuestion}"></c:out></th>
					<td><c:out value="${item.enonce}"></c:out></td>
					<td><c:out value="${item.theme.libelle}"></c:out></td>
				</tr>
			</c:forEach>
			
			<c:forEach items="${listReponse}" var="item">				
				<tr>
					<th scope="row"><c:out value="${item.idReponse}"></c:out></th>
					<td><c:out value="${item.libelle}"></c:out></td>
					<td><c:out value="${item.estCorrecte}"></c:out></td>
					<td><c:out value="${item.idQuestion}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


