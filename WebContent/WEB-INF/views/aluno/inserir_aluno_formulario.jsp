<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Aluno</title>
</head>
<body>
	
	<form action="inserirAluno" method="post">
		Nome: <input type="text" name="nome" />
		<form:errors path="aluno.nome" /> 
		<br />
		IRA: <input type="text" name="IRA" /> <br />
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="text" name="senha" /> <br />
		
		<input type="submit" value="ENVIAR" />
		
	</form>

</body>
</html>