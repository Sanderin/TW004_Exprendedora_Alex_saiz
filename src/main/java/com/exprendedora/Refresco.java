package com.exprendedora;

public class Refresco {
	private String nombre = "";
	private String sabor = "";
	private float precio = 0f;
	private int stock = 0;
	

	public Refresco(String nombre, String sabor, float precio, int stock) {
		super();
		this.nombre = nombre;
		this.sabor = sabor;
		this.precio = precio;
		this.stock = stock;
	}

	public boolean agotado() {
		return this.stock == 0;
	}
	
	public boolean restar() {
		boolean res = false;
		if (!this.agotado()) {
			this.stock --;
			res = true;
		}
		return res;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	@Override
	public String toString() {
		return "Refresco [nombre=" + nombre + ", sabor=" + sabor + ", precio=" + precio + ", stock=" + stock+ "]";
	}

}// fin
