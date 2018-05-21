<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<h1>파일 업로드 폼</h1>

<form action="/file/fileup.do" method="post" enctype="multipart/form-data">
	<label for="file">첨부파일</label>
	<input type="file" id="file" name="file" /><br><br>
	<button>전송</button>	
</form>

</div>

</body>
</html>