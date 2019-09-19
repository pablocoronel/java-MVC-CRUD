package com.pildorasinformaticas.productos;

import java.util.Date;

public class Producto {

	private String codigo_articulo;
	private String seccion;
	private String nombre_articulo;
	private double precio;
	private Date fecha;
	private String importado;
	private String pais_origen;

	/*
	 * Constructor completo
	 */
	public Producto(String codigo_articulo, String seccion, String nombre_articulo, double precio, Date fecha,
			String importado, String pais_origen) {
		this.codigo_articulo = codigo_articulo;
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais_origen = pais_origen;
	}

	/*
	 * Constructor sin ID
	 */
	public Producto(String seccion, String nombre_articulo, double precio, Date fecha, String importado,
			String pais_origen) {
		this.seccion = seccion;
		this.nombre_articulo = nombre_articulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais_origen = pais_origen;
	}

	public String getCodigo_articulo() {
		return codigo_articulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public double getPrecio() {
		return precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getImportado() {
		return importado;
	}

	public String getPais_origen() {
		return pais_origen;
	}

	public void setCodigo_articulo(String codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public void setPais_origen(String pais_origen) {
		this.pais_origen = pais_origen;
	}

	@Override
	public String toString() {
		return "Producto [codigo_articulo=" + codigo_articulo + ", seccion=" + seccion + ", nombre_articulo="
				+ nombre_articulo + ", precio=" + precio + ", fecha=" + fecha + ", importado=" + importado
				+ ", pais_origen=" + pais_origen + "]";
	}

}
