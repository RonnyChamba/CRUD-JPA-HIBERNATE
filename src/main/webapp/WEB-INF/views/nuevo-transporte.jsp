<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transporte | Nuevo</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

<c:set var="context"  value="<%=application.getContextPath() %>"/>

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Nuevo Transporte</h1>
			
			<form:form action="guardar" modelAttribute="nuevoTransporte"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<div class="mb-3 col-sm-6">
						<form:label path="matricula">Matricula</form:label>
						<form:input path="matricula" cssClass="form-control" />

					</div>
	
					<div class="mb-3 col-sm-6">
						<form:label path="color">Color</form:label>
						<form:input path="color" cssClass="form-control" />

					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="agnioFabricacion">Año fabricacion</form:label>
						<form:input path="agnioFabricacion" cssClass="form-control" />

					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="tipoTransporte.codigo">Tipo</form:label>
						<form:select path="tipoTransporte.codigo" cssClass="form-select">

							<form:options items="${nuevoTransporte.mapTransportes}" />

						</form:select>

					</div>
					
					<div class="mb-3 col-sm-6">
						<form:label path="conductor.codigo">Conductor</form:label>
						<form:select path="conductor.codigo" cssClass="form-select">

							<form:options items="${nuevoTransporte.mapConductores}" />

						</form:select>

					</div>
					
					<div class="mb-3 mt-3 d-flex justify-content-between align-items-center">

					<input type="submit" value="Registrar" class="btn btn-primary" style="width:150px">
					<input type="reset" value="Cancelar" class="btn btn-secondary" style="width:150px">
				</div>
				</div>

			</form:form>
			<p class ="mt-3" > <a href=" ${context}/transporte">Regresar al menu Transporte</a> </p>
		</section>
	</div>


</body>
</html>