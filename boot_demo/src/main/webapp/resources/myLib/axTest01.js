/**
    ** Ajax Test 01 : Login
    => fetch 와 axios 비교
    => request Data Type (Json)
    => response Data Type (Text, Json)
    
    *** fetch
    => fetch(url, [options])
    -> url: 액세스할 URL
    -> options – 선택적 매개변수: 메소드, 헤더 등
    -> fetch 함수의 응답(Response) 처리는 일반적으로 2단계로 함.
    -> 실행후 promise객체를 return 하므로, .then() .catch() .finally() 등의 메서드체인 적용됨. 
    
    => Response 의 Property
    -> response.status: HTTP 상태 코드(예: 200)
    -> response.ok: Boolean, HTTP 상태 코드가 200-299 사이 이면 True
    -> response.headers: HTTP 헤더가 있는 맵과 유사한 객체 
    
    ** Promise
    => 비동기 처리에서 동기식(순차적) 처리를 지원해줌.
        즉, 지연함수 와 비동기연산(Ajax) 을 제어할 수 있도록 해주는 객체. 
       ( 지연함수: 지정한 시간 후에 실행 되도록 정의한 함수 )
    => 기본형식
    promise.then(function(count){
                console.log("** Test2) resolve count => "+count); 
            }).catch(function(message){
                console.log("** Test2) reject message => "+message); 
            }).finally(function(){
                console.log("** Test2) finally Test"); 
            });    
        
 */
"use strict"

// 1. rsLoginf()
// - 로그인 폼 출력하기.

function rsLoginf(){
	let resultHTML = 
	`<table align center style="margin:auto">
	        <caption><h3 style="box-shadow: inset 0 -10px 0  #CEDF9F;">🧸 Ajax Login Form 🧸</h3></caption>
	        <tr height=40><td bgcolor="#CEDF9F"><label for="id">🍔ID🍔</label></td>
	            <td><input type="text" id="id"></td>
	        </tr>
	        <tr height=40><td bgcolor="#CEDF9F"><label for="password">🍟Password🍟</label></td>
	            <td><input type="password" name="password" id="password"></td>
	        </tr>
	        <tr height=40>
	            <td colspan="2"><span class="textlink" onclick="rsLogin()">🐵rsLogin🐵</span>&nbsp;&nbsp;
	                <span class="textlink" onclick="rsLoginjj()">🐼rsLoginJJ🐼</span>&nbsp;&nbsp;
	                <span class="textlink" onclick="axiLoginjj2()">🐩axiLoginJJ🐩</span>&nbsp;&nbsp;
	                <input type="reset" value="취소">
	            </td>
	        </tr>
	 </table>`
	 document.getElementById('resultArea1').innerHTML=resultHTML;
}

//로그인 서비스 요청과 처리

//1. ajax 요청 - fetch 방식
// -server : @RestController , 계층적 uri 사용중 , post 요청
// -request : 전송 데이터 타입은 : json
// -response : 받는 데이터 타입은 : text 
//2. ajax 요청 - axios 방식

//요청은 JSON 응답은 TEXT
function rsLogin(){
	let url = "/rest/rslogin";
	fetch(url , {
		method:'post',
		body:JSON.stringify({
			id: document.getElementById("id").value,
			password : document.getElementById("password").value
		}),
		headers:{'Content-Type':'application/json'}
		// => POST 요청에서는 반드시 headers 형식 작성 
		//    (JSON 포맷을 사용함을 알려줘야함)
	}).then(response=>{
		// ** then 1 단계
		// => status 확인 
		//        -> 성공: Response Body-reading 후 Data return
		//        -> 실패: Error 생성후 catch 블럭으로  
		// => fetch는 네트워크 장애등으로 HTTP요청을 할수없거나,
		//      url에 해당하는 페이지가 없는 경우에만 거부(reject)되어 catch로 분기하므로,
		//      .then절(1단계) 에서 수동으로 HTTP 에러를 처리함.
		//      그러나 axios는 상태코드가 2xx의 범위를 넘어가면 거부(reject)함.
		         
		if (!response.ok) throw new Error(response.status);
		return response.text();
		// => 서버에서 Text 형식으로 보냈으므로  text() 메서드 사용
		//   ( Type 별로 Body-reading method를 적용함 ) 
		/* => Body-reading method
		• response.text() – 응답을 읽고 텍스트로 반환 
		-> result =ResponseEntity.status(HttpStatus.OK).body("Login 성공");
		• response.json() – 응답을 JSON으로 구문 분석
		• response.formData() – 응답을 FormData객체로 반환
		• response.blob() – 응답을 Blob (유형이 있는 이진 데이터) 으로 반환
		• response.arrayBuffer() – 응답을 ArrayBuffer (바이너리 데이터의 저수준 표현) 로 반환
		• response.body - ReadableStream 객체이므로 본문을 청크별로 읽을 수 있다.
		*/
	}).then(responseData=>{
		alert(`🦖 responseDate => ${responseData}`);
		location.reload();
	}).catch(err =>{
		console.log(`🦖 Error => ${err.message}`);
		if(err.message=='502'){
			alert(`ID 또는 Password 오류 입니다. 다시 하세요`);
			document.getElementById("id").value = '';
			document.getElementById("password").value = '';
		}else{
			alert(`시스템 오류 입니다.status=> ${err.message}`);
		}
	});
}//rsLogin

//요청은 JSON 응답은 JSON
function rsLoginjj(){
	let url = "/rest/rsloginjj";
	fetch(url , {
		method:'post',
		body:JSON.stringify({
			id: document.getElementById("id").value,
			password : document.getElementById("password").value
		}),
		headers:{'Content-Type':'application/json'}
	}).then(response=>{
		if (!response.ok) throw new Error(response.status);
		return response.json();

	}).then(responseData=>{
		alert(`🦖 responseDate: id => ${responseData.id}, username => ${responseData.username}`);
		location.reload();
	}).catch(err =>{
		console.log(`🦖 Error => ${err.message}`);
		if(err.message=='502'){
			alert(`ID 또는 Password 오류 입니다. 다시 하세요`);
			document.getElementById("id").value = '';
			document.getElementById("password").value = '';
		}else{
			alert(`시스템 오류 입니다.status=> ${err.message}`);
		}
	});
}//rsLoginjj

//ajax 요청 , axios - 요청은 JSON 응답은 JSON
// ** Ajax 요청, Axios 적용
// => 라이브러리 추가 (CDN 으로..   axTestForm.jsp 에)
// => 서버요청은 위 "1.3) rsLoginJJ" 과 동일하게 rsloginjj 
// => JSON <-> JSON
// => Request
//    - data  : JSON Type 기본 (fetch 처럼 JSON.stringify 필요없음) 
//    - headers: {'Content-Type': 'application/json'}  
// => Response
//     - then : 응답 Data는 매개변수.data 로 접근가능, JSON Type 기본 (1단계로 모두 받음: fetch 와 차이점))   
//    - catch
//        . axios는 상태코드가 2xx의 범위를 넘어가면 거부(reject) 되어 catch절로 분기함 
//          이때 catch 절의 매개변수는 response 속성으로 error 내용 전체를 객체형태로 전달받음    
//        . error.response : error 내용 전체를 객체형태로 전달받음
//        . error.response.status : status 확인가능    
//        . error.message : 브라우져의 Error_Message, "Request failed with status code 415

function axiLoginjj2(){
	let url = "/rest/rsloginjj";
	
	axios({url:url,
		method:'Post',
		headers:{'Content-Type': 'application/json'},
		data:{
			id : document.getElementById("id").value,
			password : document.getElementById("password").value
		}
	}).then(response=>{
		alert(`response.data =>${response.data}`);
		alert(`response.data : id =>${response.data.id}, username =>${response.data.username}`);
		location.reload();
	}).catch(err=>{
		console.error(`err.response => ${err.response},
						err.response.status => ${err.response.status}, 
						err.message => ${err.message}`);
		if(err.response.status=='502'){
			alert(`id 또는 password 오류 입니다.`);
		}else{
			alert(`시스템 오류`);
		}
	});

}//axiLoginjj2





























