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

a {
    display: inline-block;
    text-decoration: none;
}
a:hover { 
    color:Olivedrab !important; 
    font-size: 1.5em !important; 
    font-weight : bold;
    cursor: pointer !important; 
    }
</style>
</head>
<body>

        <h2>
        <span style="box-shadow: inset 0 -40px 0  White;">⋆｡♡ﾟ☁︎ ⋆｡ ﾟ☁︎ ﾟ｡♡⋆｡⋆｡♡ﾟ☁︎ ⋆｡ ﾟ☁︎ ﾟ｡♡⋆｡‧</span>
          <br><span style="box-shadow: inset 0 -40px 0  White;">💐🌿 SpringBoot JPA 🪻🌹</span><br>
        <span style="box-shadow: inset 0 -40px 0  White;">⋆｡♡ﾟ☁︎ ⋆｡ ﾟ☁︎ ﾟ｡♡⋆｡⋆｡♡ﾟ☁︎ ⋆｡ ﾟ☁︎ ﾟ｡♡⋆｡‧</span>
        </h2>
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
		height="300" >
	
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<!-- =======================c : choose 활용===========================  -->
	<c:choose>
		<c:when test="${empty sessionScope.loginName}">
			<a href="member/loginForm">LoginF</a>&nbsp;
			<a href="member/joinForm">JoinF</a>
			<br>
			<a href="jo/joList">joList</a>&nbsp;&nbsp;
			<a href="member/memberList">MemberList1</a>&nbsp;&nbsp;
			<a href="member/joindsl">joindsl</a>
			
		</c:when>
		<c:otherwise>
			<a href="member/memberList">MemberList1</a><br>&nbsp;&nbsp;
			<a href="member/joindsl">joindsl</a>
			<a href="member/memberDetail?jCode=D">myInfo</a>&nbsp;&nbsp;
			<a href="member/memberDetail?jCode=U">내 정보 수정하기</a><br>
			<a href="member/logout">Logout</a>&nbsp;&nbsp;
			<a href="member/mdelete">탈퇴하기</a>
			<br>
			<a href="jo/joList">joList</a>
			<!-- <a href="jo/joDetail?jCode=D"">joDetail</a> -->
		
		</c:otherwise>
	</c:choose>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	
<!-- 	<a href="board/boardList">boardList</a><br>
	<a href="bcrypt">BCrypt</a>&nbsp;&nbsp;
	<a href="board/bPageList">BPage</a>&nbsp;&nbsp; -->
	<a href="member/mPageList">MPage</a><br>
	<a href="/axtestform">AjaxTest</a>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	
	<a href="/ginsert">🌙G Insert🌙</a>&nbsp;
	<a href="/gupdate">🌙G Update🌙</a>&nbsp;&nbsp;
	<a href="/glist">🌙G List🌙</a>&nbsp;
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<a href="/tsave">⭐T Save⭐</a>&nbsp;&nbsp;
	<a href="/tupdate">⭐T Update⭐</a>&nbsp;&nbsp;	
	<a href="/tdupupdate">⭐T DupUpdate⭐</a>&nbsp;&nbsp;	
	<a href="/tcalc">⭐T Calc⭐</a>&nbsp;&nbsp;	
	<a href="/tlist">⭐T List⭐</a>&nbsp;&nbsp;	
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<a href="/gpage?crrentPageNumber=1">☀️G 1Page☀️</a>&nbsp;&nbsp;
	<a href="/gpage?crrentPageNumber=2">☀️G 2Page☀️</a>&nbsp;&nbsp;
	<a href="/gpage?crrentPageNumber=3">☀️G 3Page☀️</a>&nbsp;&nbsp;
	<a href="/gpage?crrentPageNumber=4">☀️G 4Page☀️</a>&nbsp;&nbsp;
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
		<a href="/product/c1">☀️product 1Page☀️</a>&nbsp;&nbsp;
		
		<c:if test="${not empty requestScope.code}">
		<table>
		<tr>
			<th>main_type</th>
			<th>main_type_name</th>
			<th>sub_type</th>
			<th>sub_type_name</th>
		</tr>
		<c:forEach var="c" items="${requestScope.code}">
		<tr>
			<td>${c.main_type}</td>
			<td>${c.main_type_name}</td>
			<td>${c.sub_type}</td>
			<td><a href="/products/cate/${c.sub_type}">${c.sub_type_name}</a></td>
		</tr>		
		</c:forEach>
		</table>
		</c:if>
	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
</body>
</html>