package iciresto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Archivo {
	private Path path;

        public Archivo(String path){
            this.path = Paths.get(path);
        }
        
	public Path getRuta() {
            return this.path;
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
	
	public abstract ArrayList leer();
}
