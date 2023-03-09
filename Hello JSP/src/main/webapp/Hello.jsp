<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>HELLO JSP</title>
</head>
<body>

<h1>Hello JSP</h1>
<%out.println("anderson delgado fontes"); %>
<%--uso do elemento expressao --%>
<p>Data: <%
		Date d=new Date();
		SimpleDateFormat strDate = new SimpleDateFormat("dd/MM/yyyy");
		out.print(strDate.format(d));
		%>
		<%!int contador = 0;%>
		<p>Visitas: <%=contador++ %>
</body>
</html>