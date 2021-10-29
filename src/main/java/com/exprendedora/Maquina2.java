package com.exprendedora;

public class Maquina2 {
	private int id = 0;
	private float caja = 0f;
	private float cambios = 0f;
	private Refresco[] lista = new Refresco[5];
	private int i;

	public Maquina2(int id, float caja, float cambios, Refresco[] lista) {
		super();
		this.id = id;
		this.caja = caja;
		this.cambios = cambios;
		this.lista = lista;
	}

	public float venta(float dineroIng, int i) {
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
		if (lista[i].agotado()) {
			return -1;
		}

		// ver si hay dinero suficiente
		if (cambios > caja) {
			return -2;
		}

		// comprobar que haya introducido suficiente dinero
		if (dineroIng - lista[i].getPrecio() < 0) {
			return -3;
		}

		// vender el refresco si todo esta correcto
		cambios = dineroIng - lista[i].getPrecio();
		caja = caja + lista[i].getPrecio();
		return cambios;
	}

	public void reponer(int add, int i) {
		int stock = lista[i].getStock();
		lista[i].setStock(stock + add);
	}

	public String informe(int i) {
		return "Maquina [id=" + id + ", caja=" + caja + ", refresco=" + lista[i] + "]";
	}

	public void estadoRefresco(int i) {
		System.out.println(lista[i].getStock());
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
