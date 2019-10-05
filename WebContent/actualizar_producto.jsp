<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Actualizar registro</h1>
	
	<form method="get" action="Controlador_Productos">
		<!-- indica lo que debe hacer el m�todo doGet() en el controller -->
		<input type="hidden" name="instruccion" value="actualizar" />
		
		<input type="hidden" name="id" value="${PRODUCTO_EDITAR.codigo_articulo }"/>
		
		<table>
			<tr>
				<td>Secci�n</td>
				<td>
					<label for="seccion"></label>
					<input type="text" name="seccion" id="seccion" value="${PRODUCTO_EDITAR.seccion}">
				</td>
			</tr>
			
			<tr>
				<td>Nombre ar�culo</td>
				<td>
					<label for="nombre_articulo"></label>
					<input type="text" name="nombre_articulo" id="nombre_articulo" value="${PRODUCTO_EDITAR.nombre_articulo }">
				</td>
			</tr>
			
			<tr>
				<td>Fecha</td>
				<td>
					<label for="fecha"></label>
					<input type="text" name="fecha" id="fecha" value="${PRODUCTO_EDITAR.fecha }">
				</td>
			</tr>
			
			<tr>
				<td>Precio</td>
				<td>
					<label for="precio"></label>
					<input type="text" name="precio" id="precio" value="${PRODUCTO_EDITAR.precio}">
				</td>
			</tr>
			
			<tr>
				<td>Importado</td>
				<td>
					<label for="importado"></label>
					<input type="text" name="importado" id="importado" value="${PRODUCTO_EDITAR.importado}">
				</td>
			</tr>
			
			<tr>
				<td>Pa�s de origen</td>
				<td>
					<label for="pais_origen"></label>
					<input type="text" name="pais_origen" id="pais_origen" value="${PRODUCTO_EDITAR.pais_origen}">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Actualizar">
				</td>
				<td>
					<input type="reset" value="Limpiar" name="codigo_articulo" id="codigo_articulo">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>