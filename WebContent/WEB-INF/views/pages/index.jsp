<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal</title>
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
		#news p a { display: inline; }
		
 
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
		
		#news p a:hover {
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
		<li><a><b>Ol� ${usuario_logado.nome}</b></a></li>
		<li><a> | </a></li>
		<li><a href="logoutLeitor">Logout</a></li>
		</ul>
		<ul>
			<li><a href="goToHome">Home</a></li>
			<li><a href="listarSecao">Se��es</a></li>
			<li><a href="listarClassificado">classificados</a></li>
			<li><a href="inserirLeitorFormulario">cadastre-se</a></li>
			<li><a><form action="login" method="post">
					<b>Login:</b> <input type="text" name="login" value=""/>
					<b>Senha:</b> <input type="password" name="senha" value=""/>
					<input type="submit" value="ENVIAR" /> 
				</form>
				</a>
			</li>
		</ul>
</div>
	

	<c:forEach var="n" items="${noticias}">
	<table border="2">
		<a href="listaNoticiaPorNoticia?id=${n.noticiaId}"> 
			${n.titulo}<br />
			<img alt="${n.titulo}" src="<c:url value="/resources/images/${n.noticiaId}.png"  />" />
		</a>
		</table>
		<br />
		
		
	</c:forEach>

	

</body>
</html>