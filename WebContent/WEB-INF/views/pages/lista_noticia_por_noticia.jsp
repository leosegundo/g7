<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- charset=ISO-8859-1 -->
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${noticias.titulo}</title>

	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

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
			<li><a href="listarClassificado">classificados</a></li>
			<li><a href="inserirLeitorFormulario">cadastre-se</a></li>
			
		</ul>
</div>

<p>
	<p>
		<font color="${noticias.secao.cor}"><h2 align="center">${noticias.titulo}</h2>
	</p>
		
	<p align="center"> <img alt="${noticias.titulo}" src="<c:url value="/resources/images/${noticias.noticiaId}.png"  />" /> </p><br />
		
	<p>${noticias.texto}</p>
	</font>
	
	
	  
	</p>
	<!-- editar noticia -->
	<p align="right">
		<c:if test="${jornalista_logado.id != null}">
			<form action="alterarNoticiaFormulario?id=${noticias.noticiaId}" method="POST">
				<input type="hidden" name="idNoticia" value="${noticias.noticiaId}" />
				<input type="hidden" name="autor" value="${noticias.autor.id}" />
				<input type="hidden" name="idSecao" value="${secao.secaoId}" />
				<!-- <a href="alterarNoticia?id=${noticias.noticiaId}">Alterar</a></td> -->
				<input type="submit" value="Alterar">
			</form>
		</c:if>
	</p>
	
	<!-- comentario -->
	<footer id="footer">
		<hr>
		<c:if test="${usuario_logado.id > 0}">		
		<form action="inserirComentario" method="post">
			<input type="hidden" name="idNoticia" value="${noticias.noticiaId}" />
			<input type="hidden" name="idUsuario" value="${usuario_logado.id}" />
			<div>
				<textarea name="texto" id="comments" style="width:96%;height:90px;padding:2%;font-size:1.2em;background-color:silver;">Hey... say something! </textarea>
			</div>
			<input type="submit" value="Comentar" style="width:20%;height:15px;padding:2%;font-size:1.2em;background-color:gray;">
		</form>
		</c:if>
		<table align="center" border="0" style="font-size:1.2em;background-color:silver;">
			<c:forEach var="c" items="${comentarios}">
				<tr>
					<td><b>${c.autor.nome}:</b></td> 
					
					<td>${c.texto}</td>
				</tr>
			</c:forEach>
		</table>
	 </footer>
	
		
</body>
</html>