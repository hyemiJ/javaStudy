<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_Boot Mybatis BoardPageList **</title>
<link rel="stylesheet" type="text/css"
	href="/resources/myLib/myStyle.css">
	
<script>
"use strict"


function keywordClear() {
	if (document.getElementById("searchType").value == 'all') {
			document.getElementById("keyword").value = "";
		}
	}//keywordClear

	function searchDB() {
		self.location = 'bPageList' + '?currentPage=1&rowsPerPageCount=5'
				+ '&searchType=' + document.getElementById("searchType").value
				+ '&keyword=' + document.getElementById("keyword").value;
	}

	function push(event) {
		if (event.key === 'Enter') {
			searchDB();
		}
	}

	function checkClear() {
		let ck = document.querySelectorAll('.clear');
		for (let i = 0; i < ck.length; i++) {
			ck[i].checked = false;
		}
		return false;
	}
</script>
</head>
<body>
	<h2>** Spring_Boot Mybatis BoardPageList **</h2>
	<hr>
	<c:if test="${!empty requestScope.message}">
 ${requestScope.message}<br>
		<hr>
	</c:if>
	<div id="searchBar">
		<select name="searchType" id="searchType" onchange="keywordClear()">
			<option value="all"
				${pageMaker.cri.searchType=='all' ? 'selected':''}>🗨️ 전체
				🗨️</option>
			<option value="title"
				${pageMaker.cri.searchType=='title' ? 'selected':''}>🐻 제목
				🐻</option>
			<option value="content"
				${pageMaker.cri.searchType=='content' ? 'selected':''}>🧁
				내용 🧁</option>
			<option value="id" ${pageMaker.cri.searchType=='id' ? 'selected':''}>💛
				글쓴이 💛</option>
			<option value="regdate"
				${pageMaker.cri.searchType=='regdate' ? 'selected':''}>🌙
				날짜 🌙</option>
			<option value="tc" ${pageMaker.cri.searchType=='tc' ? 'selected':''}>🧸
				제목+내용 🧸</option>
		</select> 
		<input type="text" name="keyword" id="keyword"
			value="${pageMaker.cri.keyword}" onkeydown="checkEnter(event)">
		<button id="searchBtn" onclick="searchDB()">📁 Search 📁</button>
		<hr>
		<form action="bCheckList" method="get">
			<b>🍕 ID : </b>
			<c:set var="ck1" value="false" />
			<c:set var="ck2" value="false" />
			<c:set var="ck3" value="false" />
			<c:set var="ck4" value="false" />
			<c:set var="ck5" value="false" />
			<c:forEach var="id" items="${pageMaker.cri.check}">
				<c:if test="${id =='admin'}">
					<c:set var="ck1" value="true" />
				</c:if>
				<c:if test="${id =='apple'}">
					<c:set var="ck2" value="true" />
				</c:if>
				<c:if test="${id =='banana'}">
					<c:set var="ck3" value="true" />
				</c:if>
				<c:if test="${id =='hyemi1110'}">
					<c:set var="ck4" value="true" />
				</c:if>
				<c:if test="${id =='gydbs99'}">
					<c:set var="ck5" value="true" />
				</c:if>
			</c:forEach>

			<input type="checkbox" name="check" id="admin" class="clear" value="admin" ${ck1 ? 'checked' : ''}> 
			<label for="admin">관리자</label>
			&nbsp; 
			<input type="checkbox" name="check" id="apple" class="clear" value="apple" ${ck2 ? 'checked' : ''}> 
			<label for="apple">Apple🍎</label>
			&nbsp; 
			<input type="checkbox" name="check" id="banana" class="clear" value="banana" ${ck3 ? 'checked' : ''}> 
			<label for="banana">Banana🍌</label>
			&nbsp; 
			<input type="checkbox" name="check" id="hyemi1110"	class="clear" value="hyemi1110" ${ck4 ? 'checked' : ''}> 
			<label for="hyemi1110">hyemi1110🍏</label> 
			&nbsp; 
			<input type="checkbox" name="check" id="gydbs99" class="clear" value="gydbs99" ${ck5 ? 'checked' : ''}> 
			<label for="gydbs99">HyoYun🍓</label>
			&nbsp;&nbsp; 
			<input type="submit" value="search">&nbsp; 
			<input type="reset" value="clear" onclick="return checkClear()"> 
		</form>
	</div>

	<table style="width: 100%">
		<tr bgcolor="#7ba5f0">
			<th>Seq</th>
			<th>Title</th>
			<th>ID</th>
			<th>RegDate</th>
			<th>조회수</th>
		</tr>
		<c:if test="${!empty requestScope.banana}">
			<c:forEach var="b" items="${requestScope.banana}">
				<tr>
					<td>${b.seq}</td>
					<td>
						<!-- 답글 등록 후 Title 출력전에 들여쓰기 추가 --> <c:if test="${b.indent>0}">
							<c:forEach begin="1" end="${b.indent}">
								<span>&nbsp;&nbsp;</span>
							</c:forEach>
							<span style="color: Chocolate;"><b>re..</b></span>
						</c:if> <!-- 로그인 한 경우에만 글내용 볼 수 있도록 --> <c:if test="${!empty loginID}">
							<a href="detail?jCode=D&seq=${b.seq}">${b.title}</a>
						</c:if> <c:if test="${empty loginID}">
				${b.title}
			</c:if>
					</td>
					<td>${b.id}</td>
					<td>${b.regdate}</td>
					<td>${b.cnt}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.banana}">
			<tr>
				<td colspan="5">~~ 출력자료가 1건도 없습니다. ~~</td>
			</tr>
		</c:if>
	</table>
	<hr>
	<div align="center">
		<!-- ** Paging Block ** 
	=> ver01: QueryString 수동 입력 -> 자동생성 makeQuery 메서드 적용
	=> ver02: makeQuery 메서드 -> searchQuery 메서드로 변경
 	1) FirstPage, hasPreviousPageBlock  
 	=> OLD
 		<a href="bPageList?currentPage=1&rowsPerPageCount=5">FP</a>&nbsp;
		<a href="bPageList?currentPage=${pageMaker.startPageNumber-1}&rowsPerPageCount=5">&LT;</a>&nbsp;&nbsp; 
 	=> NEW : makeQuery 활용 
 	 -->
		<!-- 페이지 블록 이동시 마지막 첫번째  -->
		<c:choose>
			<c:when
				test="${pageMaker.hasPreviousPageBlock && pageMaker.startPageNumber>1}">
				<a href="${pageMaker.makeQuery(1)}">&LT;&LT;</a>&nbsp;
				<a href="${pageMaker.makeQuery(pageMaker.startPageNumber-1)}">&LT;</a>&nbsp;&nbsp;  
			</c:when>
			<c:otherwise>
				<font color="Gray">&LT;&LT;&nbsp;&LT;&nbsp;&nbsp;</font>
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
				<a href="${pageMaker.makeQuery(i)}">${i}</a>&nbsp;
  	</c:if>
		</c:forEach>
		<!-- 3) hasNextPageBlock, LastPage  -->
		<c:choose>
			<c:when
				test="${pageMaker.hasNextPageBlock && pageMaker.endPageNumber>0}">
  		&nbsp;<a href="${pageMaker.makeQuery(pageMaker.endPageNumber+1)}">
					&GT;</a>
  		&nbsp;<a href="${pageMaker.makeQuery(pageMaker.lastPageNumber)}">&GT;&GT;</a>
			</c:when>
			<c:otherwise>
				<font color="Gray">&nbsp;&GT;&nbsp;&GT;&GT;</font>
			</c:otherwise>
		</c:choose>
	</div>
	<hr>
	<!-- 로그인 한 경우에만 새글등록 할 수 있도록 -->
	<c:if test="${not empty sessionScope.loginID}">
	&nbsp;<a href="boardInsert">새글등록</a>&nbsp;
</c:if>
	&nbsp;
	<a href="/home">Home</a>&nbsp; &nbsp;
	<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
</body>
</html>