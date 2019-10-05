package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Controlador_Productos
 */
@WebServlet("/Controlador_Productos")
public class Controlador_Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// llamamos al modelo
	private Modelo_Producto modelo_producto;

	// nombre de la conexion en el context.xml
	@Resource(name = "jdbc/Productos")
	private DataSource mi_pool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {
			modelo_producto = new Modelo_Producto(mi_pool);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// leer el parametro que le llega desde el formulario
		String comando = request.getParameter("instruccion");

		// si no se envia el parametro, listar los productos
		if (comando == null) {
			comando = "listar";
		}

		// redirigir el flujo de ejecucion al metodo adecuado
		switch (comando) {
		case "listar":
			obtenerProductos(request, response);
			break;

		case "insertar":
			agregarProductos(request, response);
			break;

		case "ver":
			try {
				verProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "actualizar":
			try {
				actualizarProducto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			obtenerProductos(request, response);
			break;
		}

	}

	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 1ro leer los datos enviados desde el formulario
		 */
		String codigo_articulo = request.getParameter("id");

		// data a actualizar
		String seccion = request.getParameter("seccion");
		String nombre_articulo = request.getParameter("nombre_articulo");
		double precio = Double.parseDouble(request.getParameter("precio"));

		SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formato_fecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String importado = request.getParameter("importado");
		String pais_origen = request.getParameter("pais_origen");

		/**
		 * 2do crear un objeto de tipo Producto con la info del formulario
		 */

		Producto producto_actualizado = new Producto(codigo_articulo, seccion, nombre_articulo, precio, fecha,
				importado, pais_origen);

		/**
		 * 3ro actualizar la BD con la info del objeto Producto
		 */
		modelo_producto.actualizarProducto(producto_actualizado);

		/**
		 * 4to volver al listado con la info actualizada
		 */
		obtenerProductos(request, response);

	}

	private void verProducto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Leer el codigo de articulo pasado en el request
		String codigo_articulo = request.getParameter("id");

		// Preguntarle al modelo si está disponible el Producto y recibirlo
		Producto el_producto = this.modelo_producto.getProducto(codigo_articulo);

		// Setear en el request un atributo que almacene el Producto
		request.setAttribute("PRODUCTO_EDITAR", el_producto);

		// enviar datos al formulario de actualizacion, mediante un dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/actualizar_producto.jsp");
		dispatcher.forward(request, response);
	}

	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 1ro leer la informacion del formulario
		 */
		String codigo_articulo = request.getParameter("codigo_articulo");
		String seccion = request.getParameter("seccion");
		String nombre_articulo = request.getParameter("nombre_articulo");

		SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formato_fecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double precio = Double.parseDouble(request.getParameter("precio"));
		String importado = request.getParameter("importado");
		String pais_origen = request.getParameter("pais_origen");

		/**
		 * 2do crear un objeto de tipo Producto
		 */
		Producto nuevo_producto = new Producto(codigo_articulo, seccion, nombre_articulo, precio, fecha, importado,
				pais_origen);

		/**
		 * 3ro enviar objeto al modelo
		 */
		modelo_producto.agregarProducto(nuevo_producto);

		/**
		 * 4to volver al listado de productos
		 */
		obtenerProductos(request, response);

	}

	// Este metodo lista los productos y los muestra en una vista JSP
	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Producto> productos;

		try {
			// obtener la lista de productos desde el modelo
			productos = this.modelo_producto.getProductos();

			// agregar la lista de productos al request
			request.setAttribute("LISTA_PRODUCTOS", productos);

			// crear el dispatcher para enviar el request
			RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");

			// enviar el request (mediante un dispatcher) a la vista JSP
			miDispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
