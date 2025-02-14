<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Parameter 활용 **</title>
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
<h2>** Parameter 활용 **</h2>
<pre><b>
=> 동질성 비교 , null(값의 존재) 확인 
1. 동질성 비교
* I D : <span class="red">${param.id}</span>
* Password: <span class="red">${param.password}</span>

\${param.id=='admin'} => <span class="red">${param.id=='admin'} </span>
\${param.password=='12345'} => <span class="red">${param.password=='12345'} </span>

2. null(값의 존재) 확인: empty, == 
=> 쿼리스트링으로 비교 Test
~/ex03_parameter.jsp?id=admin&&password=12345!
~/ex03_parameter.jsp?id=admin&&password=
~/ex03_parameter.jsp?id=admin 

2.1) ==null
=> 해당하는 Parameter가 존재하지않으면 true, 존재하지만 값이 없는 경우에는 false
\${param.id==null} => <span class="red"> ${param.id==null} </span>
\${param.password==null} => <span class="red"> ${param.password==null} </span>

2.2) empty
=> 해당하는 Parameter가 존재하지않거나, 존재하지만 값이 없는 경우 모두 true 
\${empty_param.id} => <span class="red"> ${empty param.id} </span>
\${empty_param.password} =>  <span class="red">${empty param.password} </span>

3. pageContext
=> Jsp 페이지에 대한 정보를 저장하는 객체 (pageScope)
=> 기본객체를 return 하는 메서드를 제공 
* 요청 URL:  <span class="red">${pageContext.request.requestURL}</span>
* 요청 URI:  <span class="red">${pageContext.request.requestURI}</span>
</b></pre>

</body>
</html>