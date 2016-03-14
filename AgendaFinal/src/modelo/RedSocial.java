/*
    Descripción de la clase: esta clase almacena los numeros
                             telefonicos de los contactos
*/
package modelo;

public class RedSocial {
    String nombreUsuario, tipo;
    //Constructor
    public RedSocial(){
        
    }
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public String getTipo(){
        return tipo;
    }
    
}