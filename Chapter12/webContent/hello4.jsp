<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 선언문 작성 -->
<%!
  String name = "김동욱";
  public String getName() {
	  return name;
  }
%>

<!-- 스크립트 작성 -->
<%
  /* 스크립트 주석 처리 */
  /*String age = request.getParameter("age");*/
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>선언문 연습 - 김동욱</title>
  </head>
  <body>
    <!-- 표현식 -->
    <h1>안녕하세요. <%= name %>님!</h1>
    <h2>당신의 나이는 <%= age %>살입니다.</h2>
    <h1>키는 <%= 180 %>cm입니다.</h1>
    <h1>나이 + 10은 <%--<%= Integer.parseInt(age) + 10 %>--%>살 입니다.</h1>
  </body>
</html>