<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- importa los tag core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.cabecera {
	border: solid #FF0000 1px;
	background-color: teal;
	color: white;
}

#botonera{
	margin-bottom: 20px;
	background-color: olive;
}
</style>
</head>
<body>
	<div id="botonera">
		<input type="button" name="agregar" value="Agregar" onclick="window.location.href='inserta_producto.jsp'">
	</div>

	<table>
		<tr>
			<td class="cabecera">Códogo Articulo</td>
			<td class="cabecera">Sección</td>
			<td class="cabecera">Nombre Articulo</td>
			<td class="cabecera">Fecha</td>
			<td class="cabecera">Precio</td>
			<td class="cabecera">Importado</td>
			<td class="cabecera">País de origen</td>
		</tr>

		<!-- LISTA_PRODUCTOS es el atributo pasado desde el controller -->
		<c:forEach var="tempProd" items="${LISTA_PRODUCTOS}">
			<tr>
				<td>${tempProd.codigo_articulo}</td>
				<td>${tempProd.seccion}</td>
				<td>${tempProd.nombre_articulo}</td>
				<td>${tempProd.precio}</td>
				<td>${tempProd.fecha}</td>
				<td>${tempProd.importado}</td>
				<td>${tempProd.pais_origen}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>