<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL LOOP (forEach) test01</title>
<style type="text/css">
@font-face {
    font-family: 'MaruBuri';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriSemiBold';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriBold';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriLight';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriExtraLight';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.ttf) format("truetype");
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

pre {
	font-family: 'MaruBuri';
}
</style>
</head>
<body>
	<h2>🐻 JSTL LOOP (forEach) test01 🐻</h2>
	<hr>
	<pre>
1) forEach 기본형식
▪️Java 의 forEach 와 유사
    for (String s:students) {  out.print(s); }
 2) varStatus 속성 활용
▪️ index, count, first, last     

3) varStatus 속성 연습
▪️ first, last : boolean Type
▪️ for, if(또는 choose) 구문 모두 중첩 가능 
▪️ 과제
    . first 는 굵은 파랑으로 출력
    . ul li 를 이용해서 출력하면서 menu 뒤에 ',' 표시
    . 단, 마지막에는 마침표를 표시하세요 ~~ 
➡️ 결과
</pre>
	<%
	String[] menu = { "미트볼야채볶음", "삼치김치조림", "돈까스", "간장찜닭", "고추잡채" };
	pageContext.setAttribute("menuList", menu);
	%>

	<pre>
Test 1) forEach 기본형식
</pre>
	<c:forEach var="menu" items="${menuList}">
		<span class="red">${menu} &nbsp;</span>
	</c:forEach>
	<pre>
Test 2) varStatus 속성 활용
</pre>
	<table border="1" style="text-align: center; width: 100%;">
		<tr>
			<th>menu</th>
			<th style="color:red;">index</th>
			<th style="color:blue;">count</th>
			<th style="color:red;">first</th>
			<th style="color:blue;">last</th>
		</tr>
		<c:forEach var="menu" items="${menuList}" varStatus="vs">
			<tr>
			<td>${menu}</td>
			<td style="color:red;">${vs.index}</td>
			<td style="color:blue;">${vs.count}</td>
			<td style="color:red;">${vs.first}</td>
			<td style="color:blue;">${vs.last}</td>
			</tr>
		</c:forEach>
	</table>
	<pre>
Test 3) 과제
▪️ 과제
    . first 는 굵은 파랑으로 출력
    . ul li 를 이용해서 출력하면서 menu 뒤에 ',' 표시
    . 단, 마지막에는 마침표를 표시하세요 ~~ 
</pre>
<ul>
<c:forEach var="menu" varStatus="vs" items="${menuList}">

<c:choose>
<c:when test="${vs.first}">
<li style="font-weight:800; color:blue;">${menu} ,</li>
</c:when>
<c:when test="${(!vs.first &&!vs.last)}">
<li>${menu} ,
</c:when>
<c:otherwise>
<li>${menu} .
</c:otherwise>
</c:choose>
</li>
</c:forEach>
</ul>

</body>
</html>