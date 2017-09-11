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
            contenido = contenido+"-Mesa "+(i+1)+";"+capacidad+";"+estado+";"+consumo+espacio;         
        }
        Path archivo = Paths.get("D:\\mesas.txt");
        try{
            Files.write(archivo, contenido.getBytes());
            System.out.println("Archivo guardado correctamente");
        }catch(IOException e){
            System.out.println("Error al intentar crear el archivo");
        }
        
    }
    
    public void setDato(String tipoDato,String dato,int mesa){
        String contenido = leerArchivo();
        if(tipoDato.equals("capacidad")){
            int pos = contenido.indexOf("Mesa "+mesa+";")+7;
            int pos2 = contenido.indexOf(";", pos+1);
            contenido = contenido.substring(0, pos)+dato+contenido.substring(pos2);
            System.out.println("Capacidad de la Mesa "+mesa+" ahora es: "+dato);
        }
        Path archivo = Paths.get("D:\\mesas.txt");
        try{
            Files.write(archivo, contenido.getBytes());
        }catch(IOException e){
            System.out.println("Error al intentar crear el archivo");
        }
        
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
    
    public int getTotalMesas(){
        String contenido = leerArchivo();
        String[] mesas = contenido.split("-");
        int total = mesas.length-1;
        return total;
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
