package com.pildorasinformaticas.productos;

import java.io.*;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import org.apache.tomcat.jdbc.pool.DataSource;

/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Definir o establecer el DataSource, el nombre es el name del context.xml
	@Resource(name = "jdbc/Productos")
	private DataSource miPool;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPruebas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// Crear el objeto PrintWriter
		PrintWriter salida = response.getWriter();

		// Crear la conexion a la BD
		Connection mi_conexion = null;
		Statement mi_statement = null;
		ResultSet mi_resultset = null;

		try {
			// conexion al pool de conexiones
			mi_conexion = miPool.getConnection();

			// consulta SQL
			String mi_sql = "SELECT * FROM productos";

			// statement
			mi_statement = mi_conexion.createStatement();

			// ejecutar sql
			mi_resultset = mi_statement.executeQuery(mi_sql);

			// resultados
			while (mi_resultset.next()) {
				String nombre_articulo = mi_resultset.getString(3);

				// ver
				salida.println(nombre_articulo + "<br/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
