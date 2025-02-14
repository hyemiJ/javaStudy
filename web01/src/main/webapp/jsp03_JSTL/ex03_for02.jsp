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
<title>** JSTL forEach begin, end, step Test **</title>
</head>
<body>
<h2>🐻 JSTL forEach begin, end, step Test 🐻</h2>
<pre>
▪️ 구간반복: StartIndex(begin), LastIndex(end), 증감값(step) 적용하기
▪️ step 의 default 값은 1
<hr>
▪️ 실습 1)
   1 ~ 10 까지를 다음처럼 출력하세요 ~~
   -> 1, 2, 3, .....10         
   -> java의 예 : for (int i=1; i<11; i++) { ......  }    
➡️ 결과
</pre>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="vs">
${i} ${vs.last ? "" : ", "}
</c:forEach>

<hr>
<pre>
=> 실습 2)
   1 ~ 10 중에서 짝수만, index, count 출력하기
   단, table 을 이용해서 출력하세요 ~~
   ex03_for01 의 table 과 비교해 보세요 ~~     
=> count : 반복횟수 
=> index : 배열등 index가 존재하는 경우에는 index 값을 출력
           반복자(iterator) 의 값   
           step 을 지정하지 않으면 1씩 증가     
</pre>
➡️ 결과 1 : step : 1 , begin : 1 인 경우<br>
<table border="1" style="text-align: center; width: 100%;">
<tr>
<th style="color:blue;">짝수만</th>
<th style="color:blue;">index</th>
<th style="color:blue;">count</th>
</tr>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="vs">
<c:if test="${i%2==0}">
<tr>
<td>${i}</td>
<td>${vs.index}</td>
<td>${vs.count}</td>
</tr>
</c:if>
</c:forEach>
</table>
<br>
➡️ 결과 2 : step : 2 , begin : 2 인 경우<br>
<table border="1" style="text-align: center; width: 100%;">
<tr>
<th style="color:blue;">짝수만</th>
<th style="color:blue;">index</th>
<th style="color:blue;">count</th>
</tr>
<c:forEach var="i" begin="2" end="10" step="2" varStatus="vs">
<tr>
<td>${i}</td>
<td>${vs.index}</td>
<td>${vs.count}</td>
</tr>
</c:forEach>
</table>

<hr>
<pre>
=> 실습 3) 1~30 을 다음처럼 1행에 5개씩 출력하세요~
</pre>
<!-- 
1,2,3,4,5
6,7,8,9,10
11,12,13,14,15
...
............30 -->
<span class="red"> test 1 : for + for</span>
<table border="1" style="text-align: center; width: 100%;">
<c:forEach var="i" begin="1" end="30" step="5" varStatus="vs">
<tr>
<c:forEach var="j" begin="${i}" end="${i+4}" step="1" varStatus="vas">
<td>${j}</td>
</c:forEach>
</tr>
</c:forEach>
</table>

<hr>
<span class="red"> test 2 : for + if</span>
<table border="1" style="text-align: center; width: 100%;">
<tr>
<c:forEach var="i" begin="1" end="30" step="1">
<td>${i}</td> <c:if test="${i%5==0}"></tr><tr></c:if>
</c:forEach>
</tr>
</table>
</body>
</html>