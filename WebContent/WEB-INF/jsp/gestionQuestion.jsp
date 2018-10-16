
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
					<form method="post" action="gestionQuestion">
						<div class="form-row">
							 <div class="form-group col-12 col-sm-8">
								<label for="titreQuestion">Titre de la question</label> 
								<input	type="text" class="form-control" id="titreQuestion" name="titreQ" placeholder="Question ?">
							</div>
							<div class="form-group col-12 col-sm-4">
								<label for="nbPoints">Nombre de point</label> 
								<input	type="number" class="form-control" id="nbPoints" name="nbP" step="1" value="1" min="1">
							</div>
							
							<div class="form-group col-12 col-sm-6">
								<label for="typeQuestion">Type de question</label> 
								<select class="form-control" name="typeQ" id="typeQuestion">
									<option disabled selected></option>
									<option value="typeRadio">Type Radio</option>
									<option value="typeCheckbox">Type Checkbox</option>
								</select>
							</div>
							
							<div class="form-group col-6">
								<label for="typeTheme">Théme</label>
								<select class="form-control" name="theme" id="typeTheme">
									<option disabled selected></option>
									<c:forEach items="${listTheme}" var="t">
										<option value="${t.idTheme}">${t.libelle}</option>
									</c:forEach>							
								</select>
							</div>						
						</div>
						
						<div id="accordion">
													
						</div>						
						<button type="submit" class="btn btn-primary">Valider</button>
					</form>
					
					<div id="disabled" class="d-none">
						<div class="" id="typeRadio">														
							<div class="card card-body">								
								<input class="form-control rep-nb-radio" name="nbR" type="number" step="1" value="2" min="2" max="10">
								<div class="row container-rep-radio">
									<div class="rep-radio input-group col-6 mb-1 mt-1">
										<div class="input-group-prepend">
											<span class="input-group-text">1</span>
										</div>
										<input type="text" class="form-control" name="rep-1">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" value="1" name="rep-valide-radio">
											</div>
										</div>
									</div>
									<div class="rep-radio input-group col-6 mb-1 mt-1">
										<div class="input-group-prepend">
											<span class="input-group-text">2</span>
										</div>
										<input type="text" class="form-control" name="rep-2">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="radio" value="2" name="rep-valide-radio">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>	
						<div class="" id="typeCheckbox">
							<div class="card card-body">									
								<input class="form-control rep-nb-checkbox" name="nbR" type="number" step="1" value="2" min="2" max="10">
								<div class="row container-rep-checkbox">
									<div class="rep-checkbox input-group col-6 mb-1 mt-1">
										<div class="input-group-prepend">
											<span class="input-group-text">1</span>
										</div>
										<input type="text" class="form-control" name="rep-1">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="checkbox" value="1" name="rep-valide-1">
											</div>
										</div>
									</div>
									<div class="rep-checkbox input-group col-6 mb-1 mt-1">
										<div class="input-group-prepend">
											<span class="input-group-text">2</span>
										</div>
										<input type="text" class="form-control" name="rep-2">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<input type="checkbox" value="2" name="rep-valide-2">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">Fermer</button>
				</div>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>


