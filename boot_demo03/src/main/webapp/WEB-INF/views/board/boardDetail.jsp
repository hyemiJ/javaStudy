<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
@font-face {
	font-family: 'MaruBuri';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriSemiBold';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriBold';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriLight';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriExtraLight';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.ttf)
		format("truetype");
}

body {
	background-color: Lavenderblush;
	text-align: center; /* 텍스트 중앙 정렬 */
	font-family: 'MaruBuri';
	font-size: 20px;
}

.red {
	color: red;
	font-size: 22px;
}

table {
	margin: auto;
}

pre {
	font-family: 'MaruBuri';
}
</style>
<title>board test</title>
</head>
<body>
	<h2>🐻 board apple🐻</h2>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<c:if test="${!empty requestScope.message}">${requestScope.message}
	<hr
			style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	</c:if>
	<h1>🐶🐶🐶🐶🐶🐶작작해!!!!🐶새꺄 tlqkf🐶🐶🐶🐶🐶</h1>
	<table>
		<tr bgcolor="khaki">
			<th>🐇Seq(게시번호)</th>
			<th>🐇title(제목)</th>
			<th>🐇id(글쓴이)</th>
			<th>🐇regDate(게시날짜)</th>
			<th>🐇cnt(조회수)</th>
			<th>🐇root(부모글번호)</th>
			<th>🐇step(증가)</th>
			<th>🐇indent(부모증가)</th>
		</tr>

			<c:set var="b" value="${requestScope.apple}" />
		<c:if test="${!empty requestScope.apple}">
			<tr>
				<td>${b.seq}</td>
				<td>${b.title}</td>
				<td>${b.id}</td>
				<td>${b.regdate}</td>
				<td>${b.cnt}</td>
				<td>${b.root}</td>
				<td>${b.step}</td>
				<td>${b.indent}</td>
			</tr>
			<tr>
				<td colspan="5" style="border-top: 1px solid">${b.content}</td>
			</tr>

		</c:if>
		<c:if test="${empty requestScope.apple}">
		출력할 자료가 없습니다</c:if>
	</table>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<!-- 로그인유저 접근 권한 답글 : 부모글의 root ,step , indent 값이 필요하기 때문에 쿼리스트링으로.-->
	<c:if test="${!empty sessionScope.loginID}">
		<a href="boardInsert">[새글 등록]</a>&nbsp;&nbsp;
		<a href="replyInsert?root=${b.root}&step=${b.step}&indent=${b.indent}">[답글 등록]</a>
		<hr
			style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	</c:if>

	<!-- 해당유저 접근 권한 -->
	<c:if test="${b.id==sessionScope.loginID}">
		<a href="detail?jCode=U&seq=${b.seq}">[수정하기]</a>&nbsp;&nbsp;
	<a href="delete?seq=${b.seq}&root=${b.root}">[삭제하기]</a>
	</c:if>
	&nbsp;
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	&nbsp;
	<a href="/home">HOME</a>&nbsp; &nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>
</body>
</html>