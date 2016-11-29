<%@page import="java.util.ArrayList"%>
<%@page import="py.edu.ucsa.aso.ejb.entities.PagoCuotaSocio"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago de Cuotas Socio</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/table.css" />
</head> 
<body>
  <div class="container">
	<div class="page-header">
	<h1 class="text-center">Pago de Cuotas</h1>
	<h2 class="text-center">Socio: 
	<% ArrayList<PagoCuotaSocio> identificadorSocio = (ArrayList<PagoCuotaSocio>) request.getSession().getAttribute("pagoCuota"); 
		String socioNombre = identificadorSocio.get(0).getSocio().getNombres();
		String socioApellido = identificadorSocio.get(0).getSocio().getApellidos(); 	
		
	%>
	<b><%=socioNombre + " " + socioApellido%></b>
	</h2>
	</div>
	<br>
	<div class="row col-md-9 col-md-offset-2 custyle">
	<table class="table table-striped custab">
	<thead>
	<a href="#" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus-sign"></span> Agregar Pago de Cuota</a>
	<tr>
		<th>Socio</th>
		<th>Anho</th>
		<th>Mes</th>
		<th>Monto</th>
		<th>Estado</th>
		<th>Fecha de Pago</th>
		<th class="text-center">Acciones</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${pagoCuota}" var="x">
	<tr>
		<td><span>${x.socio.nombres}</span> <span>${x.socio.apellidos}</span></td>
        <td>${x.anhoCuota}</td>
        <td>${x.mesCuota}</td>
        <td>${x.montoCuota}</td>
        <td>${x.estado.descripcion}</td>
        <td>${x.fechaPago}</td>
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