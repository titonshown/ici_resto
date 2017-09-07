/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iciresto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Archivos {
    public String leerArchivo(){
        String ruta = "D:\\mesas.txt";
        Path archivo = Paths.get(ruta);
        String texto = "";
        try{
            texto = new String(Files.readAllBytes(archivo));
        }
        catch(IOException e){
            System.err.println("Ha ocurrido un error al intentar leer el archivo.");
            return null;
        }       
        return texto;
    }
    
    public void crearArchivoMesas(){
        String ruta = "D:\\mesas.txt";
        Path archivo = Paths.get(ruta);
        try{
            if(Files.notExists(archivo)){
                String texto = "Mesas:";
                Files.write(archivo, texto.getBytes());
                int pos = ruta.lastIndexOf("/");
                String nombre = ruta.substring(pos+1,ruta.length());
                System.out.println("Archivo creado correctamente con el nombre: "+ nombre); 
            }
        }catch(IOException e){
            System.out.println("Error al intentar crear el archivo");
        }     
    }
    
    public void almacenarDatos(ArrayList<Mesa> mesas){
        String espacio = "\r\n";
        String contenido = "Mesas:"+espacio;
        for(int i=0;i<mesas.size();i++){
            Mesa mesa = mesas.get(i);
            int capacidad = mesa.getCapacidad();
            String estado = mesa.getEstado();
            int consumo = mesa.getConsumo();
            contenido = contenido+"Mesa "+(i+1)+";"+capacidad+";"+estado+";"+consumo+espacio;         
        }
        Path archivo = Paths.get("D:\\mesas.txt");
        try{
            Files.write(archivo, contenido.getBytes());
            System.out.println("Archivo guardado correctamente");
        }catch(IOException e){
            System.out.println("Error al intentar crear el archivo");
        }
        
    }
    
    public boolean esPrimeraVez(){
        String ruta = "D:\\mesas.txt";
        Path archivo = Paths.get(ruta);
        if(Files.notExists(archivo)){
            return true;  
        }else{
            return false;
        }
    }
}
