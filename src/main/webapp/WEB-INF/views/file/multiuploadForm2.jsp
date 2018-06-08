<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/file/multiupload2.do" method="post"
	enctype="multipart/form-data">

	<!-- multiple 속성을 부여하면 type="file" 한 개로 여러파일 전송 가능 (HTML5) -->
	<input type="file" name="upload" multiple />

	<button>전송</button>

</form>

</body>
</html>