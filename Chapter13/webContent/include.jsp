<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>include.jsp : �赿��</title>
	</head>
	<body>
	  �ȳ��ϼ���. JSP ���θ� ���� �κ��Դϴ�. <br>
	  <jsp:include page="duke_image.jsp">
	    <jsp:param value="��ũ" name="name"/>
	    <jsp:param value="duke.png" name="imgName"/>
	  </jsp:include>
	  
	  <br>
	  JSP ���θ� �� �κ��Դϴ�.
	</body>
</html>