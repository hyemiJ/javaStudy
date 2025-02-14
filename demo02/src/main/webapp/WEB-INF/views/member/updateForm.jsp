<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Update Form **</title>
</head>
<body>
<h2>** Web MVC2 UpdateForm **</h2>
<form action="mupdate" method="post" enctype="multipart/form-data" >
<table style="margin: auto;">
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="id">I D</label></td>
		<td><input type="text" name="id" id="id" value="${requestScope.apple.id}" readonly size="20"></td>
				<!-- id: 화면출력, 서버로 전송, 수정은불가(즉, input Tag 의 입력 막기) 
				 -> readonly: 서버로 전송 (권장)
				 -> disabled: 서버로 전송되지않음
				-->
	</tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="password">Password</label></td>
		<td><input type="password" name="password" id="password" value="${requestScope.apple.password}" readonly size="20"></td>
	</tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="name">Name</label></td>
		<td><input type="text" name="name" id="name" value="${requestScope.apple.name}" size="20"></td>
	</tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="age">Age</label></td>
		<td><input type="text" name="age" id="age" value="${requestScope.apple.age}" size="20"></td>
	</tr>
		<tr height="40">
		<td bgcolor="#a0b4f0"><label for="jno">Jno</label></td>
		<td><select name="jno" id="jno">
		
				<c:forEach var="jo" items="${joSelectAll}" >
				<option value="${jo.jno}" ${apple.jno==jo.jno ? "selected":""}>${jo.jno} 조 : ${jo.jname} </option>
				</c:forEach>
				<%-- <option value="1" ${apple.jno==1 ? "selected":""}>1조: 우린팀이니까</option>
				<option value="2" ${apple.jno==2 ? "selected":""}>2조: 모꼬지</option>
				<option value="3" ${apple.jno==3 ? "selected":""}>3조: Object Of Coding</option>
				<option value="4" ${apple.jno==4 ? "selected":""}>4조: 컴포NaN트</option>
				<option value="7" ${apple.jno==7 ? "selected":""}>7조: 칠면조(관리팀)</option> --%>
			</select></td></tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="info">Info</label></td>
		<td><input type="text" name="info" id="info" value="${requestScope.apple.info}" size="20"></td>
	</tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="point">Point</label></td>
		<td><input type="text" name="point" id="point" value="${requestScope.apple.point}" size="20"></td>
	</tr>
	<tr height="40">
		<td bgcolor="#a0b4f0"><label for="birthday">Birthday</label></td>
		<td><input type="date" name="birthday" id="birthday" value="${requestScope.apple.birthday}"></td>
	</tr>
		<tr height="40">
		<td bgcolor="#a0b4f0"><label for="rid">추천인</label></td>
		<td><input type="text" name="rid" id="rid" value="${requestScope.apple.rid}" size="20"></td>
	</tr>
		
	<tr height="40">
		<td bgcolor="#bcdeff"><label for="uploadfilef">image</label></td>
		    <!-- File Update 기능추가 
            => form Tag : method, enctype 확인
            => new Image 를 선택하는 경우 -> uploadfilef 사용
            => new Image 를 선택하지않는 경우 
                -> 본래 Image 를 사용 -> uploadfile 값이 필요함 (hidden 으로 보관)    
    		-->
		<td>
		<img alt="myimage" src="/resources/uploadImages/${apple.uploadfile}" class="select_img" width="80" height="100"><br>
		<input type="file" name="uploadfilef" id="uploadfilef" size="20">
		<input type="hidden" name="uploadfile" value="${apple.uploadfile}">
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
	<tr><td></td>
		<td><input type="submit" value="수정">&nbsp;&nbsp;
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