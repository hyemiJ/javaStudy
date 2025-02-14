<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${code}</title>
<style type="text/css">
@font-face {
	font-family: 'GangwonEdu_OTFBoldA';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	background-color: Lavenderblush;
	text-align: center; /* 텍스트 중앙 정렬 */
	font-family: 'GangwonEdu_OTFBoldA';
	font-size: 20px;
}

.red {
	color: red;
	font-size: 22px;
}

pre {
	font-family: 'GangwonEdu_OTFBoldA';
}

a {
    display: inline-block;
    text-decoration: none;
}
a:hover { 
    color:Olivedrab !important; 
    font-size: 1.5em !important; 
    font-weight : bold;
    cursor: pointer !important; 
    }
</style>
</head>
<body>

<c:if test="${not empty requestScope.apple}">
<table style="margin:auto;">
	<tr>
		<th>상품id</th>
		<th>상품 name</th>
		<th>상품 price</th>
		<th>상품 stockCount</th>
		<th>상품 uploadDate</th>
		<th>상품 like_conut</th>
		
	</tr>
	
	
	<tr >
		<th>${apple.id}</th>
		<th>${apple.name}</th>
		<th>${apple.price}</th>
		<th>${apple.stock_count}</th>
		<th>${apple.uploadDate}</th>
		<th>${apple.like_conut}</th>
	</tr>



</table>
<ul>
  <li> ${apple.size_info} </li>
  <li> ${apple.guide} </li>
  <li> ${apple.main_description} </li>
  <li>${apple.sub_description}</li>
</ul>
</c:if>

<c:if test="${not empty apple.options}">
<div>
<select>
<c:forEach var="o" items="${apple.options}">

<option>${o.content} : ${o.price} </option>

</c:forEach>
</select>
</div>
</c:if>
<a href="/">home</a>
</body>
</html>