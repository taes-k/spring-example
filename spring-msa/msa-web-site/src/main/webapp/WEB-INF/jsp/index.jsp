<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MSA NEWS</title>
</head>
<body>

<div class="header" style="width:100%;height:100px;line-height:100px;border-bottom:1px solid #d0d0d0">Trick&Basic News</div>
<div class="news-container">
	<c:forEach var="el" items="${newsData}">
		<div class="news" style="margin-bottom:20px;">
			${el.title}<br>
			${el.type} / ${el.author} / ${el.date}<br>
			${el.contents}
		</div>
	</c:forEach>
</div>
</body>
</html>