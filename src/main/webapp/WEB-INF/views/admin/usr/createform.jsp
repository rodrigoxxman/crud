<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Crear usuario</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-4">
				<h4 class="text-center">Registro de Inmueble</h4>
				<hr>
				<form:form method="post" action="/rentainmuebles/save">
					
					<form:hidden path="idusuario" class="form-control"/>
					
					<div class="form-group">
						<label for="direccion">direccion: </label>
						<form:input path="direccion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="coordenadas_dic">coordenadas: </label>
						<form:password path="coordenadas_dic" class="form-control" />
					</div>
					<div class="form-group">
						<label for="foto">foto: </label>
						<form:input path="foto" class="form-control" />
					</div>
					<div class="form-group">
						<label for="descripcion">descripcion: </label>
						<form:input path="descripcion" class="form-control" />
					</div>
					<div class="form-group">
						<label for="tipo_costo">tipo de pago: </label>
						<form:input path="tipo_costo" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="costo">costo: </label>
						 <form:input path="costo" class="form-control" />
 					</div>
 					<div class="form-group">
						<label for="capacidad_max">capacidad max: </label>
						 <form:input path="capacidad_max" class="form-control" />
 					</div>
 					<div class="form-group">
						<label for="tipo_inmueble">tipo de inmueble: </label>
						 <form:input path="tipo_inmueble" class="form-control" />
 					</div>
 					<div class="form-group">
						<label for="estado">estado: </label>
						 <form:input path="estado" class="form-control" />
 					</div>
 					<div class="form-group">
						<label for="usuarios_idusuario">id usuario: </label>
						 <form:input path="usuarios_idusuario" class="form-control" />
 					</div>
 					<div class="form-group">
						<label for="ranking_idranking">ranking: </label>
						 <form:input path="ranking_idranking" class="form-control" />
 					</div>
					<div class="form-group">
						<input type="submit" value="Register" class="btn btn-success" />
					</div>
					<a href="<%=request.getContextPath()%>/"
					class="btn btn-danger"><i class="glyphicon glyphicon-arrow-left"></i>
					Cancelar</a>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>