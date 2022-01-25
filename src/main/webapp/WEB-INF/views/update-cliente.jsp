<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente | Actualizar</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
<c:set var="context"  value="<%=application.getContextPath() %>"/> 

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Actualizar Cliente</h1>
			
			<form:form action="actualizarCliente" modelAttribute="datosCliente"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">
						
						<form:input path="codigo"   type="hidden"/>

					<div class="mb-3 col-sm-6">
						<form:label path="cedula">Cedula</form:label>
						<form:input path="cedula" cssClass="form-control" readonly="true" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="nombre">Nombre</form:label>
						<form:input path="nombre" cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="apellido">Apellido</form:label>
						<form:input path="apellido" cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="direccion">Direccion</form:label>
						<form:input path="direccion" cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="edad">Edad</form:label>
						<form:input path="edad" cssClass="form-control" type="number" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="telefono">Telefono</form:label>
						<form:input path="telefono" cssClass="form-control" />

					</div>

					<div class="mb-3">
						<form:label path="nacionalidad">Nacionalidad</form:label>
						<form:input path="nacionalidad" cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="estudiosRealizados">Estudios</form:label>
						<form:input path="estudiosRealizados" cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-6">
						<form:label path="estadoCivil">Estado</form:label>
						<form:select path="estadoCivil" cssClass="form-select">

							<form:options items="${datosCliente.tiposEstados}" />

						</form:select>

					</div>
					
					<div class="mb-3 mt-3 d-flex justify-content-between align-items-center">

					<input type="submit" value="Guardar" class="btn btn-primary" style="width:150px">
					<input type="reset" value="Cancelar" class="btn btn-secondary" style="width:150px">
				</div>
				</div>

			</form:form>
			<p class ="mt-3" > <a href=" ${context}/cliente">Regresar al menu Cliente</a> </p>
		</section>
	</div>

</body>
</html>