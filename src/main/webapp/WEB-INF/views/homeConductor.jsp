<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conductor</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<div class="container-fluid text-center p-2">

		<h1>Conductores</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de conductores</h2>
			<a href="conductor/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Cedula</th>
					    <th>Conductor</th>
					    <th>Telefono</th>
					    <th></th>
					     <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="conductor" items="${listConductores}">
					
					<tr>
					
						<td> <c:out  value="${conductor.cedula}"/> </td>
						<td> <c:out value="${conductor.nombre} ${conductor.apellido}"/> </td>
						<td> <c:out value="${conductor.telefono}"/> </td>
					
						<td class ="text-end"> <a href ="licencia?codigo=${conductor.codigo}" class ="btn btn-success">Licencias</a> </td>
						<td class ="text-end"> <a href ="conductor/edit?codigo=${conductor.codigo}" class ="btn btn-info">Update</a> <a href="conductor/delete?codigo=${conductor.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>



	</div>


</body>
</html>