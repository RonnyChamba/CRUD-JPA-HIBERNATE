<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tipo Viajes | Actualizar</title>
<link href="../static/bootstrap-5/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
<c:set var="context"  value="<%=application.getContextPath() %>"/>

	<div class="container-fluid">

		<section class="content"
			style="max-width: 1200px; margin-left: auto; margin-right: auto">

			<h1 class="text-center mb-5">Actualizar Tipo Transporte</h1>
			
			<form:form action="actualizarTipoTransporte" modelAttribute="datosTipoTransporte"
				method="post"
				cssStyle="max-width:500px; margin-left:auto;margin-right:auto">
				<div class="row">

					<form:input path="codigo" type="hidden" />
					
					<div class="mb-3 col-sm-6">
						<form:label path="tipo">Tipo</form:label>
						<form:input path="tipo" cssClass="form-control" />

					</div>
	
					<div class="mb-3 col-sm-6">
						<form:label path="asientos">Asientos</form:label>
						<form:input path="asientos" cssClass="form-control"  type="number"/>

					</div>

					

					<div class="mb-3 mt-3 d-flex justify-content-between align-items-center">

					<input type="submit" value="Guardar" class="btn btn-primary" style="width:150px">
					<input type="reset" value="Cancelar" class="btn btn-secondary" style="width:150px">
				</div>
				</div>

			</form:form>
			<p class ="mt-3" > <a href=" ${context}/tipoTransporte">Regresar al menu Tipo Transporte</a> </p>
		</section>
	</div>


</body>
</html>