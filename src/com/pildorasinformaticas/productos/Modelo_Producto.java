package com.pildorasinformaticas.productos;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

public class Modelo_Producto {

	// almacena el pool de conexiones
	private DataSource origen_datos;

	/*
	 * Constructor
	 */
	public Modelo_Producto(DataSource origen_datos) {
		this.origen_datos = origen_datos;
	}

	// get lista de productos
	public List<Producto> getProductos() throws Exception {
		List<Producto> productos = new ArrayList<Producto>();

		Connection mi_conexion = null;
		Statement mi_statement = null;
		ResultSet mi_resultset = null;

		// PASOS
		/*
		 * 1) establecer la conexion
		 */
		mi_conexion = origen_datos.getConnection();

		/*
		 * 2) crear sentencia SQL y staement
		 */
		String instruccion_sql = "SELECT * FROM productos";
		mi_statement = mi_conexion.createStatement();

		/*
		 * 3) ejecutar sql
		 */
		mi_resultset = mi_statement.executeQuery(instruccion_sql);

		/*
		 * 4) recorrer resultado
		 */

		while (mi_resultset.next()) {
			// campos del resultado
			String codigo_articulo = mi_resultset.getString("CÓDIGO_ARTÍCULO");
			String seccion = mi_resultset.getString("SECCIÓN");
			String nombre_articulo = mi_resultset.getString("NOMBRE_ARTÍCULO");
			double precio = mi_resultset.getDouble("PRECIO");
			Date fecha = mi_resultset.getDate("FECHA");
			String importado = mi_resultset.getString("IMPORTADO");
			String pais_origen = mi_resultset.getString("PAÍS_DE_ORIGEN");

			// instancia de producto para meter en la lista
			Producto p = new Producto(codigo_articulo, seccion, nombre_articulo, precio, fecha, importado, pais_origen);

			// agrego a la lista
			productos.add(p);
		}

		return productos;
	}

	public void agregarProducto(Producto nuevo_producto) {
		// TODO Auto-generated method stub
		/**
		 * 1ro obtener a la conexion ala BD
		 */
		Connection mi_conexion = null;
		PreparedStatement mi_statement = null;

		try {
			mi_conexion = origen_datos.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 2do crear SQL y statement (preparada)
		 */

		String sql = "INSERT INTO productos (CÓDIGO_ARTÍCULO, SECCIÓN, NOMBRE_ARTÍCULO, PRECIO, FECHA, IMPORTADO, PAÍS_DE_ORIGEN) VALUES (?, ?, ?, ?, ?, ?, ?)";

		/**
		 * 3ro establecer los parametros para el producto
		 */

		try {
			mi_statement = mi_conexion.prepareStatement(sql);
			mi_statement.setString(1, nuevo_producto.getCodigo_articulo());
			mi_statement.setString(2, nuevo_producto.getSeccion());
			mi_statement.setString(3, nuevo_producto.getNombre_articulo());
			mi_statement.setDouble(4, nuevo_producto.getPrecio());

			// es distinta la clase Date
			java.util.Date utilDate = nuevo_producto.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			mi_statement.setDate(5, fechaConvertida);

			mi_statement.setInt(6, Integer.parseInt(nuevo_producto.getImportado()));
			mi_statement.setString(7, nuevo_producto.getPais_origen());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 4to ejecutar la instruccion SQL
		 */
		try {
			mi_statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
