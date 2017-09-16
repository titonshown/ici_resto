/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ici_resto;

/**
 *
 * @author Usuario
 */

public class Mesa {

	private String estado;
	private int capacidad;
	private int consumo;
	private int numero;

	public Mesa(int numero, int capacidad, String estado, int consumo) {
		this.numero=numero;
		this.capacidad = capacidad;
		this.estado = estado;
		this.consumo = consumo;
	}

	public int getNumero(){
		return this.numero;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public int getConsumo() {
		return this.consumo;
	}
	
	public void setNumero(int num){
		this.numero=num;
	}

	public void setEstado(String est) {
		this.estado = est;
	}

	public void setCapacidad(int cap) {
		this.capacidad = cap;
	}

	public void setConsumo(int cons) {
		this.consumo = cons;
	}

}
