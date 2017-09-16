/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ici_resto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Administracion {
	Archivos arch = new Archivos();
	ArrayList<Mesa> listaMesas = llenarMesa();

	public void configurarMesas() {

		System.out.println("Bienvenido a ICI Resto.");
		if (arch.esPrimeraVez()) {
			arch.crearArchivoMesas();
			// System.out.println(archivo);
			System.out.println("Por favor escriba la cantidad de mesas que desea configurar:");
			int total = ingresarInt();

			for (int i = 0; i < total; i++) {
				System.out.println("Ingrese la cantidad de puestos de la Mesa " + (i + 1) + ":");
				int capacidad = ingresarInt();
				listaMesas.add(new Mesa(i + 1, capacidad, "LIBRE", 0));
			}
			arch.almacenarDatos(listaMesas);
		}
	}

	public int ingresarInt() {
		int n = 0;
		do {
			Scanner teclado = new Scanner(System.in);
			try {
				n = teclado.nextInt();
				if (n <= 0) {
					System.out.println("Error. Por favor ingrese un numero valido");
				} else {
					return n;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. Por favor ingrese un numero");
			}
		} while (n <= 0);
		return 0;
	}

	
	public void verMesas() {
		arch.mostrarDatos();
	}

	public void editarMesas() {
		arch.mostrarDatos();
		System.out.println("¿Que mesa desea editar?");
		int numeroMesa;
		do {
			numeroMesa = ingresarInt();
			if (numeroMesa > arch.getTotalMesas()) {
				System.out.println("Error. Debe ingresar un numero de mesa valido.");
			} else {
				System.out.println("¿Que propiedad de la mesa desea editar?");
				System.out.println("1. Capacidad");
				System.out.println("2. Estado");
				System.out.println("3. Consumo");
				int opcion = 0;
				do {
					Scanner teclado = new Scanner(System.in);
					try {
						opcion = teclado.nextInt();
						if (opcion >= 1 && opcion <= 3) {
							switch (opcion) {
							case 1:
								editarCapacidad(numeroMesa);
								break;
							case 2:
								editarEstado(numeroMesa);
								break;
							case 3:
								editarConsumo(numeroMesa);
								break;
							}
						} else {
							System.out.println("Error. Por favor ingrese un numero valido");
						}
					} catch (InputMismatchException e) {
						System.out.println("Error. Por favor ingrese un numero valido");
					}
				} while (opcion != 1 && opcion != 2 && opcion != 3);
			}
		} while (numeroMesa > arch.getTotalMesas());
		arch.almacenarDatos(listaMesas);
	}

	public void editarCapacidad(int numeroMesa) {
		System.out.println("Ingrese la nueva capacidad de la mesa " + numeroMesa + ".");
		String capacidad = ingresarInt() + "";
		arch.setDato("capacidad", capacidad, numeroMesa);
	}

	public void editarEstado(int numeroMesa) {
		System.out.println("Ingrese el nuevo estado de la mesa " + numeroMesa + ".");
		String estado = ingresarEstado();
		arch.setDato("estado", estado, numeroMesa);
	}

	public void editarConsumo(int numeroMesa) {
		System.out.println("Ingrese el consumo de la mesa " + numeroMesa + ".");
		String consumo = ingresarInt() + "";
		arch.setDato("consumo", consumo, numeroMesa);
	}

	public String ingresarEstado() {
		System.out.println("1. LIBRE");
		System.out.println("2. ASIGNADA");
		System.out.println("3. ATENDIDA");
		System.out.println("4. RESERVADA");
		System.out.println("5. NO HABILITADA");
		int opcion = 0;
		do {
			Scanner teclado = new Scanner(System.in);
			try {
				opcion = teclado.nextInt();
				if (opcion >= 1 && opcion <= 5) {
					switch (opcion) {
					case 1:
						return "LIBRE";
					case 2:
						return "ASIGNADA";
					case 3:
						return "ATENDIDA";
					case 4:
						return "RESERVADA";
					case 5:
						return "NO HABILITADA";
					}
				} else {
					System.out.println("Error. Por favor ingrese un numero valido");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. Por favor ingrese un numero valido");
			}
		} while (opcion < 1 || opcion > 5);
		return null;
	}

	public ArrayList<Mesa> llenarMesa() {
		ArrayList<Mesa> lista;
		if (arch.esPrimeraVez()) {
			lista = new ArrayList<Mesa>();
		} else {
			lista = arch.leerMesas();
		}
		return lista;
	}

	public void agregarMesa() {
		System.out.println("Ingrese la cantidad de puestos de la Mesa " +(listaMesas.size()+1));
		int capacidad = ingresarInt();
		listaMesas.add(new Mesa((listaMesas.size()+1), capacidad, "LIBRE", 0));
		arch.almacenarDatos(listaMesas);
	}
	
	public ArrayList<Mesa> getListaMesas(){
		return this.listaMesas;
	}
	
	public void setListaMesas(ArrayList<Mesa> nuevaListaMesas){
		this.listaMesas=nuevaListaMesas;
	}
}
