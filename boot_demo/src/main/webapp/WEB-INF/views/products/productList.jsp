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
<h2>productC : ${code}</h2>
<c:if test="${not empty requestScope.banana}">
<table style="margin:auto;">
	<tr>
		<th>상품id</th>
		<th>상품 name</th>
		<th>상품 price</th>
		<th>상품 stockCount</th>
	</tr>
	
	<c:forEach var="p" items="${requestScope.banana}">
	<tr >
		<th>${p.id}</th>
		<th><a href="/products/cate/${p.categoryId}/${p.id}">${p.name}</a></th>
		<th>${p.price}</th>
		<th>${p.stock_count}</th>
	</tr>
	</c:forEach>

</table>
</c:if>
</body>
</html>