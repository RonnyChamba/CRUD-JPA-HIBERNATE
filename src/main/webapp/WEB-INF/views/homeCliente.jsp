<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<div class="container-fluid text-center p-2">

		<h1>Clientes</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de clientes</h2>
			<a href="cliente/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Cedula</th>
					    <th>Cliente</th>
					    <th>Direccion</th>
					    <th>Edad</th>
					    <th>Estado</th>
					    <th>Telefono</th>
					    <th>Nacionalidad</th>
					    <th>Estudios</th>
					    <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach  var="cliente" items="${listClientes}">
					
					<tr>
					
						<td> <c:out value="${cliente.cedula}"/> </td>
						<td> <c:out value="${cliente.nombre} ${cliente.apellido}"/> </td>
						<td> <c:out value="${cliente.direccion}"/> </td>
						<td> <c:out value="${cliente.edad}"/> </td>
						<td> <c:out value="${cliente.estadoCivil}"/> </td>
						<td> <c:out value="${cliente.telefono}"/> </td>
						<td> <c:out value="${cliente.nacionalidad}"/> </td>
						<td> <c:out value="${cliente.estudiosRealizados}"/> </td>
						<td class ="text-end"> <a href ="cliente/edit?codigo=${cliente.codigo}" class ="btn btn-info">Update</a> <a href="cliente/delete?codigo=${cliente.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>



	</div>
</body>
</html>