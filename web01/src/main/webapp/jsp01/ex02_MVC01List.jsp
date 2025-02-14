
<%@page import="java.util.List"%>
<%@page import="mvcTest.StudentDTO,mvcTest.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSP Student List_ MVC01**</title>
</head>
<body>
	<h1>** JSP Student List_ MVC01**</h1>
	<h3>=> Service -> 결과 -> 출력</h3>
	<%
	StudentService service = new StudentService();
	List<StudentDTO> list = service.selectList();
	%>
	<table border=1>
		<tr>
			<th>Sno</th>
			<th>Name</th>
			<th>Age</th>
			<th>Jno</th>
			<th>Info</th>
			<th>Point</th>
			<th>Birhday</th>
			<th>Now</th>
		</tr>
		<%
		if(list !=null){
		for(StudentDTO s:list){%>
			<tr>
			<th><%=s.getSno() %></th>
			<th><%=s.getName() %></th>
			<th><%=s.getAge() %></th>
			<th><%=s.getJno() %></th>
			<th><%=s.getInfo() %></th>
			<th><%=s.getPoint() %></th>
			<th><%=s.getBirthday() %></th>
			<th><%=s.getNow() %></th>
			</tr>
		<% }//for
		}else{
		%> 출력할 자료가 없습니다.
		<%} //if , else %>

	</table>
</body>
</html>