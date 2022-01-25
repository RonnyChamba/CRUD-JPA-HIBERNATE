<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tipo Viaje</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<div class="container-fluid text-center p-2">

		<h1>Tipos de Viajes</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de tipos viajes</h2>
			<a href="tipoViaje/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Codigo</th>
					    <th>Tipo</th>
					    <th>Precio</th>
					    <th>Descripcion</th>
					    <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="tipoViaje" items="${listTipoViajes}">
					
					<tr>
					
						<td> <c:out value="${tipoViaje.codigo}"/> </td>
						<td> <c:out value="${tipoViaje.tipo}"/> </td>
						<td> <c:out value="${tipoViaje.precio}"/> </td>
						<td> <c:out value="${tipoViaje.descripcion}"/> </td>
					
						<td class ="text-end"> <a href ="tipoViaje/edit?codigo=${tipoViaje.codigo}" class ="btn btn-info">Update</a> <a href="tipoViaje/delete?codigo=${tipoViaje.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>



	</div>


</body>
</html>