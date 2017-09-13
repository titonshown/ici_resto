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
   Archivos a = new Archivos();
    
    public void configurarMesas(){
        
         System.out.println("Bienvenido a ICI Resto.");
        if(a.esPrimeraVez()){
            a.crearArchivoMesas();
            //System.out.println(archivo);
            System.out.println("Por favor escriba la cantidad de mesas que desea configurar:");
            int total = ingresarInt();
            ArrayList<Mesa> listaMesas = new ArrayList<>();

            for(int i=0;i<total;i++){
                System.out.println("Ingrese la cantidad de puestos de la Mesa "+(i+1)+":");
                int capacidad = ingresarInt();            
                listaMesas.add(new Mesa(capacidad,"LIBRE",0));           
            }
            a.almacenarDatos(listaMesas);
        }
                   
                           
    }
    
    
    public int ingresarInt(){               
        boolean error = true;
        while(error){
            Scanner teclado = new Scanner(System.in);
            try{                
                int n = teclado.nextInt();
                if(n <= 0){
                   error = true;
                    System.out.println("Error. Por favor ingrese un numero valido"); 
                }else{
                    error = false;
                    return n;
                }
                
            }catch(InputMismatchException e){
                error = true;
                System.out.println("Error. Por favor ingrese un numero");
            } 
        }
        return 0;        
    }
    
    public void verMesas(){
        a.mostrarDatos();
    }
    
    public void editarMesas(){
        a.mostrarDatos();
        System.out.println("¿Que mesa desea editar?");       
        boolean error = true;
        while(error){
           int numeroMesa = ingresarInt(); 
           if(numeroMesa > a.getTotalMesas() || numeroMesa <= 0){
               error = true;
               System.out.println("Error. Debe ingresar un numero de mesa valido.");
           }else{
               System.out.println("¿Que propiedad de la mesa desea editar?");
               System.out.println("1. Capacidad");
               System.out.println("2. Estado");
               System.out.println("3. Consumo");
                while(error){
                    Scanner teclado = new Scanner(System.in);
                    try{
                        int n = teclado.nextInt();
                        if(n == 1 || n == 2 || n == 3){
                            error = false; 
                            switch(n){
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
                        }else{
                           error = true;
                            System.out.println("Error. Por favor ingrese un numero valido");
                        }               
                    }catch(InputMismatchException e){
                        error = true;
                        System.out.println("Error. Por favor ingrese un numero valido");
                    } 
                }
           } 
        }
        
    }
    
    public void editarCapacidad(int numeroMesa){
        System.out.println("Ingrese la nueva capacidad de la mesa "+numeroMesa+".");
        String capacidad = ingresarInt()+""; 
        a.setDato("capacidad",capacidad,numeroMesa);
    }
    
    public void editarEstado(int numeroMesa){
        System.out.println("Ingrese el nuevo estado de la mesa "+numeroMesa+".");
        String estado = ingresarEstado(); 
        a.setDato("estado",estado,numeroMesa);
    }
    
    public void editarConsumo(int numeroMesa){
         System.out.println("Ingrese el consumo de la mesa "+numeroMesa+".");
         String consumo = ingresarInt()+""; 
         a.setDato("consumo",consumo,numeroMesa);
    }
    
    public String ingresarEstado(){
        System.out.println("1. LIBRE");
        System.out.println("2. ASIGNADA");
        System.out.println("3. ATENDIDA");
        System.out.println("4. RESERVADA");
        System.out.println("5. NO HABILITADA");
        boolean error = true;
        while(error){
                Scanner teclado = new Scanner(System.in);
                try{
                    int n = teclado.nextInt();
                    if(n == 1 || n == 2 || n == 3 || n == 4 || n == 5){
                        error = false; 
                        switch(n){
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
                    }else{
                        error = true;
                        System.out.println("Error. Por favor ingrese un numero valido");
                    }               
                }catch(InputMismatchException e){
                    error = true;
                    System.out.println("Error. Por favor ingrese un numero valido");
                } 
        }
        return null;
    }
    
    
}
