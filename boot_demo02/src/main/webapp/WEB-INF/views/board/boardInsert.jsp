<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Jo Update Spring_Boot Mybatis**</title>
<link rel="stylesheet" type="text/css"
	href="/resources/myLib/myStyle.css">
</head>
<body>
	<h2>** board Insert Spring_MVC2 **</h2>
	<hr>
	<form action="insert" method="Post">
		<table style="margin: auto;">
			<tr height="40">
				<td bgcolor="Linen">🐇title(제목)</td>
				<td><input type="text" name="title" 
					size="20"></td>
			</tr>
			<tr height="40">
				<td bgcolor="Linen">🐇id(글쓴이)</td>
				<td><input type="text" name="id" size="20"
					value="${sessionScope.loginID}" readonly></td>
			</tr>
			<tr height="40">
				<td bgcolor="Linen">🐇content(내용)</td>
				<td><textarea  name="content"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록하기">&nbsp;&nbsp; <input
					type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<c:if test="${not empty message}">
		<hr>
${message}<br>
	</c:if>
	<hr>

	<a href="javascript:history.go(-1)">이전으로</a> &nbsp;&nbsp;
	<a href="/home">[Home]</a>
</body>
</html>