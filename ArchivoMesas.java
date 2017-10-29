/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iciresto;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ArchivoMesas extends Archivo{

    public ArchivoMesas() {
        super("mesas.txt");
    }  
        
    @Override
    public ArrayList<Mesa> leer(){
	ArrayList<Mesa> listaMesas = new ArrayList<>();
	String texto=leerArchivo();
	String[] mesas = texto.split("-");
	for(int i=1;i<mesas.length;i++){
            String[] propiedades = mesas[i].split(";");
            String[]aux=propiedades[0].split(" ");
            propiedades[3]=propiedades[3].replaceAll("[\r\n]","");
            Mesa mesa=new Mesa(Integer.parseInt(aux[1]),Integer.parseInt(propiedades[1]),propiedades[2],Integer.parseInt(propiedades[3]));
            listaMesas.add(mesa);
        }
        return listaMesas;
}
}
