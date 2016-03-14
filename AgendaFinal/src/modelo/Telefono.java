/*
    Descripción de la clase: esta clase almacena las redes
                             sociales de los contactos
*/
package modelo;

public class Telefono {
    String tipo, numero;
    //Constructor
    public Telefono(){
        
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public String getNumero(){
        return numero;
    }
    public String getTipo(){
        return tipo;
    }
}