<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>INMUEBLES</title>
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
			<div class="col-md-8">
				<h4 class="text-center">INMUEBLES</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Login</th>
							<th>Password</th>
							<th>Firstname</th>
							<th>Lastname</th>
							<th>Salary</th>
							<!--  th>Dept</th -->
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="emp" items="${inmueble}">
							<tr>
								<td>${emp.idinmueble}</td>
								<td>${emp.direccion}</td>
								<td>${emp.coordenadas_dic}</td>
								<td>${emp.foto}</td>
								<td>${emp.descripcion}</td>
								<td>${emp.tipo_costo}</td>
								<%-- 
								<td>								
									<c:forEach var="entry" items="${departmentList}">        
									      <c:if test="${entry.key == emp.department.departmentId}">
									           ${entry.value}
									      </c:if>
									</c:forEach>
								</td>
								--%>
								<td><a
									href="<%=request.getContextPath()%>/admin/usr/editform/${emp.idinmueble}"
									class="btn btn-info btn-xs"> <i
										class="glyphicon glyphicon-check"></i>Edit
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/admin/usr/deleteform/${emp.idinmueble}"
									class="btn btn-danger btn-xs"> <i
										class="glyphicon glyphicon-trash"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <a href="<%=request.getContextPath()%>/admin/usr/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Create Employee</a>
					<a href="<%=request.getContextPath()%>/admin/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a>
			</div>
			<font color="red">${message}</font>
		</div>
	</div>
</body>
</html>