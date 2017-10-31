<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tambah Person</title>
</head>
<body>
	<h2>Tambah Person</h2>
	 <form:form action="tambah" method="post" modelAttribute="person">
		<table>
			<tr>
				<td>Nama Depan</td>
				<td><form:input path="namaDepan" /></td>
				<td><form:errors path="namaDepan" /></td>
			</tr>
			<tr>
				<td>Nama Belakang</td>
				<td><form:input path="namaBelakang" /></td>
				<td><form:errors path="namaBelakang" /></td>
			</tr>
			<tr>
				<form:hidden path="id" />
				<td><input type="submit" value="simpan" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form:form>
</body>
</html>