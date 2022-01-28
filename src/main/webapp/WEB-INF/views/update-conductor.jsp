<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conductor | Actualizar</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
<c:set var="context"  value="<%=application.getContextPath() %>"/>

	<div class="container-fluid text-center p-2">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Actualizar Conductor</h1>
			
			<form:form action="actualizarConductor" modelAttribute="datosConductor"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<form:input path="codigo" type="hidden" /> 

					<div class="mb-3 col-sm-6">
						<form:label path="cedula">Cedula</form:label>
						<form:input path="cedula" cssClass="form-control"   readonly="true"/>

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
						<form:label path="telefono">Telefono</form:label>
						<form:input path="telefono" cssClass="form-control" />

					</div>

					
					
					<div class="mb-3 mt-3 d-flex justify-content-between align-items-center">

					<input type="submit" value="Guardar" class="btn btn-primary" style="width:150px">
					<input type="reset" value="Cancelar" class="btn btn-secondary" style="width:150px">
				</div>
				</div>

			</form:form>
			
		</section>
		<div class="row">
		
			<p class="col-sm-6"> <a href="${context}/index.jsp">Volver al menu principal</a> </p>
			<p class="col-sm-6"> <a href="${context}/conductor">Volver al menu Conductor</a> </p>
		</div>
	</div>

</body>
</html>