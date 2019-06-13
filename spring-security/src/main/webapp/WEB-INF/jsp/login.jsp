<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	Login 페이지 입니다. <br>
	<form action="/loginProcess"  method='POST'>
		ID : <input type="text" name="id" placeHolder="ID"></input>
		PW : <input type="password" name="password" placeHolder="Password"></input>
		<button type="submit" id="loginSubmit">로그인</button>
	</form>
</body>
</html>