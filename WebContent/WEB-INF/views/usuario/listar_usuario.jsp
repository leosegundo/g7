<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuarios</title>
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
		<li><a href="javascript:history.back()"> <<- Voltar</a></li>
		</ul>
		
	</div>

<table border="1">
		<td><b>ID</b></td>
		<td><b>Nome</b></td>
		<td><b>Nick</b></td>
	<c:forEach var="u" items="${usuarios}">
	<tr>
		<td>${u.id}</td>
		<td>${u.nome}</td>
		<td>${u.login}</td>
		<td><a href="apagarUsuario?id=${u.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>