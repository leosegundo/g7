<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Se��es</title>
	<link rel="stylesheet" type="text/css" href="resources/css/style2.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</head>

<body>

<div id="menu">
		<ul>
		<li><a><b>Ol� ${usuario_logado.nome}</b></a></li>
		<li><a> | </a></li>
		<li><a href="logoutLeitor">Logout</a></li>
		</ul>
		<ul>
			<li><a href="goToHome">Home</a></li>
			<li><a href="listarSecao">Se��es</a></li>
			<li><a href="listarClassificado">classificados</a></li>
			<li><a href="inserirLeitorFormulario">cadastre-se</a></li>
			
		</ul>
</div>
	
<br />	
<br />

<div class="container">
	  	<div class="row">
	  		<c:forEach var="s" items="${secoes}">
	    		<div class="col-md-4">
      				<a href="listaNoticiaPorSecao?id=${s.secaoId}" >
				       	<font color="${s.cor}"><p>${s.titulo}:${s.descricao}</p></font>
        			</a>
    			</div>
    		</c:forEach>
		</div>
</div>

<br />


</body>
</html>