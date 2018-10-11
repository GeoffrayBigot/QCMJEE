<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/THEME/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/THEME/css/style.css" />
<title>Connexion</title>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-6">
			<form method="post" action="connexion">
			  <div class="form-group row">
			    <label for="email" class="col-sm-4 col-form-label">Adresse Email</label>
			    <div class="col-sm-8">
			      <input type="email" class="form-control" name="email" id="email" placeholder="Email">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="password" class="col-sm-4 col-form-label">Mot de passe</label>
			    <div class="col-sm-8">
			      <input type="password" class="form-control"  name="password" id="password" placeholder="Mot de passe">
			    </div>
			  </div>
			  <div class="form-group row">
			    <div class="col-sm-12 text-center">
			      <button type="submit" class="btn btn-secondary">Se Connecter</button>
			    </div>
			  </div>
			</form>	
		</div>
	</div>
</div>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" ></jsp:include>