/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ici_resto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Archivos {
	private Path archivo;

	public Path getRuta() {
		archivo = Paths.get("mesas.txt");
		return archivo;
	}

	public String leerArchivo() {
		String texto;
		try {
			texto = new String(Files.readAllBytes(getRuta()));
		} catch (IOException e) {
			System.err.println("Ha ocurrido un error al intentar leer el archivo.");
			return null;
		}
		return texto;
	}

	public void crearArchivoMesas() {
		String texto = "Mesas:";
		agregarTexto(texto);
		// int pos = ruta.lastIndexOf("/");
		// String nombre = ruta.substring(pos+1,ruta.length());
	}
		
	public void almacenarDatos(ArrayList<Mesa> mesas) {
		String espacio = "\r\n";
		String contenido = "Mesas:" + espacio;
		for (int i = 0; i < mesas.size(); i++) {
			Mesa mesa = mesas.get(i);
			int capacidad = mesa.getCapacidad();
			String estado = mesa.getEstado();
			int consumo = mesa.getConsumo();
			contenido = contenido + "-Mesa " + (i + 1) + ";" + capacidad + ";" + estado + ";" + consumo + espacio;
		}
		agregarTexto(contenido);
	}

	public void setDato(String tipoDato, String dato, int mesa) {
		String contenido = leerArchivo();
		int pos = contenido.indexOf("Mesa " + mesa + ";");
		int pos2 = contenido.indexOf("\n", pos + 1);
		String linea = contenido.substring(pos, pos2);
		String[] separados = linea.split(";");
		switch (tipoDato) {
		case "capacidad":
			contenido = contenido.substring(0, pos) + separados[0] + ";" + dato + ";" + separados[2] + ";"
					+ separados[3] + contenido.substring(pos2);
			System.out.println("Capacidad de la Mesa " + mesa + " ahora es: " + dato);
			break;
		case "estado":
			contenido = contenido.substring(0, pos) + separados[0] + ";" + separados[1] + ";" + dato + ";"
					+ separados[3] + contenido.substring(pos2);
			System.out.println("Estado de la Mesa " + mesa + " ahora es: " + dato);
			break;
		case "consumo":
			contenido = contenido.substring(0, pos) + separados[0] + ";" + separados[1] + ";" + separados[2] + ";"
					+ dato + contenido.substring(pos2);
			System.out.println("Consumo de la Mesa " + mesa + " ahora es: " + dato);
			break;
		default:
			break;
		}
		agregarTexto(contenido);
	}

	public void mostrarDatos(){
        System.out.println("Numero de Mesa\tCapacidad\tEstado\tConsumo\n");
        String contenido = leerArchivo();
        String[] mesas = contenido.split("-");
        //i parte en 1 ya que el primer elemento de la lista seria el "Mesas:"
        for(int i=1;i<mesas.length;i++){
            String[] propiedades = mesas[i].split(";");
            System.out.println(propiedades[0]+"\t\t"+propiedades[1]+"\t\t"+propiedades[2]+"\t"+propiedades[3]);
        }
        
    }


	public int getTotalMesas() {
		String contenido = leerArchivo();
		String[] mesas = contenido.split("-");
		int total = mesas.length - 1;
		return total;
	}

	public boolean esPrimeraVez() {

		return Files.notExists(getRuta());
	}
	
	public void agregarTexto(String texto){
		try {
			Files.write(getRuta(), texto.getBytes());
			System.out.println("Archivo guardado correctamente");
		} catch (IOException e) {
			System.out.println("Error al intentar crear el archivo");
		}
	}
	
	public ArrayList<Mesa> leerMesas(){
		ArrayList<Mesa> listaMesas=new ArrayList<Mesa>();
		String texto=leerArchivo();
		String[] mesas = texto.split("-");
		for(int i=1;i<mesas.length;i++){
            String[] propiedades = mesas[i].split(";");
            String[]aux=propiedades[0].split(" ");
            propiedades[3]=propiedades[3].replaceAll("[\n\r]","");
            Mesa mesa=new Mesa(Integer.parseInt(aux[1]),Integer.parseInt(propiedades[1]),propiedades[2],Integer.parseInt(propiedades[3]));
            listaMesas.add(mesa);
		}
		return listaMesas;
	}
}
