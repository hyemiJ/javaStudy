<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL Start **</title>
<style type="text/css">
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
.red{
color : red;
font-size: 22px;
}
pre {
    font-family: 'GangwonEdu_OTFBoldA';
}
</style>
</head>
<body>
<h1>** JSTL Start **</h1>
<pre>
=> Jstl Library 를 정의 (현재문서_Page 가 인식할 수 있도록)
   디렉티브 taglib 에 uri=".." prefix=".."
🐻 1. 출력: out Tag 🐻
=> Java의 out객체, 표현식, EL역할
<span class="red"><c:out value="Hello JSTL !!!" /></span>
🐻 2. 변수 정의 :  set 🐻
<c:set value="홍길동" var="name"/>
<c:set value="22" var="age"/>
<span class="red"><c:out value="${name}"/> </span>
<span class="red"><c:out value="${age}"/> </span>

✔️ EL tag
▪️ \${name} = <span class="red">${name} </span>
▪️ \${age} = <span class="red">${age}</span>
▪️  \${age*100} = <span class="red">${age*100}</span>

✔️ 자바 tag
▪️ 호환 적용 허용하지 않음.
<%-- <%= name %> --%>

🐻 3. 연산적용 🐻

<c:set value="${age+age}" var="add"/>
▪️ \${add} => <span class="red">${add}</span>
<c:set value="${age+add}" var="ageadd"/>
▪️ \${ageadd} => <span class="red">${ageadd}</span>
<c:set value="${name == age}" var="bool"/>
▪️ \${bool} => <span class="red">${bool}</span>
<c:set value="${age>add ? age : add}" var="max"/>
▪️ \${max} => <span class="red">${max}</span>


🐻 5. 변수삭제 🐻
=> remove
<c:remove var="en"/>
\${empty en} =<span class="red"> ${empty en}</span>

🐻 6. 우선순위 확인 🐻
=> JSTL 변수와 pageScope 의 Attribute 명이 동일한경우 -> 나중의 값이 우선적용됨.
✔️test 1 : name 정의 순서 : c:set -> page_setAttribute
<%
pageContext.setAttribute("name", "그린컴");
%>
\${name} = ${name}
✔️test 1 : name 정의 순서 : c:set -> page_setAttribute
<c:set value="newName" var="name"/>
\${name} = ${name}
<c:if test="${name eq age}">
실행이 안되야되는 구문.
</c:if>
<c:if test="${name ne age}" >
실행이 되야하는 구문.
</c:if>

</pre>


</body>
</html>