/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iciresto;

import java.awt.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Administracion {
    public void configurarMesas(){
        Archivos a = new Archivos();
        if(a.esPrimeraVez()){
            a.crearArchivoMesas();
        }
        //METER ESTO DENTRO DEL IF
        String archivo = a.leerArchivo();
        //System.out.println(archivo);
        System.out.println("Bienvenido a ICI Resto.");
        System.out.println("Por favor escriba la cantidad de mesas que desea configurar:");
        int total = ingresarInt();
        ArrayList<Mesa> listaMesas = new ArrayList<Mesa>();
        
        for(int i=0;i<total;i++){
            System.out.println("Ingrese la cantidad de puestos de la Mesa "+(i+1)+":");
            int capacidad = ingresarInt();            
            listaMesas.add(new Mesa(capacidad,"LIBRE",0));           
        }
        a.almacenarDatos(listaMesas);     
    }
    
    public int ingresarInt(){               
        boolean error = true;
        while(error){
            Scanner teclado = new Scanner(System.in);
            try{
                error = false;
                int n = teclado.nextInt();
                return n;
            }catch(InputMismatchException e){
                error = true;
                System.out.println("Error. Por favor ingrese un numero");
            } 
        }
        return 0;        
    }
}
