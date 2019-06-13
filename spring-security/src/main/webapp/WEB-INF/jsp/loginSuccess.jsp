<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	로그인 성공 페이지입니다.<br>
	${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}님이 로그인 하셨습니다. <br>
	<form action="/logout"  method='POST'>
		<button type="submit" id="loginSubmit">로그아웃</button>
	</form>
</body>
</html>