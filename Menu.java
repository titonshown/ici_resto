/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ici_resto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Administracion adm = new Administracion();

	public void inicio() {
		adm.configurarMesas();
	}

	public void opciones() {

		System.out.println("Seleccione una opcion");

		System.out.println("1. Ver Mesas");
		System.out.println("2. Editar Mesas");
		System.out.println("3. Agregar Mesas");
		System.out.println("4. Salir");
	}

	public void menu() {
		int opcion = 0;
		do {
			Scanner teclado = new Scanner(System.in);
			try {
				opciones();
				opcion = teclado.nextInt();
				if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
					switch (opcion) {
					case 1:
						adm.verMesas();
						break;
					case 2:
						adm.editarMesas();
						break;
					case 3:
						// adm.agregarMesas();
					case 4:
						break;
					}

				} else {
					System.out.println("Error. Por favor ingrese un numero valido");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. Por favor ingrese un numero valido");
			}
		} while (opcion != 4);
	}
}
