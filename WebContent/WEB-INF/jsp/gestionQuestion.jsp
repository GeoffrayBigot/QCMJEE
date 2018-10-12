
<%
	String pageTitle = "Gestion Question";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/jsp/header.jsp">
	<jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>
<body>
	<div class="container-fluid mt-3 mb-3">
		<div class="row">
			<div class="col-6">
				<h1>Gestion Question</h1>
			</div>
			<div class="col-6 text-right">
				<button type="button" class="btn btn-info" data-toggle="modal"
					data-target="#ajouterQuestion">Ajouter une question</button>
			</div>
		</div>
	</div>


	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Numéro Question</th>
					<th scope="col">Question</th>
					<th scope="col">Theme</th>
					<th scope="col">Editer</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listQuestion}" var="item">
					<tr>
						<th scope="row"><c:out value="${item.idQuestion}"></c:out></th>
						<td><c:out value="${item.enonce}"></c:out></td>
						<td><c:out value="${item.theme.libelle}"></c:out></td>
						<td>
							<button type="button" class="btn btn-info" data-toggle="modal"
								data-target="#<c:out value="${item.idQuestion}"></c:out>">
								Editer</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:forEach items="${listQuestion}" var="q">

		<div class="modal fade" id="<c:out value="${q.idQuestion}"></c:out>"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
			aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">
							Question :
							<c:out value="${q.enonce}"></c:out>
						</h5>
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
										<p>
											<c:out value="${r.libelle}"></c:out>
										</p>
									</div>
									<div class="col-4">
										<p>
											<c:out value="${r.estCorrecte}"></c:out>
										</p>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" data-dismiss="modal">Fermer</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<div class="modal fade" id="ajouterQuestion" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ajouter une
						question</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="titreQuestion">Titre de la question</label> <input
								type="text" class="form-control" id="titreQuestion"
								placeholder="Question ?">
						</div>

						<div class="form-group">
							<label for="typeQuestion">Type de question</label> 
							<select class="form-control" id="typeQuestion">
								<option disabled selected></option>
								<option value="typeRadio">Type Radio</option>
								<option value="typeCheckbox">Type Checkbox</option>
								<option value="typeText">Type Text</option>
							</select>
						</div>
						<div id="accordion">
							<div class="collapse" id="typeRadio" data-parent="#accordion">
								<div class="card card-body">
									<div class="form-check">
										<input class="form-check-input" type="radio"
											name="exampleRadios" id="exampleRadios2" value="option2">
										<label class="form-check-label" for="exampleRadios2">
											Type Radio </label>
									</div>
								</div>
							</div>
							<div class="collapse" id="typeCheckbox" data-parent="#accordion">
								<div class="card card-body">									
									<div class="form-check">
										<input class="form-check-input" type="checkbox" value=""
											id="defaultCheck1"> <label class="form-check-label"
											for="defaultCheck1"> Type Checkbox</label>
									</div>
								</div>
							</div>
							<div class="collapse" id="typeText" data-parent="#accordion">
								<div class="card card-body">
									<p>typeText</p>
								</div>
							</div>
						</div>						
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">Fermer</button>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


