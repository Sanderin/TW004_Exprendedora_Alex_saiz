package com.exprendedora;

public class Maquina {
	private int id = 0;
	private float caja = 0f;
	private float cambios = 0f;
	private Refresco refresco;

	public Maquina(int id, float caja, float cambios, Refresco refresco) {
		super();
		this.id = id;
		this.caja = caja;
		this.cambios = cambios;
		this.refresco = refresco;
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

	public void reponer(int add) {
		int stock = refresco.getStock();
		refresco.setStock(stock + add);
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

}// fin
