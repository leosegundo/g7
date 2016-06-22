<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario Papel</title>
</head>
<body>
			
	<form action="inserirComentario" method="post">
		<input type="hidden" name="idNoticia" value="${idNoticia}" />
		<input type="hidden" name="idUsuario" value="${jornalista_logado.id}" />
		<!-- <input type="hidden" name="idUsuario" value="${usuario_logado.id}" /> -->
		<h3>Comentario:</h3>
		<textarea rows="10" cols="30" name="texto"></textarea>
		<input type="submit" value="ENVIAR" />
		
	</form>


</body>
</html>