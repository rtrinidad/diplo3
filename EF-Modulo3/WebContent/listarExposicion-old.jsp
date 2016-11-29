<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Exposiciones</title>
</head>
<body>
	<h1>Lista de Exposiciones</h1>
	<br>
	<table border=1 align=center bgcolor=#F0F8FF>
	<thead>
	<tr>
		<th>Nombre</th>
		<th>Descripcion</th>
		<th>Organizacion</th>
		<th>ubicacion</th>
		<th>Fecha Exposicion</th>
		<th>Contacto</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${exposicion}" var="x">
	<tr>
		<td>${x.nombre}</td>
        <td>${x.descripcion}</td>
        <td>${x.organiza}</td>
        <td>${x.ubicacion}</td>
        <td>${x.fechaExpo}</td>
        <td>${x.contacto}</td>		
	</tr>
	</c:forEach>
	</tbody>
	</table>
	<br>
</body>
</html>