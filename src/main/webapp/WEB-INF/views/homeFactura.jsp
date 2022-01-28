<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orden de Compras</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	
		<c:set var="context" value="<%=application.getContextPath()%>" />
	<div class="container-fluid text-center p-2">

		<h1>Ordenes de Compras</h1>
		<div class="mt-5">

			<div class="d-flex justify-content-between align-items-center">
				<h2 class="text-start">Lista de Compras</h2>
				<a href="compra" class="btn btn-primary"
					style="width: 150px">Nueva Compra</a>
			</div>

			<table class="table">

				<thead class="table-dark">

					<tr>

						<th>Id</th>
						<th>Fecha Viaje</th>
						<th>Boletos</th>
						<th>Precio C/U</th>
						<th>Cliente</th>
						<th>Empleado</th>
						<th>Destino</th>
						<th>Transporte</th>
						<th>Observación</th>
						<th>Subtotal</th>
						<th>Total</th>
						<th></th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="factura" items="${listFacturas}">

						<tr>

							<td><c:out value="${factura.compra.codigo}" /></td>
							<td><c:out value="${factura.compra.fecha}" /></td>
							<td><c:out value="${factura.compra.numBoletos}" /></td>
							<td><c:out value="${factura.compra.destino.tipoViaje.precio}" /></td>
							<td><c:out value="${factura.compra.cliente.nombre} ${factura.compra.cliente.apellido}" /></td>
							<td><c:out value="${factura.compra.empleado.nombre} ${factura.compra.empleado.apellido}" /></td>
							<td><c:out value="${factura.compra.destino.lugar}" /></td>
							<td><c:out value="${factura.compra.transporte.tipoTransporte.tipo}" /></td>
							<td><c:out value="${factura.observacion}" /></td>
							<td><c:out value="${factura.subtotal}" /></td>
							<td><c:out value="${factura.total}" /></td>
							<td class="text-end"> <a
								href="factura/delete?codigo=${factura.codigo}"
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