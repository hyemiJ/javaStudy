<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>🐻forTokens , PageFlow (import, redirect)🐻</title>
</head>
<body>
<h2>1. forTokens</h2>
<pre>
➡️ 구분자로 분리된 각각의 토큰을 처리할때 사용됨.
</pre>
➡️ test 1.1) 단일 구분자 <br>
<c:forTokens var="city" items="성남,용인,서울# 부산,Paris , NewYork" delims=",">
${city} ,
</c:forTokens><br>
➡️ test 1.2) 복수 구분자 <br>
<c:forTokens var="city" items="성남 ! 용인,서울# 부산 Paris , NewYork" delims=", #!">
${city} ,
</c:forTokens><br>

<hr>
<h2>2. import</h2>
<pre>
➡️ directive: include -> 소스코드포함, 변수공유가능
➡️ jsp:include -> 웹Page포함, 변수공유 불가능
➡️ jstl:import -> 웹Page포함, 변수공유 불가능
</pre>
<%-- <hr>
➡️ jstl:import -> 웹Page포함, 변수공유 불가능
<c:import url="ex02_ifForm.jsp"></c:import> --%>

<hr>
<h2>3. redirect</h2>
<pre>
➡️ response.sendRedirect() 와 동일
➡️ 웹브라우져의 주소창의 url 이 변경됨
</pre>
<%-- ➡️ jstl:redirect -> 웹Page이동 . response.sendRedirect(); 와 동일
<c:redirect url="/jsp01/ex01_HelloJSP.jsp" ></c:redirect> --%>


<hr>
<h2>4. url</h2>
<pre>
➡️ Value 를 url로 인식 시켜줌_set 으로 정의해도 결과는 동일
➡️ test 4.1) a_Tag Link
    -> c:url 과 c:set 의 경로값 처리 방법이 다름
    
</pre>
<c:url var="urltest" value="/jsp01/ex01_HelloJSP.jsp"/><br>
<a href="${urltest}">urltest</a><br>
<c:set var="urltest" value="/web01/jsp01/ex02_MVC01List.jsp"/><br>
<a href="${urltest}">urltest</a><br>
➡️ test 4.2) image<br>
<c:url var="aaa" value="../images/aaa.gif"/>
<img alt="urltest" src="${aaa}">



</body>
</html>