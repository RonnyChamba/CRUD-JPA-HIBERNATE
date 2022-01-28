<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado | Nuevo</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<c:set var="context" value="<%=application.getContextPath()%>" />

	<div class="container-fluid text-center p-2">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Nuevo Empleado</h1>

			<form:form action="guardar" modelAttribute="nuevoEmpleado"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<div class="mb-3 col-sm-6">
						<form:label path="cedula">Cedula</form:label>
						<form:input path="cedula" cssClass="form-control" />

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

					<div class="mb-3 col-sm-6">
						<form:label path="salario">Salario</form:label>
						<form:input path="salario" cssClass="form-control" type="number" />

					</div>


					<div class="mb-3 col-sm-6">
						<form:label path="estadoCivil">Estado</form:label>
						<form:select path="estadoCivil" cssClass="form-select">

							<form:options items="${nuevoEmpleado.tiposEstados}" />

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
		</section>
		<div class="row">
		
			<p class="col-sm-6"> <a href="${context}/index.jsp">Volver al menu principal</a> </p>
			<p class="col-sm-6"> <a href="${context}/empleado">Volver al menu Empleado</a> </p>
		</div>
	</div>



</body>
</html>