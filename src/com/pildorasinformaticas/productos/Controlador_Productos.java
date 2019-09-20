package com.pildorasinformaticas.productos;

import java.io.IOException;
import java.util.*;

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
