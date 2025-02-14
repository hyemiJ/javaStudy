
"use strict"

// ** Ajax_REST API, Axios Test **
// => Axios 메서드형식 적용
// => 1. List 출력
//    - axiMList : MemberController, Page response (axmemberList.jsp)

// => 2. 반복문에 이벤트 적용하기
//    - Delete, JoDetail
//    - idbList(id별 boardList) : RESTController, List_Data response 
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//1. 리스트 출력.
//	1) page를 Response를 받기.
// 		=> response를 resultArea1 에 출력하면 됨.
//		=> 요청 uri : /member/aximlist
//		=> response : axmemberList.jsp

function axiMList(){
	let url="/member/aximlist"
	axios.get(url)
	.then(response =>{
		console.log("response 성공 !");
		document.getElementById("resultArea1").innerHTML=response.data;
	}).catch(err=>{
		alert(`response 실패 ! ${err.message}`);
	});
	document.getElementById("resultArea2").innerHTML='';
}//axiMList

//2 반복문 안에 이벤트 적용하기.
// <td><a onclick="idbList('${m.id}')"> ${m.id}</a></td>
//	1. idbList
//		=> id별 boardList
// 		=> RESTController, PathVariable 처리,  List_Data response 
// 		=> Server : service, Sql 구문 작성
// 		=> request : id 를 path 로 전송 "/rest/idblist/banana"
// 		=> Response 
//    		-> 성공 : 반복분, Table로 List 출력문 완성, resultArea2 에 출력
//    		-> 출력자료의 유/무 : Server 에서 status로 (없으면 502) 처리
//    		-> 실패 : resultArea2 clear, alert 으로 에러메시지 출력 
function idbList(id){
	let url = "/rest/idblist/"+id;
	axios.get(url)
	.then(response =>{
		let listData = response.data;
		console.log(`idblist response 성공 ! ${listData}`);
		let resultHtml = 
						`<table>
							<tr>
								<th>🐇Seq(게시번호)</th>
								<th>🐇title(제목)</th>
								<th>🐇id(글쓴이)</th>
								<th>🐇regDate(게시날짜)</th>
								<th>🐇cnt(조회수)</th>
								<th>🐇root</th>
								<th>🐇step</th>
								<th>🐇indent</th>
							</tr>`;
							// *** 반복문 적용
							// ** for 간편출력 : of, in
							// => in: undifined 는 통과하고, 배열(index Return), 객체(속성명 Return)
							// => of: undifined 까지 모두출력 (순차출력과 동일), value 를 return, 
							//          ES6 에 for ~ in 의 단점을 보완 개선하여 추가됨.
							//          일반 객체에는 적용안되지만, (오류발생, 개발자모드로 확인가능)
							//           Array, String, Map, Set, function의 매개변수 객체 와
							//          이터러블 규약을 따르는 이터러블 객체 (Iterable Object) 는 적용됨
							// => 이터러블 규약
							//        내부에 Symbol.iterator (줄여서 @@iterator로 표현하기도함) 메서드가 구현되어 있어야 한다는 규약 
						for(let b of listData){
							resultHtml+=
							`<tr style="text-align: left;">
								<td>${b.seq}</td>
								<td>${b.title}</td>
								<td>${b.id}</td>
								<td>${b.regdate}</td>
								<td>${b.cnt}</td>
								<td>${b.root}</td>
								<td>${b.step}</td>
								<td>${b.indent}</td>
							</tr>`;
						}
						resultHtml+=`</table>`;
		document.getElementById("resultArea2").innerHTML = resultHtml;
						
	}).catch(err=>{
		// status 값이 502 라면 출력할 자료 없음. 
		if(err.response.status =='502'){
		document.getElementById("resultArea2").innerHTML = err.response.data;
		}else{
		document.getElementById("resultArea2").innerHTML = `시스템 에러, 잠시후 다시하세요. -> ${err.message}`;
		}
	});
}//idbList


//3. axios delete 적용.
//<span class="textlink" onclick="axiDelte(event,'${m.id}')" id="${m.id}">Delete</span>
//	1) 요청
//		=> "rest/axidemete"
// 		=> @PathVariable 적용
//	2) response
// 		=> response : 성공 실패 여부만 , 그러므로 RESTController 적용
// 		=> 성공시 : deleted로 변경 onclick 이벤트 해제
// 		=>

function axiDelte(event, id){
	let url = "rest/axidelete/"+id;
	axios.delete(url)
	.then(response=>{
		alert(`삭제 성공 => response.data => ${response.data}`);
		event.target.style.color = "gray";
		event.target.innerHTML="Deleted";
		
		//document.getElementById(id).innerHTML="Deleted";
		//document.getElementById(id).style.color="gray";
		document.getElementById(id).style.fontWeight="blod";
		document.getElementById(id).removeAttribute('onclick');
		document.getElementById(id).classList.remove('textlink');
	}).catch(err=>{
		if(err.response.status =='502'){
			alert(`삭제 실패 => err.response.data => ${err.response.data}`);
		}else{
			alert(`시스템 오류 => err.message => ${err.message}`);
		}
	});
}//axiDelte

function jnoEnter(event,jno){
	let url = "rest/jnoenter/"+jno;
	console.log(`pagex = ${event.pageX} , pagey = ${event.pageY}`)
	axios.get(url)
	.then(response=>{
		let table = document.createElement('table');
		table.style.position = 'absolute';
		table.style.backgroundColor='white';
		table.style.left = (event.pageX+15)+'px';
		table.style.top = event.pageY+'px';
		table.id = `movetable`;
		table.innerHTML+=`
				<tr ><td bgcolor="Lavender">Jno</td><td>${response.data.jno}</td></tr>
				<tr ><td bgcolor="Lavender">JoName</td><td>${response.data.jname}</td></tr>
				<tr ><td bgcolor="Lavender">CaptainID</td><td>${response.data.captain}</td></tr>
				<tr ><td bgcolor="Lavender">Project</td><td>${response.data.project}</td></tr>
				<tr ><td bgcolor="Lavender">Slogan</td><td>${response.data.slogan}</td></tr>`
		
				document.body.appendChild(table);
				
				
		//event.target.innerHTML +=`<table id ='movetable' style='position:absolute; background-color: white;
			//					left:${event.pageX+15}px; top:${event.pageY}px;'>
				//	<tr height="40"><td bgcolor="Lavender">Jno</td><td>${response.data.jno}</td></tr>
					//<tr height="40"><td bgcolor="Lavender">JoName</td><td>${response.data.jname}</td></tr>
				//	<tr height="40"><td bgcolor="Lavender">CaptainID</td><td>${response.data.captain}</td></tr>
				//	<tr height="40"><td bgcolor="Lavender">Project</td><td>${response.data.project}</td></tr>
				//	<tr height="40"><td bgcolor="Lavender">Slogan</td><td>${response.data.slogan}</td></tr>
				//</table>`
				
	}).catch(err=>{
		if(err.response.status =='502'){
			alert(`삭제 실패 => err.response.data => ${err.response.data}`);
		}else{
			alert(`시스템 오류 => err.message => ${err.message}`);
		}
	});
}

function jnoOut(event,jno){
	let table = document.getElementById("movetable");
	    if (table) {
	        table.remove();
			//event.target.innerHTML=`<span class="textlink">${jno}</span>`
	    }
}

// ** Ajax Member_PageList *********************
// => axiMList 에 Paging + 검색기능 추가
// => 검색조건 & Paging , Ajax 구현
//     -> 입력된 값들을 서버로 전송요청: axios
//    -> url 완성후 axios 호출

// => 1) 검색조건 입력 후 버튼클릭
//    -> jsp  문서내무의 script 구문을 외부문서로 작성 : EL Tag 적용안됨
//    ${pageMaker.makeQuery(1)} -> ?currPage=1&rowsPerPage=5 


//내부에 작성되었던 function 옮겨오기.
	function searchDB() {
		let url = 'axmcri' + '?currentPage=1&rowsPerPageCount=5'
			+ '&searchType=' + document.getElementById("searchType").value
			+ '&keyword=' + document.getElementById("keyword").value;
		axiMListCri(url);
	}//searchDB

	function keywordClear() {
		if (document.getElementById("searchType").value == 'all') {
			document.getElementById("keyword").value = "";
		}
	}//keywordClear
	
	function push(event) {
		if (event.key === 'Enter') {
			searchDB();
		}
	}//push

// axios 요청 처리
//axiMListCri('axmcri')
//axTestForm 첫요청명 : /member/axmicri
//parameter는 쿼리 스트링으로 처리됨.
	function axiMListCri(url){
		url = '/member/'+url;
		console.log(`axTest03.js_axiMListCri()_url : ${url}`);
		axios.get(url)
		.then(response=>{
			document.getElementById("resultArea1").innerHTML=response.data;
		}).catch(err=>{
			document.getElementById("resultArea1").innerHTML=`오류가 발생되었습니다. ${err.message}`;
		});		
			document.getElementById("resultArea2").innerHTML="";
	}


	// 4. Ajax Check 검색기능
	// => Check 검색 submit 을 Button(type 속성주의) 으로 변경
	// => MemberController : axmcri 메서드 공유
	// => 단, 조건 구분을 위해 요청명은 "/axmcheck"  

	// 4.1) CheckClear
	function checkClear() {
		let ck = document.querySelectorAll('.clear');
		for (let i = 0; i < ck.length; i++) {
			ck[i].checked = false;
		}
		return false;
	}//checkClear -> reset의 기본 이벤트 제거

	// 4.2) Axios 요청처리
	function axiMListCheck(){
		let checkAll = document.querySelectorAll('.clear');
		let checkedData='';
		checkAll.forEach(check =>{
			if(check.checked){
				checkedData += `&check=${check.value}`;
			}
		})
		let url ='axmcheck?currentPage=1&rowsPerPageCount=5'+checkedData;
		
		axiMListCri(url);
	}// memberController 를 @GetMapping("/axmcri") 를 활용.
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






