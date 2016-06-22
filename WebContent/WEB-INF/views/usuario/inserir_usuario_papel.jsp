<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Usuario</title>
<style type="text/css">
	<!--
		body {
			padding:0px;
			margin:0px;
		}
		
		#div form {
			padding:0px;
			margin:0px;
			float: left;
			width: 100%;
			background-color:#EDEDED;
			list-style:none;
			font:80% Tahoma;
		}
 /**/
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
		<li><a href="javascript:history.back()"> <<- Voltar</a></li>
		</ul>
		
	</div>

	<div id="dados">
	<form action="inserirUsuario" method="post" style="width:95%;height:100px;padding:4%;font-size:1.2em;background-color:silver;">
		Nome: <input type="text" name="nome" />
		<br />
		Papel:   
		<select name="papel">
				<c:forEach var="a" items="${papeis}">
				<option value="${a.id}">${a.papel}</option>
				</c:forEach>
			</select><br />
			
		Email: <input type="email" name="email" /><br />
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="password" name="senha" /> <br />
		<input type="submit" value="ENVIAR" />
		
	</form>


</body>
</html>