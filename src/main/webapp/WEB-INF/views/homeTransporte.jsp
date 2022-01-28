<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transporte</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

<div class="container-fluid text-center p-2">

	<c:set var="context" value="<%=application.getContextPath()%>" />
		<h1>Transportes</h1>
		<div class ="mt-5">
		
		<div class ="d-flex justify-content-between align-items-center">
		
			<h2 class="text-start">Lista de Transportes</h2>
			<a href="transporte/nuevo" class ="btn btn-primary" style="width: 150px">Nuevo</a>
		
		</div>
		
			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
					    <th>Codigo</th>
					    <th>Matricula</th>
					    <th>Color</th>
					    <th>Año</th>
					    <th>Tipo</th>
					    <th>Conductor</th>
					    <th></th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="transporte" items="${listTransportes}">
					
					<tr>
					
						<td> <c:out value="${transporte.codigo}"/> </td>
						<td> <c:out value="${transporte.matricula}"/> </td>
						<td> <c:out value="${transporte.color}"/> </td>
						<td> <c:out value="${transporte.agnioFabricacion}"/> </td>
						<td> <c:out value="${transporte.tipoTransporte.tipo}"/> </td>
						<td> <c:out value="${transporte.conductor.nombre} ${transporte.conductor.apellido}"/> </td>
						<td class ="text-end"> <a href ="transporte/edit?codigo=${transporte.codigo}" class ="btn btn-info">Update</a> <a href="transporte/delete?codigo=${transporte.codigo}" class ="btn btn-danger">Delete</a>  </td>
					
					</tr>
					</c:forEach>
				
				</tbody>
				
				
			</table>
		</div>


	<p class=""> <a href=" ${context}/index.jsp">Volver al menu principal</a> </p>
	</div>

</body>
</html>