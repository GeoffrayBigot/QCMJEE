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
				<h1>Epreuves : </h1>
			</div>
			<div class="col-6 text-right">
				<select class="form-control" id="choixEpreuve">
					<option value="EA" selected >EA</option>
					<option value="EC">EC</option>
					<option value="T ">T</option>
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
						<td><a class="btn btn-info" href="passageTest?idEpreuve=<c:out value='${e.id}'></c:out>">
						Commencer</a></td></c:if>
						
					<c:if test="${e.etatEpreuve == 'EC'}">
					<td><a href="passageTest" " class="btn btn-info">Reprendre</a></td></c:if>
					<c:if test="${e.etatEpreuve == 'T'}">
					<td><a href="passageTest"  class="btn btn-info">Aller aux resultats</a></td></c:if>
				</tr>
			</c:forEach>   
		</tbody>
		</thead>
	</table>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
