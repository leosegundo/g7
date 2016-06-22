<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action=inserirOfertaClassifcado method="post">
		<input type="hidden" name="idClassi" value="${idClassificado}" />
		<input type="hidden" name="idUser" value="${redator_logado.id}" />
		<!-- <input type="hidden" name="idUsuario" value="${usuario_logado.id}" /> -->
		oferta <input type="text" name="oferta" />
		 
		<input type="submit" value="ENVIAR" />
		
	</form>

</body>
</html>