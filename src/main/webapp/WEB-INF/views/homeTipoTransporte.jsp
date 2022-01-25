<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tipo Transporte</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>


	<div class="container-fluid text-center p-2">

		<h1>Tipos de Transportes</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de tipos transportes</h2>
			<a href="tipoTransporte/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Codigo</th>
					    <th>Tipo</th>
					    <th>Asientos</th>
					    <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="tipoTransporte" items="${listTipoTransportes}">
					
					<tr>
					
						<td> <c:out value="${tipoTransporte.codigo}"/> </td>
						<td> <c:out value="${tipoTransporte.tipo}"/> </td>
						<td> <c:out value="${tipoTransporte.asientos}"/> </td>
						
						<td class ="text-end"> <a href ="tipoTransporte/edit?codigo=${tipoTransporte.codigo}" class ="btn btn-info">Update</a> <a href="tipoTransporte/delete?codigo=${tipoTransporte.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>



	</div>


</body>
</html>