<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
   request.setCharacterEncoding("UTF-8");

   // request 내장 객체에 바인딩
   request.setAttribute("id", "hong");
   request.setAttribute("pwd", "1234");
   // session 내장 객체에 바인딩
   session.setAttribute("name", "홍길동");
   application.setAttribute("email", "hong@test.com");
%>
<html>
	<head>
		<meta charset=”UTF-8">
		<title>forward01</title>
	</head>
	<body>
	  <jsp:forward page="member1.jsp"/>
	</body>
</html>