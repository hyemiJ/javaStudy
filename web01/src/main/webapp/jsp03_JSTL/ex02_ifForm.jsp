<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**JSTL if test Form **</title>
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
<h2>🐻 JSTL if Test Form 🐻</h2>
<form action="ex02_ifMain.jsp" method="get">
    <select name="color">
        <option value=""  hidden="">color를 선택하세요</option>
        <option value="1">Red</option>
        <option value="2">Green</option>
        <option value="3">Blue</option>
        <option value="4">Yellow</option>
        <option value="5">Error</option>
    </select>
    <input type="submit" value="전송">
</form>
</body>
</html>