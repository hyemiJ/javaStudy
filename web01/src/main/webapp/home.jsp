<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** home JSP **</title>
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
<h1 >hello web01 !</h1>
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
<!-- ** 경로표기 
     => 절대경로: / 로시작, 프로젝트명부터 전체경로 표기
         ->  /web01/images/letsgo.png
         ->  webapp 폴더는 생략됨  
     => 상대경로: 현재위치에서 시작, / 로시작하면 안됨
         -> ./ : 현재위치, ../1단계 상위    
         ->     "./images/letsgo.png", "images/letsgo.png" 동일
 -->

<%--  <% if(session.getAttribute("loginName")!=null){%>
	 <%= session.getAttribute("loginName")%> 님 안녕하세요 !
<% }%> --%>
<c:if test="${not empty sessionScope.loginName}">
${sessionScope.loginName} 님 안녕하세요 !</c:if>


<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
<img alt="mainImage" src="./images/summersea.jpg" width="400" height="300" margin="auto" >
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
<!-- =======================c : choose 활용===========================  -->
<c:choose>
<c:when test="${empty sessionScope.loginName}">
<a href = "/web01/servletTestForm/flowEx04_LoginForm.jsp">Login</a>&nbsp;
</c:when>
<c:otherwise><a href = "/web01/myinfo">myInfo</a>&nbsp;<a href = "/web01/logout">Logout</a></c:otherwise>
</c:choose>

<!-- =======================c : if 활용===============================  -->
<%-- <c:if test="${empty sessionScope.loginName}">
<a href = "/web01/servletTestForm/flowEx04_LoginForm.jsp">Login</a>&nbsp;
</c:if>
<c:if test="${not empty sessionScope.loginName}">
&nbsp;<a href = "/web01/logout">Logout</a>
</c:if> --%>

<!-- =======================자바 코드활용=============================  -->
<%-- <%if(session.getAttribute("loginName")==null){ %>
<a href = "/web01/servletTestForm/flowEx04_LoginForm.jsp">Login</a>&nbsp;
<%}else{ %>
&nbsp;<a href = "/web01/logout">Logout</a>
<%} %> --%>
<br><a href = "/web01/slist">Student List1</a>
&nbsp;<a href = "/web01/slist2">Student List2</a>
<br>
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
<div width="500" margin="auto" display= "inline-block" >
&nbsp;<a href = "/web01/hello">hello</a>&nbsp;
&nbsp;<a href = "/web01/lcycle">Life Cycle</a><br>
&nbsp;<a href = "/web01/rinfo">Request Information</a><br>
&nbsp;<a href = "/web01/sinfo">Session Information</a><br>
&nbsp;<a href = "/web01/flow">flow</a><br>
&nbsp;<a href = "/web01/01set">setAttribute</a>
&nbsp;<a href = "/web01/02get">getAttribute</a><br>
</div>
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
<div width="500" margin="auto" display= "inline-block">
&nbsp;<a href = "/web01/servletTestForm/getPost_Ex03.html">GetPost</a><br>
&nbsp;<a href = "/web01/servletTestForm/form01_Adder.html">Adder</a>&nbsp;
&nbsp;<a href = "/web01/servletTestForm/form02_Radio.jsp">Radio</a>&nbsp;
&nbsp;<a href = "/web01/servletTestForm/form03_Check.jsp">Check</a>&nbsp;
&nbsp;<a href = "/web01/servletTestForm/form04_Select.jsp">Select</a>&nbsp;
</div>
</body>
</html>