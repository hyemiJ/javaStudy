<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🐥 AjaxTest Main Form 🐥</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="/resources/myLib/axTest01.js" ></script>
<script src="/resources/myLib/axTest02.js" ></script>
<script src="/resources/myLib/axTest03.js" ></script> 
</head>
<body>
<h2>🐳 AjaxTest Main Form 🦭</h2>
<c:if test="${not empty sessionScope.loginID}">
<hr>
	=> ${sessionScope.loginName}님 안녕하세요 ~~<br> 
</c:if>
<c:if test="${not empty requestScope.message}">
	=> ${requestScope.message}<br>
</c:if>
<hr>
&nbsp;<span class="textlink" onclick="rsLoginf()">🦭rsLogin🦭</span>&nbsp;
&nbsp;<span class="textlink" onclick="rsJoinf()">🦥rsJoin🦥</span>&nbsp;
&nbsp;<span class="textlink" onclick="axiMList()">🦖axiMList🦖</span>&nbsp;
&nbsp;<span class="textlink" onclick="axiMListCri('axmcri')">🐢axiMListCri🐢</span>&nbsp;	
&nbsp;<a href="/home">[Home]</a>  
<hr>
<div id="resultArea1"></div>
<div id="resultArea2"></div>
</body>
</html>