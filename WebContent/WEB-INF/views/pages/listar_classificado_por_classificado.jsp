<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${classificados.titulo}</title>
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
			<li><a href="listarClassificado">classificados</a></li>
			<li><a href="inserirLeitorFormulario">cadastre-se</a></li>
			
		</ul>
</div>

	<p>
	<p><h2 align="center">${classificados.titulo}</h2></p>
	
	<p>Descrição: ${classificados.texto}</p><br />
	<p>Preço: ${classificados.preco}</p><br />
	<p>Autor: ${classificados.autor.nome}</p><br />
	<p>Telefone: ${classificados.telefone}</p><br />
	<p>Melhor oferta: ${classificados.melhorOferta.oferta}</p><br />
	<p>Data: ${classificados.data}</p><br />
	
	
	</p>



<!-- Fazer Oferta -->
	<h2>Fazer Oferta</h2>
	<footer id="footer">
		<hr>
		<c:if test="${usuario_logado.id > 0}">		
		<form action="inserirOfertaClassifcado" method="post">
			<input type="hidden" name="idClass" value="${classificados.id}" />
			<input type="hidden" name="idUser" value="${usuario_logado.id}" />
			<div>
				<textarea name="oferta" id="oferta" style="width:96%;height:90px;padding:2%;font-size:1.2em;background-color:silver;"></textarea>
			</div>
			<input type="submit" value="ofertar" style="width:20%;height:15px;padding:2%;font-size:1.2em;background-color:gray;">
		</form>
		</c:if>
	</footer>

</body>
</html>