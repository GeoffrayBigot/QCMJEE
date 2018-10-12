
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
					<th scope="row">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#<c:out value="${item.idQuestion}"></c:out>">
							<c:out value="${item.idQuestion}"></c:out>
						</button>
					</th>
					<td><c:out value="${item.enonce}"></c:out></td>
					<td><c:out value="${item.theme.libelle}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
		<c:forEach items="${listQuestion}" var="q">

			<div class="modal fade" id="<c:out value="${q.idQuestion}"></c:out>"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Question : <c:out value="${q.enonce}"></c:out></h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-8">
									<p>Libelle</p>
								</div>
								<div class="col-4">
									<p>Correcte</p>
								</div>
								<c:forEach items="${listReponse}" var="r">
									<c:if test="${q.idQuestion == r.idQuestion}">								
										<div class="col-8">
											<p><c:out value="${r.libelle}"></c:out></p>
										</div>
										<div class="col-4">
											<p><c:out value="${r.estCorrecte}"></c:out></p>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<!-- <button type="button" class="btn btn-primary">Save
								changes</button> -->
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</table>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


