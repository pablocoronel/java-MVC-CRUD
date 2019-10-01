<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insertar registro</h1>
	
	<form method="get" action="Controlador_Productos">
		<!-- indica lo que debe hacer el método doGet() en el controller -->
		<input type="hidden" name="instruccion" value="insertar">
		
		<table>
			<tr>
				<td>Código arículo</td>
				<td>
					<label for="codigo_articulo"></label>
					<input type="text" name="codigo_articulo" id="codigo_articulo">
				</td>
			</tr>
			
			<tr>
				<td>Sección</td>
				<td>
					<label for="seccion"></label>
					<input type="text" name="seccion" id="seccion">
				</td>
			</tr>
			
			<tr>
				<td>Nombre arículo</td>
				<td>
					<label for="nombre_articulo"></label>
					<input type="text" name="nombre_articulo" id="nombre_articulo">
				</td>
			</tr>
			
			<tr>
				<td>Fecha</td>
				<td>
					<label for="fecha"></label>
					<input type="text" name="fecha" id="fecha">
				</td>
			</tr>
			
			<tr>
				<td>Precio</td>
				<td>
					<label for="precio"></label>
					<input type="text" name="precio" id="precio">
				</td>
			</tr>
			
			<tr>
				<td>Importado</td>
				<td>
					<label for="importado"></label>
					<input type="text" name="importado" id="importado">
				</td>
			</tr>
			
			<tr>
				<td>País de origen</td>
				<td>
					<label for="pais_origen"></label>
					<input type="text" name="pais_origen" id="pais_origen">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Enviar">
				</td>
				<td>
					<input type="reset" value="Limpiar" name="codigo_articulo" id="codigo_articulo">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>