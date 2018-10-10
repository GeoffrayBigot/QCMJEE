<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/THEME/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/THEME/css/style.css" />
<title><%= request.getParameter("pageTitle") %></title>
</head>
<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="<%=request.getContextPath() %>/">QCM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath() %>/">Accueil</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/connexion">Connexion</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath() %>/deconnexion">Deconnexion</a>
      </li>
    </ul>
  </div>
</nav>
</header>