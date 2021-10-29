package com.exprendedora;

public class Maquina {
	private int id = 0;
	private float caja = 0f;
	private float cambios = 0f;
	private Refresco refresco;
	private int maximo = 50;

	public Maquina(int id, float caja, float cambios, Refresco refresco, int maximo) {
		super();
		this.id = id;
		this.caja = caja;
		this.cambios = cambios;
		this.refresco = refresco;
		this.maximo = maximo;
	}

	public void reponer(int add) {
		if (refresco.getStock() + add <= maximo) {
			int stock = refresco.getStock();
			refresco.setStock(stock + add);
		} else {
			System.out.println("no entran tantos refrescos");
		}
	}

	public float venta(float dineroIng) {
//		int stock = refresco.getStock();
//		if (refresco.getStock() > 0 && dineroIng >= refresco.getPrecio() && caja >= dineroIng) {
//			stock--;
//			refresco.setStock(stock);
//			cambios = dineroIng - refresco.getPrecio();
//			caja = caja + dineroIng - cambios;
//			return caja;
//		} else {
//			System.out.println("error");
//			return -1;
//		}

		// ver stock
		if (this.refresco.agotado()) {
			return -1;
		}

		// ver si hay dinero suficiente
		if (cambios > caja) {
			return -2;
		}

		// comprobar que haya introducido suficiente dinero
		if (dineroIng - refresco.getPrecio() < 0) {
			return -3;
		}

		// vender el refresco si todo esta correcto
		cambios = dineroIng - refresco.getPrecio();
		caja = caja + refresco.getPrecio();
		return cambios;
	}

	public String informe() {
		return "Maquina [id=" + id + ", caja=" + caja + ", refresco=" + refresco + "]";
	}

	public void estadoRefresco() {
		System.out.println(refresco.getStock());
	}

	public void estadoMaquina() {
		System.out.println(id + " " + caja);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCaja() {
		return caja;
	}

	public void setCaja(float caja) {
		this.caja = caja;
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	
	

}// fin
