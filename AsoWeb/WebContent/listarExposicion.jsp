<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Exposiciones</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
  <div class="container">
	<div class="page-header">
	<h1 class="text-center">Lista de Exposiciones</h1>
	</div>
	<br>
	<div class="row col-md-9 col-md-offset-2 custyle">
	<table class="table table-striped custab">
	<thead>
	<tr>
		<th>Nombre</th>
		<th>Descripcion</th>
		<th>Organizacion</th>
		<th>ubicacion</th>
		<th>Fecha Exposicion</th>
		<th>Contacto</th>
		<th class="text-center">Acciones</th>
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
        <td class="text-center" colspan="2">
        	<a class='btn btn-info btn-xs' href="#">
        		<span class="glyphicon glyphicon-edit">
        		</span>Editar</a> <a href="#" class="btn btn-danger btn-xs">
        		<span class="glyphicon glyphicon-remove">
        		</span>Eliminar</a>
        </td>		
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
</div>
	<br>
	 <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>