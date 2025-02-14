<%@page import="java.util.List"%>
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
<script src="/resources/myLib/axTest03.js" ></script> 
<title>**Axios member List Search **</title>
	

</head>
<body>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄
	<h2>🐻 Axios Member List / search 🐻</h2>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄
<!-- 
** 검색 & 페이징 포함한 요청의 Ajax 처리
=> Ajax 요청 function 작성, url 을 매개변수로 전달 : axiMListCri(url) 
=> Page 요청 : aTag -> span 으로 변경하고 function 으로 처리 
=> Check 검색은 submit 을 사용하기 때문에 적용하지 않음(주석처리)

=> Ajax 처리시에는 문서내부의 function이 인식 안되므로
   searchDB(), keywordClear(), checkClear() 모두 axTest03.js 에 작성   
-->
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
	<div id="searchBar">
		<select name="searchType" id="searchType" onchange="keywordClear()">
			<option value="all" ${pageMaker.cri.searchType=='all' ? 'selected':''}>🗨️ 전체 🗨️</option>
			<option value="id" ${pageMaker.cri.searchType=='id' ? 'selected':''}>🐻 ID 🐻</option>
			<option value="name" ${pageMaker.cri.searchType=='name' ? 'selected':''}>🧁 NAME 🧁</option>
			<option value="age" ${pageMaker.cri.searchType=='age' ? 'selected':''}>💛 AGE 💛</option>
			<option value="birthday" ${pageMaker.cri.searchType=='birthday' ? 'selected':''}>🌙 BIRTHDAY 🌙</option>
			<option value="info" ${pageMaker.cri.searchType=='info' ? 'selected':''}>🧸 INFO 🧸</option>
		</select> 
		<input type="text" name="keyword" id="keyword"
			value="${pageMaker.cri.keyword}" onkeydown="push(event)">
		<button id="searchBtn" onclick="searchDB()">📁 Search 📁</button>
		<hr>
		<form action="mCheckList" method="get">
			<b>🍕 ID : </b>
			<c:set var="ck1" value="false" />
			<c:set var="ck2" value="false" />
			<c:set var="ck3" value="false" />
			<c:set var="ck4" value="false" />
			<c:set var="ck5" value="false" />
			<c:forEach var="jno" items="${pageMaker.cri.check}">
				<c:if test="${jno =='1'}">
					<c:set var="ck1" value="true" />
				</c:if>
				<c:if test="${jno =='2'}">
					<c:set var="ck2" value="true" />
				</c:if>
				<c:if test="${jno =='3'}">
					<c:set var="ck3" value="true" />
				</c:if>
				<c:if test="${jno =='4'}">
					<c:set var="ck4" value="true" />
				</c:if>
				<c:if test="${jno =='7'}">
					<c:set var="ck5" value="true" />
				</c:if>
			</c:forEach>

			<input type="checkbox" id="1" class="check clear" value="1" ${ck1 ? 'checked' : ''}> 
			<label for="1">우린팀</label>
			&nbsp; 
			<input type="checkbox" id="2" class="check clear" value="2" ${ck2 ? 'checked' : ''}> 
			<label for="2">모꼬지🍎</label>
			&nbsp; 
			<input type="checkbox" id="3" class="check clear" value="3" ${ck3 ? 'checked' : ''}> 
			<label for="3">OOC🍌</label>
			&nbsp; 
			<input type="checkbox" id="4"	class="check clear" value="4" ${ck4 ? 'checked' : ''}> 
			<label for="4">컴포난트🍏</label> 
			&nbsp; 
			<input type="checkbox" id="7" class="check clear" value="7" ${ck5 ? 'checked' : ''}> 
			<label for="7">test🍓</label>
			&nbsp;&nbsp; 
			<!-- axios 적용을 위한 submit 을 button으로 변경.  -->
			<button type="button" onclick="axiMListCheck()">check검색</button>&nbsp; 
			<input type="reset" value="clear" onclick="return checkClear()"> 
		</form>
	</div>
<hr style="border-width:1px 0 0 0; border-style:dashed; border-color:deepskyblue;">
	<table border="1" style="width: 100%; border-color: blue;">
		<tr bgcolor="yellow">
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Jno</th>
			<th>Info</th>
			<th>Point</th>
			<th>Birhday</th>
			<th>Rid</th>
		</tr>
		<c:if test="${not empty requestScope.banana}">

			<c:set value="${requestScope.banana}" var="banana"/>
			<c:forEach var="m" items="${banana}">
				<tr>
					<td>${m.id}</td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td>${m.jno}</td>
					<td>${m.info}</td>
					<td>${m.point}</td>
					<td>${m.birthday}</td>
					<td>${m.rid}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${ empty requestScope.banana}">
		<tr>출력할 자료가 없습니다.</tr>
		</c:if>

	</table>
	<hr
		style="border-width: 1px 0 0 0; border-style: dashed; border-color: deepskyblue; width: 700px;">
	<div align="center">
		<!-- 1) FirstPage, hasPreviousPageBlock  -->
		<c:choose>
			<c:when
				test="${pageMaker.hasPreviousPageBlock && pageMaker.startPageNumber>1}">
	
				<span class="textlink" onclick="axiMListCri('${pageMaker.makeQuery(1)}')">FP</span>&nbsp;
				<span class="textlink" onclick="axiMListCri('${pageMaker.makeQuery(pageMaker.startPageNumber-1)}')">&LT;</span>&nbsp;&nbsp;  
				<%-- <a href="${pageMaker.makeQuery(1)}">&LT;&LT;</a>&nbsp; --%>
				<%-- <a href="${pageMaker.makeQuery(pageMaker.startPageNumber-1)}">&LT;</a>&nbsp;&nbsp;   --%>
			</c:when>
			<c:otherwise>
				<font color="Gray">FP&nbsp;&LT;&nbsp;&nbsp;</font>
			</c:otherwise>
		</c:choose>
		<!-- 2) Display PagendRowNumber 
	=> currentPage 제외한 PagendRowNumber 만 a Tag 적용 -->
		<c:forEach var="i" begin="${pageMaker.startPageNumber}"
			end="${pageMaker.endPageNumber}">
			<c:if test="${i==pageMaker.cri.currentPage}">
				<font color="Orange" size="5"><b>${i}</b></font>&nbsp;
  	</c:if>
			<c:if test="${i!=pageMaker.cri.currentPage}">
			<span class="textlink" onclick="axiMListCri('${pageMaker.makeQuery(i)}')">${i}</span>&nbsp;
				<%-- <a href="${pageMaker.makeQuery(i)}">${i}</a>&nbsp; --%>
  	</c:if>
		</c:forEach>
		<!-- 3) hasNextPageBlock, LastPage  -->
		<c:choose>
			<c:when test="${pageMaker.hasNextPageBlock && pageMaker.endPageNumber>0}">
				&nbsp;
				<span class="textlink" onclick="axiMListCri('${pageMaker.makeQuery(pageMaker.endPageNumber+1)}')">&GT;</span>
				&nbsp;
				<span class="textlink" onclick="axiMListCri('${pageMaker.makeQuery(pageMaker.lastPageNumber)}')">LP</span>&nbsp;&nbsp;  
  		<%-- &nbsp;<a href="${pageMaker.makeQuery(pageMaker.endPageNumber+1)}">
					&GT;</a>
  		&nbsp;<a href="${pageMaker.makeQuery(pageMaker.lastPageNumber)}">&GT;&GT;</a> --%>
			</c:when>
			<c:otherwise>
				<font color="Gray">&nbsp;&GT;&nbsp;LP</font>
			</c:otherwise>
		</c:choose>
	</div>


<div>
<a href="/home">home</a>
<a href="javascript:history.go(-1)"> back</a>
</div>

</body>
</html>