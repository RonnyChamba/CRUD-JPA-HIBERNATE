<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Destino | Nuevo</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<c:set var="context" value="<%=application.getContextPath()%>" />

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Nuevo Destino</h1>

			<form:form action="guardar" modelAttribute="nuevoDestino"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<div class="mb-3 col-sm-6">
						<form:label path="lugar">Lugar</form:label>
						<form:input path="lugar" cssClass="form-control" />

					</div>
					<div class="mb-3 col-sm-6">
						<form:label path="ciudad">Ciudad</form:label>
						<form:input path="ciudad" cssClass="form-control"/>

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="pais">Pais</form:label>
						<form:input path="pais" cssClass="form-control" />

					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="direccion">Direccion</form:label>
						<form:input path="direccion" cssClass="form-control" />

					</div>

				   <div class="mb-3">
						<form:label path="tipoViaje.codigo">Tipo Viaje</form:label>
						<form:select path="tipoViaje.codigo" cssClass="form-select" >

							<form:options items="${nuevoDestino.mapTipoViajes}"  />

						</form:select>

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
				<a href=" ${context}/destino">Regresar al menu Destino</a>
			</p>
		</section>
	</div>


</body>
</html>