<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listar Noticia</title>

	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</head>

<body>

<div id="menu">
	<ul>
	<li><a href="javascript:history.back()"> <<- Voltar</a></li>
	</ul>
		
</div>

<table border="1">
	<tr>
		<td align="center"><b>Id </b></td>
		<td align="center"><b>Titulo</b></td>
		<td align="center"><b>Texto</b></td>
		<td align="center"><b>Imagem</b></td>
		<td align="center"><b>Alterar</b></td>
	</tr>
	
	<c:forEach var="n" items="${noticias}">
		<tr>
			<td align="center">${n.noticiaId}</td> 
			<td align="center">${n.titulo}</td>
			<td align="center"><a href="listaNoticiaPorNoticia?id=${n.noticiaId}">${n.texto}</a></td>
			<td><img alt="${n.titulo}" src="<c:url value="/resources/images/${n.noticiaId}.png"  />" /></td>
			<td><a href="alterarNoticiaFormulario?id=${n.noticiaId}">ALTERAR</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>