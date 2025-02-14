<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> El Start </title>
<style>
@font-face {
    font-family: 'IM_Hyemin-Bold';
    src:
        url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2106@1.1/IM_Hyemin-Bold.woff2')
        format('woff');
    font-weight: normal;
    font-style: normal;
}

body {
    background-color: Lavenderblush;
    text-align: center; /* 텍스트 중앙 정렬 */
    font-family: 'IM_Hyemin-Bold';
}

pre {
    font-family: 'IM_Hyemin-Bold';
}
</style>
</head>
<body>
<h2>🪄 EL 기본 사항 🪄</h2>
<%
String name = "카루";
%>
<pre>
▪️ EL : Expression Language, 표현언어
▪️ 편리한 값(value)의 출력과 사용

<hr>

1) 값(Value)의 출력 비교
▪️ Java 표현식 name : <%= name  %>
▪️ Java out 객체 활용 name : <%out.print("name"); %>
▪️ EL 출력 :${" 🍪 Hello EL, 표현 언어 🍪 "}
  ▫️Java 변수 출력1 : name = \${name} 
  ▫️Java 변수 출력2 : \${"name : " +name}
▪️ EL 문자열 연산 : \${"EL 문자열" + "연산은 가능하니?" }
▪️ EL 내부에서는 Java 변수, 문자열 연산불가 
🩵‼️자바를 모르는 사람도 손쉽게 사용하기 위함이 목적임 
▪️ JSTL 과 병행해서 사용됨 

<hr>

EL Test

🐻 EL 자료형🐻
▪️ 정수형 : ${123}
▪️ 실수형 : ${10.123}
▪️ 문자형 : ${"문자형 쓰려면 큰따옴표 적어야함!"}
▪️ 논리형(boolean) : ${true}
▪️ null : ${null}

‼️ 기본적인 자료형은 있으나 자바 변수는 사용 불가능


🐻 EL 연산 🐻

➡️ 산술(4칙) 연산 
▪️ \${5+2} => ${5+2}
▪️ \${5-2} => ${5-2}
▪️ \${5*2} => ${5*2}
▪️ \${5/2} => ${5/2}
▪️ \${5%2} => ${5%2}

➡️ 관계(비교) 연산
▪️ < > >= <= == != 
▪️ gt(>): greater than  /  lt (<) : less than 
▪️ ge (>=) : greater equal  /  le (<=): less equal 
 ▪️eq : equal, == / ne (지원x): not equal, !=

▪️ \${5>2} => ${5>2}
▪️ \${5 gt 2} => ${5 gt 2}

▪️ \${5<2} => ${5<2}
▪️ \${5 lt 2} => ${5 lt 2}

▪️ \${5>=2} => ${5 >= 2}
▪️ \${5 gt 2} => ${5 gt 2}

▪️ \${5<=2} => ${5<=2}
▪️ \${5 le 2} => ${5 le 2}

▪️ \${5==2} => ${5 == 2}
▪️ \${5 eq 2} => ${5 eq 2}

▪️ \${5!=2} => ${5!=2}
<%-- ▪️ \${5 ne 2} => ${5 ne 2} --%>
<!-- 에디터상에서는 오류이지만 실행은 됨! -->

➡️ 논리(집합) 연산 : && ||
\${5>2 && 10>20} => ${5>2 && 10>20}
\${5>2 || 10>20} => ${5>2 || 10>20}

 ➡️삼항 조건식
  \${5>2 ? 5:2} => ${5>2 ? 5:2}
 \${5>2 ? "오":"이"} => ${5>2 ? "오":"이"}

🐻 기타 🐻

✅ JAVA 변수 : 사용 불가.
✔️ JSTL 로 정의한 변수는 사용 가능.
✔️empty 연산자
	- 값이 없음을 확인 : true로 리턴
	- \${empty_name} = ${empty name} 
	- EL 내부에 변수명(식별자)이 있으면 , 
			➡️JSTL 의 변수인가 체크 , 아니면 ➡️Scope의 속성(Attribute)명으로 인식. => ex02 에서 확인

✅ request 객체의 parameter 
✔️ request 객체의 Parameter를 전달하는 el의 내부객체 제공 : param
✔️ 쿼리스트링으로 id 지정 전.후 Test : ~/web01/jsp02_el/ex01_elStart.jsp?id=banana 
✔️Java 표현식: <%=request.getParameter("id") %>
✔️param 1 )  \${param.id} : ${param.id} 
✔️param 2 )  \${param["id"]} : ${param["id"]}
</body>
</html>