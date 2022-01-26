<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Destino</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<div class="container-fluid text-center p-2">

		<h1>Tipos de Destinos</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de Destinos</h2>
			<a href="destino/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Codigo</th>
					    <th>Lugar</th>
					    <th>Direccion</th>
					    <th>Ciudad</th>
					    <th>Pais</th>
					    <th>Tipo</th>
					    <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="destino" items="${listDestinos}">
					
					<tr>
					
						<td> <c:out value="${destino.codigo}"/> </td>
						<td> <c:out value="${destino.lugar}"/> </td>
						<td> <c:out value="${destino.direccion}"/> </td>
						<td> <c:out value="${destino.ciudad}"/> </td>
						<td> <c:out value="${destino.pais}"/> </td>
						<td> <c:out value="${destino.tipoViaje.tipo}"/> </td>
						
						<td class ="text-end"> <a href ="destino/edit?codigo=${destino.codigo}" class ="btn btn-info">Update</a> <a href="destino/delete?codigo=${destino.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>



	</div>


</body>
</html>