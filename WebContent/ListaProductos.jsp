<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*, com.pildorasinformaticas.productos.*"%>


<!DOCTYPE html>
<html>
<head>

<%
	// obtiene los productos del controlador (servlet)
	List<Producto> los_productos = (List<Producto>) request.getAttribute("LISTA_PRODUCTOS");
%>


<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	.cabecera{
		border: solid #FF0000 1px;
		background-color: teal;
		color: white;
	}
</style>
</head>
<body>
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

		<%
			for (Producto tempProd : los_productos) {
		%>
		<tr>
			<td><%= tempProd.getCodigo_articulo() %></td>
			<td><%= tempProd.getSeccion() %></td>
			<td><%= tempProd.getNombre_articulo() %></td>
			<td><%= tempProd.getPrecio() %></td>
			<td><%= tempProd.getFecha() %></td>
			<td><%= tempProd.getImportado() %></td>
			<td><%= tempProd.getPais_origen() %></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>