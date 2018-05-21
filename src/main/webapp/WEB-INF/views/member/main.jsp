<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">
<h1>메인화면</h1>
<hr>
<div>
<c:choose>
	<c:when test="${empty login }">
		<a href="/member/join.do">회원가입</a> |
		<a href="/member/login.do">로그인</a>
	</c:when>
	<c:when test="${login eq true}">
		<a href="/member/logout.do">로그아웃</a>
	</c:when>
</c:choose>
<hr>
	<a href="/board/list.do">목록</a>
</div>

</div>

</body>
</html>









