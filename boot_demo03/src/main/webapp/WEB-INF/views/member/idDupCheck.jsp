<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
@font-face {
    font-family: 'MaruBuri';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriSemiBold';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriBold';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriLight';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.ttf) format("truetype");
}

@font-face {
    font-family: 'MaruBuriExtraLight';
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot);
    src: url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot?#iefix) format("embedded-opentype"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff2) format("woff2"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff) format("woff"), url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.ttf) format("truetype");
}

body {
	background-color: Lavenderblush;
	text-align: center; /* 텍스트 중앙 정렬 */
	font-family: 'MaruBuri';
	font-size: 20px;
}

.red , .eMessage {
	color: red;
	font-size: 22px;
}

pre {
	font-family: 'MaruBuri';
}
</style>
<title>ID 중복 확인</title>
<script src="/resources/myLib/inCheck.js"></script>
<script type="text/javascript">
//idCheck() -> 상단 스크립트로 향함.
//idOk() id를 사용 가능하도록 현재창은 닫기.
//1. 현재창의 id를 부모창의 id로 전송.
//2. 부모창의 submit 을 활성화.
//3. 부모창의 id는 수정불가 readonly , password로 focus
//4. 현재창 닫기

function idOk(){
	//1. 현재창의 id를 부모창의 id로 전송.
	//opener.document.getElementById("id").value = document.getElementById("id").value;
	opener.document.getElementById("id").value ="${param.id}";
	
	//2. 부모창의 submit 을 활성화.
	opener.document.getElementById("submitTag").disabled ='';
	
	//3. 부모창의 id는 수정불가 readonly , password로 focus
	opener.document.getElementById('id').readOnly=true;
	opener.document.getElementById('password').focus();
	// => readonly 속성 사용시 주의
    //    Tag 의 속성은 readonly로 정의되어 있지만, ( readonly="readonly" )
    //    DOM 의 node 객체에서는 readOnly 로 정의되어있으므로
    //    JS 코딩시에는 readOnly 로 사용해야함
    //opener.document.getElementById('id').readonly="readonly"; //XXX
    //opener.document.getElementById('id').readOnly="readOnly"; //OK
    
    //4. 현재창 닫기
    close();
}

</script>
</head>
<body>
<div id="wrapper">
	<h3>ID 중복 확인</h3>
	<form action="idDupCheck" method="get">
	<input type="text" id="id" name="id" value="${param.id}">
	<input type="submit" value="ID 중복확인" onclick="return idCheck()"> 
	<br>
	<span id="idMessage" class="eMessage"></span>
	</form>
	<!-- 서버 처리 결과 : idUSe의 값이 false 또는 true에 맞는 메세지 출력 -->
	<div id="msgBlock">
	<c:if test="${idUse == 'true'}">
	${param.id}는 사용 가능 합니다.
	<button onclick="idOk()">ID 선택</button>
	</c:if>
	<c:if test="${idUse == 'false'}">
	${param.id}는 다른 유저가 사용합니다.<br>
	다시 입력하세요.<br>
<!-- 	부모 창에 남아있는 param id 삭제 , 
	현재 창의 focus 지정해서 재입력 유도. -->
	<script type="text/javascript">
	window.document.getElementById("id").focus();
	opener.document.getElementById("id").value='';
	//opener.document.getElementById("idDup").disabled='disabled';
	</script>
	</c:if>
	</div>
	<script type="text/javascript">
	opener.document.getElementById("idDup").disabled='disabled';
	</script>
</div>
</body>
</html>