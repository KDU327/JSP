<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setAttribute("name", "김동욱");
  request.setAttribute("address", "서울시 성동구");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>첫 번째 JSP</title>
  </head>
  <body>
    <%
      // request 객체를 다른 JSP 파일로 포워딩.
      RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
      dispatch.forward(request, response);
    %>
  </body>
</html>