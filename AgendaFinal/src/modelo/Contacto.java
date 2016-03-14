/*
    Descripción de la clase: esta clase almacena los datos
                             de los contactos
*/
package modelo;
import java.util.Scanner;
import java.util.ArrayList;

public class Contacto {
    String nombre,fechaNacimiento, ocupacion, direccion, paginaWeb;
    ArrayList<Telefono> telefonos;
    ArrayList<RedSocial> redesSociales;
    ArrayList<String> correosElectronicos;
    //Constructor
    public Contacto(){
        this.redesSociales=new ArrayList<>();
        this.telefonos=new ArrayList<>();
        this.correosElectronicos=new ArrayList<>();
        
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento=fechaNacimiento;
    }
    public void setOcupacion(String ocupacion){
        this.ocupacion=ocupacion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setPaginaWeb(String paginaweb){
        this.paginaWeb=paginaweb;
    }
    public String getNombre(){
        return nombre;
    }
    public String getFechaNacimiento(){
        return fechaNacimiento;
    }
    public String getOcupacion(){
        return ocupacion;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getPaginaWeb(){
        return paginaWeb;
    }
    public boolean registrarRedesSociales(RedSocial redSocial){
        return this.redesSociales.add(redSocial);
    }
    public boolean registrarTelefonos(Telefono telefono){
        return this.telefonos.add(telefono);
    }
    public boolean registrarCorreosElectronicos(String correoElectronico){
        return this.correosElectronicos.add(correoElectronico);
    }
    public int tamanoLista(ArrayList lista){
        return lista.size();
    }
    public ArrayList getCorreosElectronicos(){
        return correosElectronicos;
    }
    public void imprimirTelefonos(Telefono telefono){       //Funcion que imprime un nodo de la lista telefonos       
        for(int i=0;i<tamanoLista(telefonos);i++){
            System.out.println("-------------------------------------");
            System.out.println("Tipo: "+telefono.getTipo());
            System.out.println("Numero: "+telefono.getNumero());
        }
    }
    public void mostrarTelefonos(){             //Funcion que recorre la lista de telefonos
        if(tamanoLista(telefonos)==0){
            System.out.println("No hay telefonos asociados a este contacto");
        }else{
        for(int i=0;i<tamanoLista(telefonos);i++){
            System.out.println("-------------------------------------");
            System.out.println("Telefono "+i+1);
            imprimirTelefonos(telefonos.get(i));
        }
        }
    }
    public void imprimirRedesSociales(RedSocial redSocial){     //Funcion que imprime un nodo de la lista redes sociales  
        for(int i=0;i<tamanoLista(redesSociales);i++){
            System.out.println("-------------------------------------");
            System.out.println("Tipo: "+redSocial.getTipo());
            System.out.println("Numero: "+redSocial.getNombreUsuario());
        }
    }
    public void mostrarRedesSociales(){         //Funcion que recorre la lista de redes sociales
        if(tamanoLista(redesSociales)==0){
            System.out.println("No hay redes sociales asociadas a este contacto");
        }else{
        for(int i=0;i<tamanoLista(redesSociales);i++){
            System.out.println("-------------------------------------");
            System.out.println("Red social "+i+1);
            imprimirRedesSociales(redesSociales.get(i));
        }
        }
    }
    public void mostrarCorreosElectronicos(String correoElectronico){
        if(tamanoLista(redesSociales)==0){
            System.out.println("No hay correos electronicos asociados a este contacto");
        }else{
        for(int i=0;i<tamanoLista(correosElectronicos);i++){
            System.out.println("-------------------------------------");
            System.out.println("Correo electronico "+i+1+" "+ correosElectronicos);
        }
        }
    }
}

