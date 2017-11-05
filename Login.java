package iciresto;


import java.util.ArrayList;

public class Login {
    private String username;
    private String password;
    
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
   public boolean usuarioExiste(){
        String usuario = this.username+";"+this.password;
     
        ArchivoLog archLog = new ArchivoLog();
        ArrayList<String> listaUsuarios = archLog.leer();
        for(int i=0; i<listaUsuarios.size(); i++){
            if(usuario.equals(listaUsuarios.get(i))){
                return true;                
            }
        }
        return false;
    }
}
