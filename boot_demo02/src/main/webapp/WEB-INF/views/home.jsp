<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** springBoot home2 JSP **</title>
<style type="text/css">
@font-face {
	font-family: 'GangwonEdu_OTFBoldA';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	background-color: Lavenderblush;
	text-align: center; /* 텍스트 중앙 정렬 */
	font-family: 'GangwonEdu_OTFBoldA';
	font-size: 20px;
}

.red {
	color: red;
	font-size: 22px;
}

pre {
	font-family: 'GangwonEdu_OTFBoldA';
}
</style>
</head>
<body>
	<h1>🐻 springBoot demo2 🐻</h1>
	<p>* HOME_TIME (server time) : ${requestScope.serverTime}</p>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">

	<c:if test="${not empty sessionScope.loginName}">
		<br>
${sessionScope.loginName} 님 안녕하세요 !
	<br>
		<hr
			style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	</c:if>


	<img alt="mainImage" src="/resources/images/summersea.jpg" width="400"
		height="300" margin="auto">
	
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<!-- =======================c : choose 활용===========================  -->
	<c:choose>
		<c:when test="${empty sessionScope.loginName}">
			<a href="member/loginForm">LoginF</a>&nbsp;
			<a href="member/joinForm">JoinF</a>
			<br>
			<a href="jo/joList">joList</a>
			<a href="member/memberList">Member List1</a><br>
			
		</c:when>
		<c:otherwise>
			<a href="member/memberList">Member List1</a><br>
			<a href="member/memberDetail?jCode=D">myInfo</a>
			<a href="member/memberDetail?jCode=U">내 정보 수정하기</a><br>
			<a href="member/logout">Logout</a>
			<a href="member/mdelete">탈퇴하기</a>
			<br>
			<a href="jo/joList">joList</a>
			<!-- <a href="jo/joDetail?jCode=D"">joDetail</a> -->
		
		</c:otherwise>
	</c:choose>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<br>
	<a href="board/boardList">boardList</a><br>
	<a href="bcrypt">BCrypt</a>&nbsp;&nbsp;<br><br>
	<a href="board/bPageList">BPage</a>
	<a href="member/mPageList">MPage</a>
	<br>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
</body>
</html>