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
	<div class="connexion">
			<form method="post" action="connexion">
			<div class="form-group row">
			    <div class="col-12 text-center">
			    	<h1>Connection</h1>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="email" class="col-12 col-form-label">Adresse Email</label>
			    <div class="col-12">
			      <input type="email" class="form-control" name="email" id="email" placeholder="Email">
			      <span class="text-danger">${erreurs['email']}</span>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="password" class="col-12 col-form-label">Mot de passe</label>
			    <div class="col-12">
			      <input type="password" class="form-control"  name="password" id="password" placeholder="Mot de passe">
			      <span class="text-danger">${erreurs['password']}</span>
			    </div>
			  </div>
			  <div class="form-group row">
			    <div class="col-12 text-center">
			      <button type="submit" class="btn btn-info">Se Connecter</button>			     
			    </div>
			     <span class="text-danger">${erreurs['user']}</span>
			  </div>
			</form>		
	</div>
</div>

</body>
<jsp:include page="/WEB-INF/jsp/footer.jsp" ></jsp:include>