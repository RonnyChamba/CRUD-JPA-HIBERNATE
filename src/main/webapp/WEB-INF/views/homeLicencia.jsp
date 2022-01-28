<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Licencia</title>
<link href="static/bootstrap-5/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>

	<c:set var="context" value="<%=application.getContextPath()%>" />
	
	<div class="container-fluid text-center p-2">
		<h1>Licencias | <c:out value="${nuevaLicencia.conductor.nombre} ${nuevaLicencia.conductor.apellido} "/> </h1>
		
		<div class="mt-5">
			<form:form action="licencia/guardar" method="post"
				modelAttribute="nuevaLicencia"
				cssStyle="margin-left:auto;margin-right:auto">

				<div class="row justify-content-center">
						<form:input path="conductor.codigo" cssClass="form-control"  type="hidden"/>

					<div class="mb-3 col-sm-3">
						<form:label path="tipo">Tipo</form:label>
						<form:input path="tipo" cssClass="form-control"  placeholder="A,B,C.."/>

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

						<input type="submit" value="Registrar" class="btn btn-primary me-3"
							style="width: 150px"> <input type="reset"
							value="Cancelar" class="btn btn-secondary ms-3" style="width: 150px">
					</div>


				</div>
				
			</form:form>


			<div class="">

				<h2 class="text-start">Lista de mis Licencias</h2>
			</div>

			<table class="table table-hover">

				<thead class="table-dark">

					<tr>
						<th>Codigo</th>
						<th>Tipo</th>
						<th>Fecha Expedicion</th>
						<th>Fecha Expiracion</th>
						<th></th>

					</tr>
				</thead>
				<tbody>

					<c:forEach  var="licencia" items="${listLicencias}">

						<tr>

							<td><c:out value="${licencia.codigo}" /></td>
							<td><c:out value="${licencia.tipo}" />
							</td>
							<td><c:out value="${licencia.fechaExpedicion}" /></td>
							<td><c:out value="${licencia.fechaExpiracion}" /></td>
							<td class="text-end"><a
								href="licencia/edit?codigo=${licencia.codigo}"
								class="btn btn-info">Update</a> <a
								href="licencia/delete?codigo=${licencia.codigo}"
								class="btn btn-danger">Delete</a></td>

						</tr>
					</c:forEach>

				</tbody>


			</table>
		</div>

		<div class="row">
		
			<p class="col-sm-6"> <a href="${context}/index.jsp">Volver al menu principal</a> </p>
			<p class="col-sm-6"> <a href="conductor">Ver conductores</a> </p>
		</div>

	</div>



</body>
</html>