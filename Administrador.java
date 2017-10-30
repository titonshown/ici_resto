/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iciresto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Administrador {
	private ArchivoMesas archivo;
	private ArrayList<Mesa> listaMesas;

	public Administrador(){
                this.archivo = new ArchivoMesas();
                this.listaMesas = llenarMesa();
		Utilidades misUtilidades=new Utilidades();
		int totalMesas;
		System.out.println("Bienvenido a ICI Resto, programa dedicado a facilitar la administracion de su restaurant.");
		if (archivo.esPrimeraVez()) {
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
		if (archivo.esPrimeraVez()) {
			lista = new ArrayList<Mesa>();
		} else {
			lista = archivo.leer();
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
		guardarContenido();
	}
        
        public void guardarContenido(){
            String contenido = "Mesas:\r\n";
            for (int i = 0; i < listaMesas.size(); i++) {	
                contenido = contenido + "-Mesa "+listaMesas.get(i).getNumero()+";"+listaMesas.get(i).getCapacidad()+";"+listaMesas.get(i).getEstado()+";"+listaMesas.get(i).getConsumo()+"\r\n";
            }
            archivo.agregarTexto(contenido);
        }
		
	public void mostrarMesas(){
		System.out.println("Mesas:\n\t\tCAPACIDAD\tESTADO\t\t\tCONSUMO");
		for (int i = 0; i < listaMesas.size(); i++) {
                    if(listaMesas.get(i).getEstado().equals("LIBRE")){
                        System.out.println("-Mesa "+listaMesas.get(i).getNumero()+":\t\t"+listaMesas.get(i).getCapacidad()+"\t"+listaMesas.get(i).getEstado()+"\t\t\t"+listaMesas.get(i).getConsumo()+"\r");
                    }else{
                        System.out.println("-Mesa "+listaMesas.get(i).getNumero()+":\t\t"+listaMesas.get(i).getCapacidad()+"\t"+listaMesas.get(i).getEstado()+"\t\t"+listaMesas.get(i).getConsumo()+"\r");
                    }
			
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
