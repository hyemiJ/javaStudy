/**
// ** Ajax_REST API Join Test **
// => axios
// => file_UpLoad 가 포함된 formData 처리
// => joinForm 요청: MemberController -> 웹 Page return
// => join 요청: RTestController -> 결과 Text return 성공 여부만 알면 되기 떄문. 

// => Axios 메서드형식 적용 (00_AJAX(공유).pptx 16p)
/*    
	- GET   : axios.get( url[, config] )
    - POST  : axios.post( url, data[, config] )
        
        -> post 두번째 파라미터는 Json형식 또는 FormData객체 형식으로 전달하는 Data 자리임 
           ( axTest01.js 의 axiLoginjj2() 로 Test )
        -> Json형식 
            * {id:"banana", age:"10"} 
            * 서버에서 @RequestBody 로 받음
        -> FormData 형식 (Parameter 기반 형식이며 서버에서 @RequestBody 사용불가함)
            * id: banana
              age: 10            
            * 서버에서 @ModelAttribute 로 받음 (대부분 생략됨, 컨트롤러의 rsjoin 에서 확인)
        -> 그러므로 대부분 Json 형식으로 두번째 위치에서 Data를 전송함
           
        -> post는 세번째 파라미터는 headers 등 를 추가할 수 있으며,
           params 속성을 이용해서 Data를 전송할수도 있으나 권장하지않음

        -> https://goodteacher.tistory.com/514 참고
            
    - PUT   : axios.put( url, data[, config] )
    - PATCH : axios.patch( url[, data[, config]] )
    - DELETE: axios.delete( url[, config] )      
	*/



function rsJoinf(){
	let url ="/member/joinForm";
	axios.get(url)
		.then(response =>{
			console.log(`response join form 성공`);
			document.getElementById("resultArea1").innerHTML=response.data;
		}).catch(err=>{
			alert(`response join form 실패 =>${err.message}`);
		});
			document.getElementById("resultArea2").innerHTML='';
}

// ----------------------------------------------------------------
// ** form Tag의 input Data 처리방법
// => 직접 입력 : multipart 타입은 처리할 수 없음
//        data: { id:document.getElementById('id').value,
//                  password:document.getElementById('password').value
//              } 
// => Form 의 serialize() : jQuery 만 적용됨
//         -> input Tag 의 name 과 id 가 같아야 함.    
//         -> multipart 타입은 전송안됨. 
//         처리하지 못하는 값(예-> file Type) 은 스스로 제외시킴 
// => 객체화 : multipart 타입은 처리할 수 없음
//         let myData = {
//                id:document.getElementById('id').value,
//                password:document.getElementById('password').value
//            }

// => FormData 객체 활용 : JS의 내장객체
//        -> append 메서드 : multipart 타입 처리 불편
//        -> 생성자 매개변수 이용 : multipart 타입 포함 간편한 처리가능
// ----------------------------------------------------------------

// 2) Join처리: axiJoin
// => multipart 타입 포함
// => JS의 내장객체 FormData 사용
//        -> 요청_headers "Content-Type" 변경

//axios로의 joinform 요청 처리.
function axiJoin(){
	let url ="/rest/rsjoin";
	//데이터 전송 준비(파일업로드가 포함된 경우 데이터 전송시에 준비가 까다로워진다.)
	let formData = new FormData(document.getElementById("myForm")); // FormData -> javaScript객체
	
	//axious 요청처리
	//axios.post(url,data[,config])
	axios.post(url,formData,
		{headers:{'Content-Type':'multipart/form-data'}})// headers에서 반드시 contentType 변경 필요
		.then(response =>{
			alert(`가입 성공! response.data => ${response.data}`);
			rsLogin();
		}).catch(err=>{
			if(err.response.status =='502'){
			alert(`response 가입 실패 =>${err.message}`);				
			}else{
			alert(`response 가입 실패 =>${err.message}`);
			}
		})
			document.getElementById("resultArea2").innerHTML='';
}









