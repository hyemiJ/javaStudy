<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL if ,choose의 조건 분기 Main Test **</title>
<style type="text/css">
@font-face {
    font-family: 'GangwonEdu_OTFBoldA';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

body {
    background-color: Lavenderblush;
    text-align: center; /* 텍스트 중앙 정렬 */
    font-family: 'GangwonEdu_OTFBoldA';
    font-size: 20px;
}
.red{
color : red;
font-size: 22px;
}
pre {
    font-family: 'GangwonEdu_OTFBoldA';
}
</style>
</head>
<body>
<h2>🐻 JSTL if ,choose(태그)의 조건 분기 Main Test 🐻</h2>

<pre>
1) if c:if
▪️ test 속성에 EL Tag를 사용하여 조건지정.
▪️else 구문 태그가 없음으로 if 로 처리해야함.

2) choose
▪️if 문에 else 구문 태그가 없음을 보완하여 나옴.
▪️JAVA 의 switch ~ case 구문과 같다.

3) 특징
▪️test 속성에 EL tag를 사용하여 조건 지정.
▪️EL 관계식을 활용함.
▪️모든 type 에 대해서 "==" 이  사용 가능함.
</pre>
<hr>
<pre>
1) JAVA 코드 사용한다면 ?
</pre>
<% String color = request.getParameter("color");
if(color.equals("1")){%>
	<span style="color:red;">Red 선택</span>
<%}else if(color.equals("2")){%>
<span style="color:green;">Green 선택</span>
<%}else if(color.equals("3")){%>
<span style="color:blue;">Blue 선택</span>
<%}else if(color.equals("4")){%>
<span style="color:yellow;">yellow 선택</span>
<%}else {%>
<span style="color:purple;">color 선택 오류</span>
<%}%>
<pre>
2) c : if Tag
</pre>
<c:if test="${param.color==1}"><span style="color:red;">Red 선택</span></c:if>
<c:if test="${param.color==2}"><span style="color:green;">Green 선택</span></c:if>
<c:if test="${param.color==3}"><span style="color:blue;">Blue 선택</span></c:if>
<c:if test="${param.color==4}"><span style="color:yellow;">yellow 선택</span></c:if>
<c:if test="${param.color==5 || empty param.color}"><span style="color:purple;">color 선택 오류</span></c:if>
<pre>
3) c: choose Tag
</pre>
<c:choose>
<c:when test="${param.color==1}"><span style="color:red;">Red 선택</span></c:when>
<c:when test="${param.color==2}"><span style="color:green;">Green 선택</span></c:when>
<c:when test="${param.color==3}"><span style="color:blue;">Blue 선택</span></c:when>
<c:when test="${param.color==4}"><span style="color:yellow;">yellow 선택</span></c:when>
<c:otherwise><span style="color:purple;">color 선택 오류</span></c:otherwise>
</c:choose>
</body>
</html>