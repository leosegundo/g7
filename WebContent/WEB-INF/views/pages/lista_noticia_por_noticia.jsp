<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${noticias.titulo}</title>
<style type="text/css">
	<!--
		body {
			padding:0px;
			margin:0px;
		}
 
		#menu ul {
			padding:0px;
			margin:0px;
			float: left;
			width: 100%;
			background-color:#EDEDED;
			list-style:none;
			font:80% Tahoma;
		}
 
		#menu ul li { display: inline; }
 
		#menu ul li a {
			background-color:#EDEDED;
			color: #333;
			text-decoration: none;
			border-bottom:3px solid #EDEDED;
			padding: 2px 10px;
			float:left;
		}
 
		#menu ul li a:hover {
			background-color:#D6D6D6;
			color: #6D6D6D;
			border-bottom:3px solid #EA0000;
		}
	-->
	</style>

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
	<p><h2 align="center">${noticias.titulo}</h2></p>
		
	<p align="center"> <img alt="${noticias.titulo}" src="<c:url value="/resources/images/${noticias.noticiaId}.png"  />" /> </p><br />
		
	<p>${noticias.texto}</p>
	
	
	  
	</p>
	<!-- editar noticia -->
	<p align="right">
	<c:if test="${jornalista_logado.id != null}">		
		<!-- FAZER O ALTERAR -->
		<a href="apagarNoticia?id=${noticias.noticiaId}">Alterar</a></td>
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