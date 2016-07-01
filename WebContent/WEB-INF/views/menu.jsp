<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADMINISTRÇÃO</title>
 <link rel="stylesheet" type="text/css" href="resources/css/menu.css">

</head>
<body background="<c:url value="/resources/images/settings.png" />" >
	<input id="tipo" type="hidden" value="${Tipo}" />
	
	
	<div id="menu">
		<ul>
			<c:if test="${jornalista_logado.nome != null && redator_logado.nome != null}">
				<li><a><b>Olá Redator ${redator_logado.nome}</b></a></li>
			</c:if>
			<c:if test="${redator_logado.nome != null && jornalista_logado.nome == null }">
				<li><a><b>Olá Redator ${redator_logado.nome}</b></a></li>
			</c:if>
			<c:if test="${jornalista_logado.nome != null && redator_logado.nome == null}">
				<li><a><b>Olá Jornalista ${jornalista_logado.nome}</b></a></li>
			</c:if>
			
		<li><a> | </a></li>
		<li><a href="logout">Logout</a></li>
		</ul>
		<ul>
			<c:if test="${Tipo  == 2 }">
				<li><a href="inserirNoticiaFormulario"> Inserir Noticia </a></li>
				<li><a href="listarNoticia">Listar Noticias</a></li>
			</c:if>
			<c:if test="${Tipo  == 3}">
				<li><a  href="inserirUsuarioFormulario"> Inserir Usuario</a></li>
				<li><a href="listarUsuario">Listar Usuarios</a> </li>
				<li><a  href="inserirSecaoFormulario"> Cadastrar Seção</a> </li>
				<li><a href="inserirClassificadoFormulario"> Cadastar Classificado</a></li>
				<li><a href="listarClassificado"> Listar Classificado</a></li>
				<li><a href="inserirPapelFormulario"> Inserir Papel dos usuarios</a></li>
			</c:if>
			<li><a href="goToHome">Jornal</a></li>
		</ul>
		
</div>
	
		
		<a  href="inserirUsuarioFormulario"> Inserir Jornalista ou redator </a> <br />
	
	

</body>
</html>