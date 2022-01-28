<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

	<c:set var="context" value="<%=application.getContextPath()%>" />
	<div class="container-fluid text-center p-2">

		<h1>Empleados</h1>
		<div class="mt-5">

			<div class="d-flex justify-content-between align-items-center">
				<h2 class="text-start">Lista de empleado</h2>
				<a   href ="empleado/nuevo" class="btn btn-primary"  style="width: 150px">Nuevo</a>
			</div>

			<table class="table">

				<thead class="table-dark">

					<tr>
					
						<th>Cedula</th>
						<th>Empleado</th>
						<th>Direccion</th>
						<th>Edad</th>
						<th>Estado</th>
						<th>Telefono</th>
						<th>Sueldo</th>
						<th></th>

					</tr>
				</thead>
				<tbody>

					<c:forEach var="empleado" items="${listEmpleados}">

						<tr>

							<td><c:out value="${empleado.cedula}" /></td>
							<td><c:out value="${empleado.nombre} ${empleado.apellido}" />
							</td>
							<td><c:out value="${empleado.direccion}" /></td>
							<td><c:out value="${empleado.edad}" /></td>
							<td><c:out value="${empleado.estadoCivil}" /></td>
							<td><c:out value="${empleado.telefono}" /></td>
							<td><c:out value="${empleado.salario}" /></td>
							<td class="text-end"><a
								href="empleado/edit?codigo=${empleado.codigo}" class="btn btn-info">Update</a>
								<a href="empleado/delete?codigo=${empleado.codigo}"
								class="btn btn-danger">Delete</a></td>

						</tr>


					</c:forEach>

				</tbody>


			</table>
		</div>

	<p class="mt-3"> <a href=" ${context}/index.jsp">Volver al menu principal</a> </p>

	</div>
</body>
</html>