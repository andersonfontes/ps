<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
<h1>HELOOO jsppp</h1>
<% out.println("anderson delgado fontes"); %>
<% int i=5; out.println(5); %>
<%--uso do elemento expressao --%>
<p> data: <%= new Date() %> </p>
<%! int contador=0; %>
<p> visitas: <%= contador++ %> </p>
</body>
</html>