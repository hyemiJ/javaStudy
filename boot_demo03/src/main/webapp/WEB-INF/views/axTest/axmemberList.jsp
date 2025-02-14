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
.reletive{
	position: relative;
}
.absolute{
	position: absolute;
	background-color:white;
	border: 1px solid khaki;
}
</style>
<title>** MVC2 List **</title>
</head>
<body>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄
	<h2>🐻 member List axious 🐻</h2>
	▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄

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
			<th>Image</th>
			<th>delete</th>
		</tr>
		<c:if test="${not empty requestScope.banana}">

			<c:set value="${requestScope.banana}" var="banana"/>
			<c:forEach var="m" items="${banana}">
				<tr >
					<!--id 별 boardList 
						선택된 id를 function에 전달. ->매개 변수를 활용 
						->idbList('banana') -> ok -> banana 라는 문자열로 찾게됨.
						->idbList(banana) -> Error -> banana 라는 변수를 찾게됨.
						a Tag 에 Event를 적용시 , 내부링크(책갈피) 기능을 활용 
						-> href : 적용하지않음 (이동하지 않음)
            			-> href="#id" : id 위치로 이동,  "#": 최상단으로 이동 
           				-> href="javascript:;" : 이동하지 않음  
						-->
					<td><a href="#resultArea2" onclick="idbList(event,'${m.id}')"> ${m.id}</a></td>
					<td>${m.name}</td>
					<td>${m.age}</td>
					<td  onmouseenter="jnoEnter(event,'${m.jno}')"
						onmouseout="jnoOut(event,'${m.jno}')"><span class="textlink" >${m.jno}</span></td>
					<td>${m.info}</td>
					<td>${m.point}</td>
					<td>${m.birthday}</td>
					<td>${m.rid}</td>
					<td><img alt="myImge" src="/resources/uploadImages/${m.uploadfile}"
					width="50" height="70"></td>
					        <!--  ** Delete 기능 추가 
						            => 선택된 id를 function 에 전달 (매개변수를 활용)
						            => 결과는 성공/실패 여부만 전달: RESTController 로 
						            => 성공 : Deleted 로 변경, onclick 이벤트 해제 
						                     이를 위해 Delete Tag 를 function 에서 인식할수있어야함. 
						                     
						            ** function 에 이벤트객체 전달
						            => 이벤트핸들러의 첫번째 매개변수에 event 라는 이름으로 전달함.
						             => a Tag 와 span 사용시 e.target 값 비교
						                 -> a Tag : "javascript:;" 
						                 -> span  : [object HTMLSpanElement]          
        						-->
					<td><span class="textlink" onclick="axiDelte(event,'${m.id}')" id="${m.id}">Delete</span></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${ empty requestScope.banana}">
		<tr>출력할 자료가 없습니다.</tr>
		</c:if>

	</table>

<div>
<a href="/home">home</a>
<a href="javascript:history.go(-1)"> back</a>
</div>

</body>
</html>