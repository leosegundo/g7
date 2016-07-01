<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticias por seções</title>

<link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>

<div id="menu">
		<ul>
		<li><a><b>Olá ${usuario_logado.nome}</b></a></li>
		<li><a> | </a></li>
		<li><a href="logoutLeitor">Logout</a></li>
		</ul>
		<ul>
			<li><a href="goToHome">Home</a></li>
			<li><a href="listarSecao">Seções</a></li>
			<li><a href="#">classificados</a></li>
			<li><a href="inserirLeitorFormulario">cadastre-se</a></li>
			
		</ul>
	</div>

<br />
<!-- <table border="1"> -->
	<c:forEach var="n" items="${noticias}">
				<a href="listaNoticiaPorNoticia?id=${n.noticiaId}">
				<h4>${n.titulo} </h4>
				<img alt="${n.titulo}" src="<c:url value="/resources/images/${n.noticiaId}.png" />" />
			</a>
			<br />
			______________
	</c:forEach>
	


</body>
</html>