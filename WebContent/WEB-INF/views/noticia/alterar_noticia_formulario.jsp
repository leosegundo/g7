<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Noticia</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div id="menu">
	<ul>
		<li><a href="javascript:history.back()"> <<- Voltar</a></li>
	</ul>
</div>

<h2 align="center" style="width:95%; height:10px; padding:4%;font-size:1.2em; background-color:silver;">
	Alterar Noticia
</h2>

<form action="alterarNoticia" method="POST" style="width:95%;height:100px;padding:4%;font-size:1.2em;background-color:silver;">
	<input type="hidden" name="noticiaId" value="${noticia.noticiaId}" />
	<input type="hidden" name="idAutor" value="${noticia.autor.id}" />
	Titulo: <input type="text" name="titulo" value="${noticia.titulo}" /><br />
	Texto: <textarea rows="" cols="" name="texto">${noticia.texto}</textarea><br />
	
	Seção: <select name="secaoValores" onblur="">
					<c:forEach var="s" items="${secoes}">
						<option value="${s.secaoId}">${s.titulo}</option>
					</c:forEach>
				</select><br />
				<br /> 
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>