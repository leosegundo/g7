<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jornal</title>

	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/css/menu.css">
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
		<li><li><a href="loginFormulario"> Administra��o</a></li></li>
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
	
	
<div class="container">
	  	<div class="row">
	  		<c:forEach var="n" items="${noticias}">
	  			<div class="col-md-4">
	  				<a href="listaNoticiaPorNoticia?id=${n.noticiaId}">
				       	<font color="${n.secao.cor}"><p>${n.titulo}</p></font>
        				<img src="<c:url value="/resources/images/${n.noticiaId}.png"  />" alt="${n.titulo}" style="width:150px;height:150px">
      				</a>
      				
    			</div>
    		</c:forEach>
		</div>
</div>
<!-- 
	<c:forEach var="n" items="${noticias}">
	<table border="2">
		<a href="listaNoticiaPorNoticia?id=${n.noticiaId}"> 
			${n.titulo}<br />
			<img alt="${n.titulo}" src="<c:url value="/resources/images/${n.noticiaId}.png"  />" />
		</a>
		</table>
		<br />
		
		
	</c:forEach>
 -->
	

</body>
</html>