<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Licencia</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<c:set var="context" value="<%=application.getContextPath()%>" />

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">
				Actualizar Licencia |
				<c:out value="${datosLicencia.conductor.nombre} ${datosLicencia.conductor.apellido}" />
			</h1>

			<form:form action="actualizarLicencia" method="post"
				modelAttribute="datosLicencia"
				cssStyle="max-width:auto;margin-left:auto;margin-right:auto">

				<div class="row justify-content-center">
					<form:input path="codigo" cssClass="form-control"
						type="hidden" />
				<%-- 	<form:input path="conductor" cssClass="form-control" type="hidden" /> --%>

					<div class="mb-3 col-sm-3">
						<form:label path="tipo">Tipo</form:label>
						<form:input path="tipo" cssClass="form-control"
							placeholder="A,B,C.." />

					</div>
					<div class="mb-3 col-sm-3">
						<form:label path="fechaExpedicion">Fecha Inicio</form:label>
						<form:input path="fechaExpedicion" type="date"
							cssClass="form-control" />

					</div>

					<div class="mb-3 col-sm-3">
						<form:label path="fechaExpiracion">Fecha Fin</form:label>
						<form:input path="fechaExpiracion" type="date"
							cssClass="form-control" />

					</div>

					<div
						class="mb-3 mt-3 d-flex align-items-center justify-content-center">

						<input type="submit" value="Guardar"
							class="btn btn-primary me-3" style="width: 150px"> <input
							type="reset" value="Cancelar" class="btn btn-secondary ms-3"
							style="width: 150px">
					</div>
					
					<form:input path="conductor.codigo" cssClass="form-control" />

				</div>
			</form:form>
			
			<p>Conductor: <c:out value="${conductor}"/> </p>
			<p class="mt-3">
				<a href=" ${context}/licencia?codigo=${conductor.codigo}">Ver mis licencias</a>
			</p>
		</section>
	</div>

</body>
</html>