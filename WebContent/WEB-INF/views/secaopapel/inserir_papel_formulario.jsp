<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Papel</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<h2>Inserir Nova função do Usuário</h2><br />
	<form action="inserirPapel" method="post">
		Nome: <input type="text" name="papel" />
		<br />
		<input type="submit" value="ENVIAR" />
		
	</form>

</body>
</html>