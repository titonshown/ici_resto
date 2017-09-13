/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ici_resto;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
Administracion a = new Administracion();

public void inicio(){
     a.configurarMesas();
}


public void opciones(){
        
    System.out.println("Seleccione una opcion");

           System.out.println("1. Ver Mesas");
           System.out.println("2. Editar Mesas");
           System.out.println("3. Agregar Mesas");
           System.out.println("4. Salir");
           menu();
}   
    public void menu(){
        boolean error = true;
        while(error){
            Scanner teclado = new Scanner(System.in);
            try{
                int n = teclado.nextInt();
                if(n == 1 || n == 2 || n == 3 || n == 4){
                    error = false; 
                    switch(n){
                        case 1:
                           a.verMesas();
                           break;
                        case 2:
                           a.editarMesas();
                           break;
                        case 3:
                           //a.agregarMesas();
                        case 4:
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
