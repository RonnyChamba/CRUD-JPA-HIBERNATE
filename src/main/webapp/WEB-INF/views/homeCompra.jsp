<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compra</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

	<c:set var="context" value="<%=application.getContextPath()%>" />

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Venta de boletos</h1>

			<form:form action="compra/guardar" modelAttribute="nuevaCompra"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<div class="mb-3 col-sm-6">
						<form:label path="numBoletos">Numero boletos</form:label>
						<form:input path="numBoletos" cssClass="form-control"
							type="number"  id="numBoletos" />

					</div>
					<div class="mb-3 col-sm-6">
						<form:label path="fecha">Fecha</form:label>
						<form:input path="fecha" cssClass="form-control" type="date" />

					</div>


					<div class="mb-3 col-sm-6">
						
						<form:label path="cliente.codigo">Cliente</form:label>
						<form:select path="cliente.codigo" cssClass="form-select">

							<form:options items="${nuevaCompra.mapClientes}" />

						</form:select>

					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="destino.codigo">Destino</form:label>
						<form:select path="destino.codigo" cssClass="form-select" id="destino-js">

						<%-- 	<form:options items="${nuevaCompra.mapDestinos}" /> --%>
						<c:forEach items="${nuevaCompra.listDestinos}" var="itemDestino">
						
						<form:option value="${itemDestino.codigo}" data-precio = "${itemDestino.tipoViaje.precio}"> <c:out value="${itemDestino.lugar} $ ${itemDestino.tipoViaje.precio}"/> </form:option>
							
						</c:forEach>
						
						</form:select>

					</div>
					
					<div class="mb-3 col-sm-6">
						
						<form:label path="empleado.codigo">Empleado</form:label>
						<form:select path="empleado.codigo" cssClass="form-select">

							<form:options items="${nuevaCompra.mapEmpleados}" />

						</form:select>

					</div>
					
					
					<div class="mb-3 col-sm-6">
						
						<form:label path="transporte.codigo">Transporte</form:label>
						<form:select path="transporte.codigo" cssClass="form-select" >

							<form:options items="${nuevaCompra.mapTransportes}" />

						</form:select>

					</div>
					
					
					<div class="mb-3">
						<form:label path="factura.observacion">Observacion</form:label>
						<form:input path="factura.observacion" cssClass="form-control" />
					</div>
					
					
					<div class="mb-3 col-sm-6">
						<form:label path="factura.subtotal">Subtotal</form:label>
						<form:input path="factura.subtotal" cssClass="form-control" readonly="true" id="subtotal" />
					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="factura.total">Total +(12%)</form:label>
						<form:input path="factura.total" cssClass="form-control"  readonly="true" id="total"  />
					</div>
					
					<div
						class="mb-3 mt-3 d-flex justify-content-between align-items-center">

						<input type="submit" value="Registrar" class="btn btn-primary"
							style="width: 150px"> <input type="reset"
							value="Cancelar" class="btn btn-secondary" style="width: 150px">
					</div>
				</div>
				
			</form:form>
			<p class="mt-3">
				<a href=" ${context}/factura">Ver ordenes de compra</a>
			</p>
		</section>
	</div>

<script type="text/javascript" src="static/js/compra.js" ></script>
</body>
</html>