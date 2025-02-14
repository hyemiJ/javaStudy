/**
** 입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4~10), 영문자,숫자 로만 구성
// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Password2: 재입력후 Password 와 일치성 확인
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
// Jno : select 를 이용 (X)
// Info : (X)
// Rid : (X)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return
   => 정규식을 활용한다.
   
** match Test
   => 아래 조건에 true -> not (!)  match 적용해보면
   => 정확하지 않으므로 (부적절, replace 를 사용)
        ...       
        } else if (!id.match(/[a-z.0-9]/gi)) {
            alert(' ID는 영문자와 숫자로만 입력하세요. !!!')
            return false;
        }    
 ** Good 정리
 => https://inpa.tistory.com/entry/JS-📚-정규식-RegExp-누구나-이해하기-쉽게-정리
 
** 정규 표현식 (정규식:Regular Expression) 객체 : RegExp
=> 자바스크립트의 기본 내장 객체 중의 하나
=> 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식
* 생성
    let regExp1= new RegExp('text') ;
    let regExp2= /text/ ; 
* 메서드    
    ("문자열").replace(/정규표현식/, "대체문자열") : "정규표현식"에 매칭되는 항목을 "대체문자열"로 변환
    (정규표현식).test("문자열") : 정규식과 일치하는 문자열이 있으면 true 아니면  false 를 return 
    (정규표현식).exec("문자열") : 정규식과 일치하는 문자열을 return 
* 예제    
    let regExp= /script/ ; 
    let s='Javascript jQuery Ajax';
    
    let output = regExp.test(s) ;
    alert(output) ; 
* 그러나 주로 문자열의 메서드와 같이 사용됨
     
/.../ : 정규식 RegExp 의 리터럴

** 플래그 문자 
g : global, 전역비교
i : 대문자는 소문자 변환후 비교 (대/소문자 구분 없음)
m : 여러줄의 검사 수행
   ( 각줄을 개별문자로 인식하고 검사해줌
    예 : 'JavaScript\njQuery\nAjax' )

\. : . 문자 (. 는 한 문자를 의미하나 \. 는 . 문자를 의미함)
a-z : abcdefghijklmnopqrstuvwxyz 와 같음
0-9 : 0123456789 와 같음
: : : 문자
_ : _ 문자
- : - 문자
[~.~] : ~ 와 ~ , Or 의 묶음
[..] : Or 의 묶음. 안에 기록된 1가지외 중복 적용됨.
[^...] : 내부내용의 부정. 기록된 이외의 것을 찾음.
+ : 하나 이상의 반복적용. (단어(?) 찾음)

 */

"use strict"
// 1) ID
// => 길이, 영문과 숫자만 가능 
// ID : 길이(4~10), 영문자,숫자 로만 구성
function idCheck(){
	let special = /[a-z.0-9]/gi ;
	let id = document.getElementById("id").value;
	console.log('됬니 ?');
	if(id.length<4 || id.length>10){
		document.getElementById("idMessage").innerHTML = "아이디는 4~10글자 입니다. ";
		return false;
	}else if(id.replace(special, '').length>0){
		document.getElementById("idMessage").innerHTML = "아이디는 영문자와 숫자만 가능합니다.";
		return false;
	}else{
		document.getElementById("idMessage").innerHTML = "";
		return true;
	}
}

// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
function passwordCheck(){
	let special = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?])[A-Za-z\d!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+$/ ;
	let password = document.getElementById("password").value;
	if(password.length<4 || password.length>10){
		document.getElementById("pwMessage").innerHTML = "비밀번호는 4~10글자 입니다. ";
		return false;
	}else if(password.replace(special, '').length>0){
		document.getElementById("pwMessage").innerHTML = "비밀번호는 영문,숫자,특수문자로 구성해야합니다.";
		return false;
	}else{
		document.getElementById("pwMessage").innerHTML = "";
		return true;
	}
}

// Password2: 재입력후 Password 와 일치성 확인
function password2Check(){
	let special = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?])[A-Za-z\d!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+$/ ;
	let password = document.getElementById("password").value;
	let password2 = document.getElementById("passwordcheck").value;
	if(password2.length<4 || password2.length>10){
		document.getElementById("pwcheckMessage").innerHTML = "비밀번호는 4~10글자 입니다.";
		return false;
	}else if(password2.replace(special, '').length>0){
		document.getElementById("pwcheckMessage").innerHTML = "비밀번호는 영문,숫자,특수문자로 구성해야합니다.";
		return false;
	}else if(password !== password2){
		document.getElementById("pwcheckMessage").innerHTML = "비밀번호가 일치하지 않습니다.";
		return false;
	}else{
		document.getElementById("pwcheckMessage").innerHTML = "";
		return true;
	}
}

// Name : 길이(2이상), 영문 또는 한글로 만 입력
function nCheck(){
	let special = /^[A-Za-z가-힣]+$/ ;
	let name = document.getElementById("name").value;
	
	if(name.length<2){
		document.getElementById("nameMessage").innerHTML = "이름은 두글자 이상입니다.";
		return false;
	}else if(name.replace(special, '').length>0){
		document.getElementById("nameMessage").innerHTML = "이름은 영문 또는 한글로만 입력해야합니다.";
		return false;
	}else{
		document.getElementById("nameMessage").innerHTML = "";
		return true;
	}
}
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
function aCheck(){
	let special = /^\d+$/ ;
	let age = document.getElementById("age").value;
	
	if(age.length<1 ||age.length>3){
		document.getElementById("ageMessage").innerHTML = "나이는 1~3글자 입니다.";
		return false;
	}else if(age.replace(special, '').length>0){
		document.getElementById("ageMessage").innerHTML = "나이는 정수로만 입력해 주세요.";
		return false;
	}else{
		document.getElementById("ageMessage").innerHTML = "";
		return true;
	}
}
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
function pCheck(){
	let special = /^\d+(\.\d+)?$/ ;
	let point = document.getElementById("point").value;
	
	if(point<100||point>10000){
		document.getElementById("pointMessage").innerHTML = "포인트는 100~10000사이로만 입력하세요.";
		return false;
	}else if(point.replace(special, '').length>0){
		document.getElementById("pointMessage").innerHTML = "포인트는 실수로  입력하세요.";
		return false;
	}else{
		document.getElementById("pointMessage").innerHTML = "";
		return true;
	}
}
//강사님 코드와 비교
// 6) Point
// => 정수 또는 실수 허용
// => 범위: 100 ~ 10000
// => parseFloat(point)
//        -> 오류 또는 입력값이 없는 경우 NaN return
//        -> 확인 : Number.isNaN(parseFloat(point)) 
//       -> 단, 숫자로 시작하면 뒤쪽에 문자가 섞여있어도 숫자값만 사용함 ( NaN 을 return 하지않음 ) 
function poiCheck() {
    let point=document.getElementById('point').value;
    console.log(` parseFloat(point) => ${parseFloat(point)}`);
    console.log(` Number.isNaN(point) => ${Number.isNaN(point)}`);
    console.log(`** Number.isNaN(parseFloat(point)) => ${Number.isNaN(parseFloat(point))}`);
    
    // => 숫자 아닌값이 있는지 확인, Number.isNaN(...) 적용
    // => 단, 소숫점은 허용
    //    ( 비교값으로 소숫점을 사용하기위해 "\." 으로 표기함 )
    if ( point.replace(/[^0-9.\.]/g,'').length < point.length ||
         Number.isNaN(parseFloat(point)) ) {
        document.getElementById('poMessage').innerHTML='point 는 정수 또는 실수만 입력 하세요.';
        return false;
    }else if(parseFloat(point)<100 || parseFloat(point)>10000) {
        document.getElementById('poMessage').innerHTML='point 값이 범위 (100~10000) 를 벗어납니다.';
        return false;    
    }else {
        document.getElementById('poMessage').innerHTML='';
        return true;
    }
} //poCheck

// BirthDay : 입력 여부 확인  ( length == 10 )
function bCheck(){
	//let special = /^\d+(\.\d+)?$/ ;
	let birthday = document.getElementById("birthday").value;
	
	if(!birthday && birthday.length!==10){
		document.getElementById("birthMessage").innerHTML = "생일 입력이 필요합니다.";
		return false;
	}else{
		document.getElementById("birthMessage").innerHTML = "";
		return true;
	}
}
