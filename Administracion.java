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

	Administracion(){
		Utilidades misUtilidades=new Utilidades();
		int totalMesas;
		System.out.println("Bienvenido a ICI Resto, programa dedicado a facilitar la administracion de su restaurant.");
		if (arch.esPrimeraVez()) {
			System.out.println("Por favor escriba la cantidad de mesas que desea configurar:");
			do{
				Scanner entrada = new Scanner(System.in);
				totalMesas = misUtilidades.validarInt(entrada.nextLine(), 1, -1);
			}while(totalMesas==-1);
			for (int i = 0; i < totalMesas; i++) {
				agregarMesa(i+1);
			}
		}
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

	public void agregarMesa(int numeroMesa) {
		Utilidades misUtilidades = new Utilidades();
		Mesa miMesa=new Mesa(numeroMesa,0,"LIBRE",0);
		System.out.println("Ingrese la cantidad de puestos de la Mesa " + miMesa.getNumero() + ":");
		int capacidad;
		do{
			Scanner entrada = new Scanner(System.in);
			capacidad = misUtilidades.validarInt(entrada.nextLine(), 1, -1);
		}while(capacidad==-1);
		miMesa.setCapacidad(capacidad);
		listaMesas.add(miMesa);
		arch.almacenarDatos(listaMesas);
	}
		
	public void mostrarMesas(){
		System.out.println("Mesas:\n\tCAPACIDAD\tESTADO\tCONSUMO");
		for (int i = 0; i < listaMesas.size(); i++) {
			System.out.println("-Mesa "+listaMesas.get(i).getNumero()+":\t"+listaMesas.get(i).getCapacidad()+"\t"+listaMesas.get(i).getEstado()+"\t"+listaMesas.get(i).getConsumo());
		}
	}
	
	public ArrayList<Mesa> getListaMesas(){
		return this.listaMesas;
	}
	
	public int getNumeroMesas(){
		return listaMesas.size();
	}
	
	public void setListaMesas(ArrayList<Mesa> nuevaListaMesas){
		this.listaMesas=nuevaListaMesas;
	}
	
	public void setEstadoMesa(int numeroMesa, String estadoMesa){
		listaMesas.get(numeroMesa-1).setEstado(estadoMesa);
	}
	
	public void setCapacidadMesa(int numeroMesa, int capacidadMesa){
		listaMesas.get(numeroMesa-1).setCapacidad(capacidadMesa);
	}
	
	public void setConsumoMesa(int numeroMesa, int consumoMesa){
		listaMesas.get(numeroMesa-1).setConsumo(consumoMesa);
	}
}
