<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>** Format(fmt) Test **</title>
</head>
<body>

	<h2>🐻 Format(fmt) Test🐻</h2>
	<pre>
➡️ 현재 날짜 시간 가져오기
    Java : Date now = new Date()
    <c:set var="now" value="<%=new Date()%>"></c:set>
    * now : <span class="red">${now}</span>
    <hr style="background-color:green;">
1. DateTime Test
	*date(type : 지정X) : <span class="red"><fmt:formatDate value="${now}"/></span>
    *date(type : date) : <span class="red"><fmt:formatDate value="${now}" type="date"/></span>
    *date(type : time) : <span class="red"><fmt:formatDate value="${now}" type="time"/></span>
    *date(type : both) :  <span class="red"><fmt:formatDate value="${now}" type="both"/></span>
    <hr>
    *both,default :  <span class="red"><fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default"/></span>
    *both,short :  <span class="red"><fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/></span>
    *both,medium :  <span class="red"><fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/></span>
    *both,long :  <span class="red"><fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/></span>
    *both,full :  <span class="red"><fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/></span>
    
* Pattern (yyyy년 MM월 dd일 hh시 mm분 ss초) 적용
➡️ *pattern : <span class="red"><fmt:formatDate value="${now}" type="both" pattern="yyyy년 mm월 dd일 hh시 mm분 ss초"/></span>

* 각 나라별 시간을 적용하려면 
➡️ fmt:setTimeZone, fmt:timeZone 태그 활용

2. Number Format
➡️ 숫자정의
<c:set var="mymoney" value="1234567890"></c:set>
* pattern="000,000,000,000" 적용
➡️<span class="red"> <fmt:formatNumber value="${mymoney}" pattern="000,000,000,000"/></span>$
➡️<span class="red"> <fmt:formatNumber value="${mymoney}" pattern="000,000"/></span>$
* pattern="###,###,###,###" 적용
➡️<span class="red"> <fmt:formatNumber value="${mymoney}" pattern="###,###,###,###"/></span>원
➡️<span class="red"> <fmt:formatNumber value="${mymoney}" pattern="###,###"/></span>원


</pre>

</body>
</html>