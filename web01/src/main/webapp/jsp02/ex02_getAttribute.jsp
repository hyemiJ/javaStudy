<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** EL Scope / Attribute**</title>
<style>
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

pre {
    font-family: 'GangwonEdu_OTFBoldA';
}
</style>
<%
//1) 동일한 속성(Attribute)명을 모든 영역에 정의
//=> 호출, 우선순위 
    pageContext.setAttribute("name", "pageContext Value1");
    request.setAttribute("name", "request Value1");
    session.setAttribute("name", "session Value1");
    application.setAttribute("name", "application Value1");
//2) 서로 다른 속성(Attribute)명을 모든 영역에 정의    
    pageContext.setAttribute("pname", "pageContext Value2");
    request.setAttribute("rname", "request Value2");
    session.setAttribute("sname", "session Value2");
    application.setAttribute("aname", "application Value2");

//3) 연산자 Test 
//=> request 영역에 속성(Attribute) 2개 만들고 활용 Test
    request.setAttribute("num1", 123);
    request.setAttribute("num2", 456);
%>


</head>
<body>
<h1>🪄 EL Scope / Attribute 🪄</h1>

<pre>
🐻 동일한 속성(Attribute)명을 모든 영역에 정의 🐻
    ✔️호출, 우선순위 
    <b>▪️ \${name} = ${name} 
    	 ▪️ 가장 가까운 범위부터 검색 (page -> request -> session -> application)
    	 ▪️ 동일한 속성명을 사용한 경우 모두 구별해서 출력하려면 , 속성명을 붙여준다. 
    	 ▪️ EL은 각 속성을 객체화 해서 제공을 해준다.
    	 ▪️ \${pageScope.name} = ${pageScope.name}
    	 ▪️ \${requestScope.name} = ${requestScope.name}
    	 ▪️ \${sessionScope.name} = ${sessionScope.name}
    	 ▪️ \${applicationScope.name} = ${applicationScope.name}   </b> 
    ✔️ el 내부에 변수명이 오면 JSTL의 변수명, 속성(Attribute) 의 이름으로 인식 

<hr>
🐻 서로 다른 속성(Attribute)명을 모든 영역에 정의  🐻
    ✔️ 속성명만 사용하여 출력가능
         ▪️ \${pname} = ${pname}
    	 ▪️ \${rname} = ${rname}
    	 ▪️ \${sname} = ${sname}
    	 ▪️ \${aname} = ${aname} 
    ✔️ 그러나 영역(Scope)을 붙여주는것이 효율적 (direct로 인식)
         ▪️ \${pageScope.pname} = ${pageScope.pname}
    	 ▪️ \${requestScope.rname} = ${requestScope.rname}
    	 ▪️ \${sessionScope.sname} = ${sessionScope.sname}
    	 ▪️ \${applicationScope.aname} = ${applicationScope.aname} 
🐻 연산자 Test 🐻
✅ Java
<%
int n1 = (Integer)request.getAttribute("num1");
int n2 = (int)request.getAttribute("num2");
%>
<%=n1 %>+<%=n2 %>=<%=n1+n2 %>
✅ EL
${requestScope.num1}+${requestScope.num2}=${requestScope.num1+requestScope.num2}


✅ Parameter Test: Java
=> 퀴리스트링으로 Test : ~/jsp02_el/ex02_getAttribute.jsp?num1=200&num2=789
<% n1 = Integer.parseInt(request.getParameter("price1")); 
n2 = Integer.parseInt(request.getParameter("price2")); %>
price test = <%=n1 %>+<%=n2 %>=<%=n1+n2 %>

✅ Parameter Test: EL
${param.price1}+${param.price2} = ${param.price1+param.price1}


</pre>
</body>
</html>