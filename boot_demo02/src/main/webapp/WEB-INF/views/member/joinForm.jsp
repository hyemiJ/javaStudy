<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Join Form **</title>
<style type="text/css">
@font-face {
	font-family: 'MaruBuri';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Regular.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriSemiBold';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-SemiBold.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriBold';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Bold.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriLight';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-Light.ttf)
		format("truetype");
}

@font-face {
	font-family: 'MaruBuriExtraLight';
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot);
	src:
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.eot?#iefix)
		format("embedded-opentype"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff2)
		format("woff2"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.woff)
		format("woff"),
		url(https://hangeul.pstatic.net/hangeul_static/webfont/MaruBuri/MaruBuri-ExtraLight.ttf)
		format("truetype");
}

body {
	background-color: Lavenderblush;
	text-align: center; /* 텍스트 중앙 정렬 */
	font-family: 'MaruBuri';
	font-size: 20px;
}

.red {
	color: red;
	font-size: 22px;
}

.eMessage{
	color : red;
}
pre {
	font-family: 'MaruBuri';
}
</style>
<script src="/resources/myLib/inCheck.js"></script>
<script type="text/javascript">
"use strict"

	//** 입력값의 무결성 점검
	//=> ID 중복확인, 무결성 점검
	//=> UI 개선사항
	// => 중복확인 버튼 추가
	//    처음 : 중복확인버튼_enable / submit_disable
	// => 중복확인 완료후 submit 이 가능하도록
	//    중복확인버튼_disable / submit_enable
	// => 중복확인 기능 : function idDupCheck()
	//    id입력값의 무결성점검 -> id 확인요청 -> 서버로 전송 -> id , selectOne 결과 -> response: 사용가능/불가능 
	// => 서버측 : 컨트롤러에 idDupCheck 요청을 처리하는 매핑메서드, view_Page(팝업창) 작성 
	
	function idDupCheck(){
		//1. id입력값의 무결성점검
		if(!iCheck){
			iCheck = idCheck();
		}else{
		//2. iCheck 가 true 면 , 서버로 전송
			let url="idDupCheck?id="+document.getElementById("id").value;
			window.open(url,'_blank','width=400,height=300,resizable=yes,scrollbars=yes,toolbar=no,menubar=yes');
		}
	}//idDupCheck
	
	
	
	
	
	
	
	//1) 모든항목  focusout 이벤트핸들러
	// => 개별항목 점검확인하는 boolean Type 변수 (스위치변수) 
	// => 개별항목 점검 function() 작성
	//2) submit 진행전에 점검확인
	// => 모든항목의 점검이 완료된 경우에만  submit 진행
	// => function inCheck() 로 확인
	// => submit 버튼의 onclick 리스너에 등록
	//    ( submit 의 default 이벤트 고려 )
	let iCheck = false; // idMessage 
	let pw1Check = false; // pwMessage 
	let pw2Check = false; //pwcheckMessage 
	let nameCheck = false; //nameMessage 
	let ageCheck = false; // ageMessage 
	let pointCheck = false; //pointMessage 
	let birthCheck = false; //birthMessage 
	
	onload=function(){
		
		//** id
		document.getElementById("id").focus();
		document.getElementById("id").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("password").focus(); 
			}
		})//포커스 이동.
		document.getElementById("id").addEventListener('focusout',(e)=>{
			iCheck = idCheck();
		})//유효성검사.
		
		//** password
		document.getElementById("password").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("passwordcheck").focus(); 
			}
		})//포커스 이동.
		document.getElementById("password").addEventListener('focusout',(e)=>{
			pw1Check = passwordCheck();
		})//유효성검사.
		
		//** passwordcheck
		document.getElementById("passwordcheck").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("name").focus(); 
			}
		})//포커스 이동.
		document.getElementById("passwordcheck").addEventListener('focusout',(e)=>{
			pw2Check = password2Check();
		})//유효성검사.
		
		//** name
		document.getElementById("name").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("age").focus(); 
			}
		})//포커스 이동.
		document.getElementById("name").addEventListener('focusout',(e)=>{
			nameCheck = nCheck();
		})//유효성검사.
		
		//** age
		document.getElementById("age").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("point").focus(); 
			}
		})//포커스 이동.
		document.getElementById("age").addEventListener('focusout',(e)=>{
			ageCheck = aCheck();
		})//유효성검사.
		
		//** point
		document.getElementById("point").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("birthday").focus(); 
			}
		})//포커스 이동.
		document.getElementById("point").addEventListener('focusout',(e)=>{
			pointCheck = pCheck();
		})//유효성검사.
		
		//** birthday
		document.getElementById("birthday").addEventListener('keydown',(e)=>{
			if(e.which==13){
				// form 태그 내에서는 enterkey사용시 submit이 일어남
				//그러므로 이벤트 제거가 필요함
				e.preventDefault();
				document.getElementById("jno").focus(); 
			}
		})//포커스 이동.
		document.getElementById("birthday").addEventListener('focusout',(e)=>{
			birthCheck = bCheck();
		})//유효성검사.
	}
	

	function inCheck(){

	    if (!iCheck) {
	        document.getElementById("idMessage").innerHTML = "필수 입력 , 아이디를 확인해주세요";
	    }
	    if (!pw1Check) {
	        document.getElementById("pwMessage").innerHTML = "필수 입력 , 패스워드를 확인해주세요";
	    }
	    if (!pw2Check) {
	        document.getElementById("pwcheckMessage").innerHTML = "필수 입력 , 패스워드를 확인해주세요";
	    }
	    if (!nameCheck) {
	        document.getElementById("nameMessage").innerHTML = "필수 입력 , 이름을 확인해주세요";
	    }
	    if (!ageCheck) {
	        document.getElementById("ageMessage").innerHTML = "필수 입력 , 나이를 확인해주세요";
	    }
	    if (!pointCheck) {
	        document.getElementById("pointMessage").innerHTML = "필수 입력 , 포인트를 확인해주세요";
	    }
	    if (!birthCheck) {
	        document.getElementById("birthMessage").innerHTML = "필수 입력 , 생일을 확인해주세요";
	    }

	    // 모든 유효성 검사를 통과했는지 확인합니다.
	    let checkarr = [iCheck, pw1Check, pw2Check, nameCheck, ageCheck, pointCheck, birthCheck];
	    let allValid = checkarr.every(check => check === true);
	    
	    if (allValid) {
	        if (confirm("정말 가입 하시겠습니까 ? yes : 확인 선택 , no : 취소")) {
	            return true;
	        } else {
	            alert("가입이 취소되었습니다.");
	            return false;
	        }
	    } else {
	    	document.getElementById("id").focus();
	        return false;
	    }
	}
	
	//모든 검사항목에 대한 무결성 확인 . 모두 오류가 없으면 ,
</script>
</head>
<body>
<h2>** Web MVC2 JoinForm **</h2>
<!-- File Upload 기능추가 -->
<!--  ** FileUpLoad Form **
=> form 과 table Tag 사용시 주의사항 : form 내부에 table 사용해야함
   -> form 단위작업시 인식안됨
   -> JQ 의 serialize, FormData 의 append all 등 

=> method="Post" : 255 byte 이상 대용량 전송 가능 하므로

=> <form enctype="속성값">
   <form> 태그의 데이터 (input 의 value)가 서버로 제출될때 해당 데이터가 인코딩되는 방법을 명시함.  
 
=> enctype="multipart/form-data" : 화일 upload 를 가능하게 해줌 
    ** multipart/form-data는 파일업로드가 있는 입력양식요소에 사용되는 enctype 속성의 값중 하나이고, 
       multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미
       이 폼이 제출될 때 이 형식을 서버에 알려주며, 
       multipart/form-data로 지정이 되어 있어야 서버에서 정상적으로 데이터를 처리할 수 있다.     
-->
<form action="mjoin" method="post" enctype="multipart/form-data">
	<table style="margin: auto;">
	
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="id">I D</label>
			</td>
			<td>
				<input type="text" name="id" id="id" placeholder="영문과 숫자로 4~10글자" size="20">
				<button type="button" id="idDup" onclick="idDupCheck()">ID 중복 확인</button>
				<br>
				<span id="idMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="password">Password</label>
			</td>
			<td>
				<input type="password" name="password" id="password" placeholder="특수문자 필수" size="20">
				<br>
				<span id="pwMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="passwordcheck">Password확인</label>
			</td>
			<td>
				<input type="password" id="passwordcheck" placeholder="패스워드 재입력" size="20">
				<br>
				<span id="pwcheckMessage" class="eMessage"></span>
			</td>
		</tr>
		
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="name">Name</label>
			</td>
			<td>
				<input type="text" name="name" id="name" size="20">
				<br>
				<span id="nameMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="age">Age</label>
			</td>
			<td>
				<input type="text" name="age" id="age" size="20">
				<br>
				<span id="ageMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="jno">Jno</label>
			</td>
			<td>
				<select name="jno" id="jno">
					<c:forEach var="jo" items="${joSelectAll}" >
					<option value="${jo.jno}" >${jo.jno} 조 : ${jo.jname} </option>
					</c:forEach>
		<!-- 			<option value="1">1조: 우린팀이니까</option>
					<option value="2">2조: 모꼬지</option>
					<option value="3">3조: Object Of Coding</option>
					<option value="4">4조: 컴포NaN트</option>
					<option value="7">7조: 칠면조(관리팀)</option> -->
				</select>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="info">Info</label>
			</td>
			<td>
				<input type="text" name="info" id="info" placeholder="자기소개 & 희망사항" size="20" >
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="point">Point</label>
			</td>
			<td>
				<input type="text" name="point" id="point" placeholder="실수 입력" size="20" >
				<br>
				<span id="pointMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="birthday">Birthday</label>
			</td>
			<td>
				<input type="date" name="birthday" id="birthday">
				<br>
				<span id="birthMessage" class="eMessage"></span>
			</td>
		</tr>
		
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="rid">추천인</label>
			</td>
			<td>
				<input type="text" name="rid" id="rid" size="20">
			</td>
		</tr>
		<tr height="40">
			<td bgcolor="#bcdeff">
				<label for="uploadfilef">image</label>
			</td>
			<!-- File Upload 기능추가 -->
			<td>
				<img alt="myimage" src="" class="select_img" width="80" height="100"><br>
				<input type="file" name="uploadfilef" id="uploadfilef" size="20">
				<script type="text/javascript">
				document.getElementById('uploadfilef').onchange=function(e){
	            	if(this.files && this.files[0]) {
	                	let reader = new FileReader;
	                	reader.readAsDataURL(this.files[0]);
	                 	reader.onload = function(e) {
	                     // => jQuery를 사용하지 않는경우 
	                    	 document.getElementsByClassName('select_img')[0].src=e.target.result;
	                     
	                    //$(".select_img").attr("src", e.target.result)
	                    //                .width(70).height(90); 
	                	} // onload_function
	             	} // if    
	          	}; //change 
				</script>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" onclick="return inCheck()" id="submitTag" value="가입"
				disabled>&nbsp;&nbsp;
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
<br><hr>
<c:if test="${!empty requestScope.message}">
=> ${requestScope.message}<br>
</c:if>
<hr>
&nbsp;<a href="/home">Home</a>&nbsp;
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;
</body>
</html>