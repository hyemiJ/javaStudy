<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Object **</title>
<style>

</style>
</head>
<body>
<h1>** JSP Object **</h1>
<pre>
=> Web 애플리케이션 기본 객체(implicit object)
=> JSP에서 별도의 인스턴스 선언 없이 사용 가능
=> request, response, out, session,
   pageContext, application 등 9종류
<hr>
<h3>1. Request</h3>
* ContextPath = > <%=request.getContextPath() %>
* RealPath = > <%=request.getRealPath("-") %>
* sevletPath = > <%=request.getServletPath() %>
* requestURL = > <%=request.getRequestURL() %>
* requestURI = > <%=request.getRequestURI() %>
<hr>
<h3>2. Session</h3>
* Session_id = > <%=session.getId()%>
<hr>
<h3>3. Out</h3>
* out.print= > <%out.print("out 객체로 출력 하기");%>
<hr>
<h3>4. PageContext</h3>
=> JSP 페이지에 대한 정보를 저장한다.
=> PageScope 에 해당하는 객체
=> 기본 객체를 return 하는 메서드를 제공.
    -> request 객체와 메서드가 return하는 객체와 동일성 비교
<%
HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
%>
	* 비교 결과 = > request 내장객체와 PageCotext 로 생성한 req
	-><%=request == req %>
	* pageContext가 제공하는 out 객체로 출력하기
	-><%pageContext.getOut().print("pageContext.getOut().print"); %>
<hr>
<h3>5. Application</h3>
=> 서버 정보 , 서블릿의 메이저 버전 , 서블릿의 마이너 버전 , realPath 등.
	*서버 정보 : <%= application.getServerInfo() %>
	*서블릿의 메이저 버전 : <%=application.getMajorVersion() %>
	*서블릿의 마이너 버전 : <%=application.getMinorVersion() %>
	*realPath01 : <%=application.getRealPath("") %>
	 -> application.getRealPath("") 를 실행하면 , 사용시 현재 프로젝트 실행의 realPath
	*realPath02 : <%=application.getRealPath("/jsp01") %>
	->application.getRealPath("/jsp01") 를 실행하면 , 지정한 경로의 realPath
	= > realPath 의 주의사항 : HDD(하드디스크드라이브) 상의 소스 위치가 아님 주의
</pre>
</body>
</html>