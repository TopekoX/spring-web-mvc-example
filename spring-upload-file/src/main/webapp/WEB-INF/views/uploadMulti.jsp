<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Spring MVC multi files upload example</h1>

	<form method="POST" action="${pageContext.request.contextPath}/uploadMulti" enctype="multipart/form-data">
		<input type="file" name="files" /><br /> 
		<input type="file" name="files" /><br /> 
		<input type="file" name="files" /><br /> 
		<input type="submit" value="Submit" />
	</form>

</body>
</html>