
<%
	String pageTitle = "Choix du test";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>

	<div class="container-fluid mt-3 mb-3">
		<div class="row">
			<div class="col-6">
				<h1>Epreuves :</h1>
			</div>
			<div class="col-6 text-right">
				<select class="form-control" id="choixEpreuve">
					<option value="EA" selected>En attente</option>
					<option value="EC">En cours</option>
					<option value="T ">Terminée</option>
				</select>
			</div>
		</div>
	</div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Etat Epreuve</th>
				<th scope="col">Libelle du test</th>
				<th scope="col">Description du test</th>
				<th scope="col">Duree du test</th>
				<th scope="col">Action</th>
			</tr>
		<tbody>
			<c:forEach items="${listEpreuve}" var="e">
				<tr class="<c:out value="${e.etatEpreuve}"></c:out> d-none ">
					<th scope="row"><c:out value="${e.etatEpreuve}"></c:out></th>
					<td><c:out value="${e.test.nom}"></c:out></td>
					<td><c:out value="${e.test.description}"></c:out></td>
					<td><c:out value="${e.test.duree} Minutes"></c:out></td>
					<c:if test="${e.etatEpreuve == 'EA'}">
						<td>
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#modal-EA--<c:out value="${e.id}"></c:out>">Commencer</button>
						</td>
					</c:if>
					<c:if test="${e.etatEpreuve == 'EC'}">
						<td>
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#modal-EC-<c:out value="${e.id}"></c:out>">reprendre</button>
						</td>
					</c:if>
					<c:if test="${e.etatEpreuve == 'T'}">
						<td><a href="<%=request.getContextPath() %>/resultats" class="btn btn-info">Aller aux
								resultats</a></td>
					</c:if>
				</tr>

			</c:forEach>
		</tbody>
		</thead>
	</table>
	<!-- Button trigger modal -->

	<c:forEach items="${listEpreuve}" var="e">
		<!-- Modal -->
		<c:if test="${e.etatEpreuve == 'EA'}">
			<div class="modal fade"
				id="modal-EA--<c:out value="${e.id}"></c:out>"
				data-duree="<c:out value="${e.test.duree}"></c:out>"
				data-temps="<c:out value="${e.tempsEcoule}"></c:out>"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">${e.test.nom}</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>${e.test.description}</p>
							<p id="timer"></p>
							<p>Le test va durer ${e.test.duree} minutes</p>
							<p>êtes vous sûr de vouloir commencer ce test ?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Non</button>
							<a class="btn btn-info"
								href="passageTest?idEpreuve=<c:out value='${e.id}'></c:out>">
								Oui</a>
						</div>
					</div>
				</div>
			</div>
		</c:if>

		<c:if test="${e.etatEpreuve == 'EC'}">

			<div class="modal fade" id="modal-EC-<c:out value="${e.id}"></c:out>"
				tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">${e.test.nom}</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>${e.test.description}</p>
							<p>vous avez passé ${e.tempsEcoule} minutes</p>
							<p>êtes vous sûr de vouloir reprendre ce test ?</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Non</button>
							<a href="passageTest" " class="btn btn-info">Reprendre</a>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:forEach>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
