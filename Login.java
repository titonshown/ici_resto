package iciresto;

import java.util.ArrayList;

public class ArchivoLog extends Archivo{

    public ArchivoLog() {
        super("login.txt");
    }
       
    public ArrayList<String> leer() {
        ArrayList<String> listaUsuarios = new ArrayList<>();
        String texto=leerArchivo();
	String[] usuarios = texto.split("-");
	for(int i=0;i<usuarios.length;i++){
            listaUsuarios.add(usuarios[i]);
             }
        return listaUsuarios;
}
}
    

