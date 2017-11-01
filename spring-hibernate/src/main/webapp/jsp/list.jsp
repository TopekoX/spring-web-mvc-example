<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Halo</title>
</head>
<body>
	<h1>Daftar Person</h1>
	<a href="${pageContext.request.contextPath}/tambah">Tambah Person</a>
	<div>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nama Depan</th>
				<th>Nama Belakang</th>
				<th colspan="2">Action</th>			
			</tr>
			<c:forEach items="${list}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.namaDepan}</td>
					<td>${person.namaBelakang}</td>
					<td><a href="${pageContext.request.contextPath}/tambah?id=${person.id}">Edit</a></td>
					<td><a href="${pageContext.request.contextPath}/hapus?id=${person.id}">Hapus</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>