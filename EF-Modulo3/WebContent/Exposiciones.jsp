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
		<th>Id</th>
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
		<td>${x.exposicion.id}</td>
		<td>${x.exposicion.nombre}</td>
        <td>${x.exposicion.descripcion}</td>
        <td>${x.exposicion.organiza}</td>
        <td>${x.exposicion.ubicacion}</td>
        <td>${x.exposicion.fechaExpo}</td>
        <td>${x.exposicion.contacto}</td>
        <td class="text-center">
        <a id="tematica" class='btn btn-success btn-xs' data-toggle="modal" data-target="#myModal" onclick="mostrar(${x.exposicion.id});" >
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
          <form class="form-signin" action="Tematicas" method="GET">
          <table id="mytable" class="table table-bordred table-striped">
	<thead>
	<button class="btn btn-primary pull-right" type="submit">
	<span class="glyphicon glyphicon-plus-sign"></span> Cancelar Seleccionados
	</button>
	<tr>
		<th>Id</th>
		<th>IdExpoPar</th>
		<th>Tematica Gral</th>
		<th>Tematica Especif</th>
		<th>Cancelacion</th>
		<th>Fecha Creacion</th>	
		<th><input type="checkbox" id="checkall" />
		</th>		
	</tr>
	</thead>
	<tbody data-bind="foreach: teams">
     <tr>
     		
            <td data-bind="text: id"></td>
            <td data-bind="text: particExpoSocio.id"></td>
            <td data-bind="text: tematicaGeneral.descripcion"></td>
            <td data-bind="text: tematicaEspecifica"></td>
            <td data-bind="text: canceloParticTematica"></td>
            <td data-bind="text: fechaCreacion"></td>
            <td><input type="checkbox" class="checkthis" name="id[]" value="1" /></td>
            
        </tr>
  </tbody>
	</table>
	</form>
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
	<script type="text/javascript" src="js/knockout-min.js"></script>
	
	<script type="text/javascript">
	function mostrar(value){
		var id = value;

		console.log(id);
		
    	$.ajax({
			type:'POST',
			url:'Tematicas',
			dataType: 'json',
			data:'id_expo='+id,
			success:function(data){
				console.log(data);
				ko.applyBindings({
		            teams: data
				
		        });
				
// 				for(var i=0;i<data.length;i++){
// 					//var objeto = JSON.parse(data[i])					
// 					console.log(data[i].id);
// 					console.log(data[i].canceloParticTematica);
// 					console.log(data[i].fechaCreacion);
// 					console.log(data[i].tematicaEspecifica);
// 					console.log(data[i].tematicaGeneral.descripcion);
					
					
// 				}
			} //sucess
        }); //ajax



} //mostrar
 </script>
 

 <script type="text/javascript">
 $(document).ready(function(){
$("#mytable #checkall").click(function () {
        if ($("#mytable #checkall").is(':checked')) {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });
    
    $("[data-toggle=tooltip]").tooltip();
});

 </script>

</body>
</html>