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

pre {
	font-family: 'MaruBuri';
}
</style>
<title>** my Info **</title>
</head>
<body>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄
	<h2>🐻 my Info 🐻</h2>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width:700px;">

	<c:set value="${requestScope.apple}" var="m" />
	<c:if test="${not empty m}">
		<ul style="list-style:none;">${m.name}
			<li>\${m.id} 학생번호 = <span class="red"> ${m.id}</span></li>
			<li>\${m.password} 학생번호 = <span class="red"> ${m.password}</span></li>
			<li>\${m.age} 나이 = <span class="red"> ${m.age}</span></li>
			<li>\${m.jno} 조번호 = <span class="red"> ${m.jno}</span></li>
			<li>\${m.info} 자기소개 = <span class="red"> ${m.info}</span></li>
			<li>\${m.point} 점수 = <span class="red"> ${m.point}</span></li>
			<li>\${m.birthday} 생일 = <span class="red"> ${m.birthday}</span></li>
			<li>\${m.rid} 짝꿍 = <span class="red"> ${m.rid}</span></li>
		</ul>
	</c:if>
	<c:if test="${empty m}">출력할 정보가 없습니다.</c:if>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width:700px;">
	<div>
		<a href="/home">home</a> <a href="javascript:history.go(-1)">
			back</a>
	</div> 
</body>
</html>