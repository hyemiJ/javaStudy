<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Page Flow **</title>
</head>
<body>
<h1>** JSP Page Flow **</h1>
<h2>1. Forward </h2>
<h3>=> JSP 표준 Action Tag를 이용한 이동.</h3>
<pre>
<script type="text/javascript">
	alert("~~~hello 로 안내합니다")
	  // => Forward 이동 Test 시에는
    // => 스크립트는 브라우져에서 실행되기 때문에 실행 되지않음
    // => 서버에서 forward 된 화면이 response 에 담겨 전송되고 출력 되기때문 
</script>
<%--  <jsp:forward page="ex01_HelloJSP.jsp"/> --%>
</pre>
<hr>
<h2>2. Include </h2>
<h3>=> JSP 표준 Action Tag</h3>
<pre>
<%-- <jsp:include page="ex01_HelloJSP.jsp"/> 
	 -> 변수 출력 : i =<%=i%>, j =<%=j%>, name =<%=name%> --%>
	-> jsp:include를 통한 페이지 삽입은 , 변수를 공유하지 않는다.
	-> jsp 문서의 완성된 페이지가 포함되는 것이기 때문에 컴파일전의 변수를 공유하지 않는것.
	-> 즉 , 코드 호환이 안됨.
</pre>
<h3>=> Directive include</h3>
<pre>
	-> JSP 문서의 소스 코드 포함 .
	-> 그러므로 변수 공유 가능.(코드 호환됨.).
	->변수 출력 : i =<%=i%>, j =<%=j%>, name =<%=name%>
	<%@ include file = "ex01_HelloJSP.jsp" %>
</pre>
<hr>
<h2>3. Redirect </h2>
<h3>=> response sendRedirect</h3>
<pre>
<% response.sendRedirect("ex01_HelloJSP.jsp"); %>

</pre>
</body>
</html>