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
<div class="datagrid">
	<table>
		<tr>
			<th>ID</th>
			<th>Nama Depan</th>
			<th>Nama Belakang</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.namaDepan}</td>
				<td>${list.namaBelakang}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>