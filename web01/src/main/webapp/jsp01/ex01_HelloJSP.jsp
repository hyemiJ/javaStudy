<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
	<h2>** hello JSP **</h2>
	<h3>안녕하세요 !</h3>
	<pre>
<h3>
=> JSP 장점 : view 간편
=> JSP 단점 : Java Code 작성 불편
<hr>

<ul width="500">
**  1 . Java Code 작성
<hr>
<li>1.1 ) Scriptlet : 자바코드</li>
<li>1.2 ) Expression : 표현식 (출력문)</li>
<li>1.3 ) Declaration : 선언부 (메서드등)</li>
<hr>
</ul>
=> Declaration : 선언부 : <br>
<%!public int multiply(int a, int b) {
		return a * b;
	}

	String name = "홍길동";
	int i = 10;
	int j = 20;%>
=> Expression : 표현식 <br>
	-> multiply(4,5) 의 결과는 <%=multiply(4, 5)%> 입니다.
	-> 변수 출력 : i =<%=i%>, j =<%=j%>, name =<%=name%>
=> Scriptlet : 자바코드 <br>
	-> multiply(i,j) 의 결과를 짝 , 홀 구분하여 출력
	<%-- -><%multiply(i, j)%2==0 ? "짝" : "홀";%> --%>
	 결과 는 ?<%
	if (multiply(i, j) % 2 == 0) {
	%> 짝수
	<%} else {%>
	홀수
		<%}%>
	
</h3>
</pre>
</body>
</html>