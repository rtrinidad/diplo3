<%@page import="py.edu.ucsa.aso.ejb.entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Participacion de Exposiciones</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/table.css" />
</head>
<body>
  <div class="container">
	<div class="page-header">
	<h1 class="text-center">Socio: 
	<% Usuario usu = (Usuario) request.getSession().getAttribute("usuario"); 
		String socioNombre = usu.getSocio().getNombres();
		String socioApellido = usu.getSocio().getApellidos(); 	
		
	%>
	<b><%=socioNombre + " " + socioApellido%></b>
	</h1>
	<h1 class="text-center">Participacion de Exposiciones</h1>
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
		<th class="text-center">Tematicas</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${expoSocios}" var="x">
	<tr>
		<td>${x.exposicion.nombre}</td>
        <td>${x.exposicion.descripcion}</td>
        <td>${x.exposicion.organiza}</td>
        <td>${x.exposicion.ubicacion}</td>
        <td>${x.exposicion.fechaExpo}</td>
        <td>${x.exposicion.contacto}</td>
        <td class="text-center">
        <a class='btn btn-success btn-xs' data-toggle="modal" data-target="#myModal">
        		<span class="glyphicon glyphicon-tasks">
        		</span>Tematicas</a>
        </td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
	
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Lista de Tematicas - Exposicion: xxxxx</h4>
        </div>
        <div class="modal-body">
          <table class="table table-striped custab">
	<thead>
	<tr>
		<th>Id</th>
		<th>Tematica General</th>
		<th>Tematica Especifica</th>
		<th>Cancelacion</th>
		<th>Fecha Cancelacion</th>
		<th>Fecha Exposicion</th>		
		<th class="text-center">Acciones</th>
	</tr>
	</thead>
	<tbody>
	</tbody>
	</table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>	
  <!-- Modal -->	
	
	
</div> <!-- Container -->
	<br>
	 <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<script type="text/javascript">
    $("#myModal").click(function(){


//var id=1;
$.ajax({
    data: {id_expo:1},
    dataType: 'json',
    url: 'Tematicas',
    type: 'POST',
    success: function(jsonObj){
        // set value in input text of modal form
       // (#address).val(jsonObj.address); 
       alert(jsonObj); 
    // open modal
        $('#myModal').modal('show');  
    },
    error: function() {
        alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
    }
});

// on hidden reset bootstrap modal

// on close or hidden modal value will be reset
//   $('#myModal').on('hide.bs.modal', function () {

  //    $(this).find('form')[0].reset();
   //})

 });

 </script>
 
</body>
</html>