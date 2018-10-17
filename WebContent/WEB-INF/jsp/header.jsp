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
  <div class="collapse navbar-collapse justify-content-between" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item acti_1ve">
        <a class="nav-link" href="<%=request.getContextPath() %>/accueil">Accueil</a>
      </li>    
    </ul>
    <% if(session.getAttribute("isConnected") != null) { %>
    	<div class="d-flex">
	    	<p class="m-0 p-2 text-light">${isConnected.profil.libelle }</p>
		    <ul class="navbar-nav">
		    <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          <%=session.getAttribute("userNom")%> <%=session.getAttribute("userPrenom")%>
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          <a class="dropdown-item" href="<%=request.getContextPath() %>/deconnexion">Deconnexion</a>
		        </div>
		      </li> 
		    </ul>
    	</div>    	
	<% } %>
  </div>
</nav>
</header>