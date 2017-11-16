/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iciresto;

public class Utilidades {

	public int validarInt(String opcion, int minimo, int maximo, int retornoDefecto){
		try{
			int aux=Integer.parseInt(opcion);
			if(aux<minimo||aux>maximo){
				System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
				return retornoDefecto;
			}else{
				return aux;
			}
		}catch(Exception e){
			System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
			return retornoDefecto;
		}
	}
	
	public int validarInt(String opcion, int minimo, int retornoDefecto){
		try{
			int aux=Integer.parseInt(opcion);
			if(aux<minimo){
				System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
				return retornoDefecto;
			}else{
				return aux;
			}
		}catch(Exception e){
			System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
			return retornoDefecto;
		}
	}
}
