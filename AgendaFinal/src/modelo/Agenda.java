package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Agenda {
    ArrayList<Contacto> contactos=new ArrayList();
    
    public Agenda(){
        
    }
    private Predicate<Contacto> filtraContacto(String criterioBusqueda, TipoBusqueda tipo){
       Predicate<Contacto> predicadoFiltrado=null;
       if(tipo==TipoBusqueda.porNombre){
           predicadoFiltrado=contacto->contacto.getNombre().contains(criterioBusqueda);           
       }else if(tipo==TipoBusqueda.porCorreo){
           predicadoFiltrado=contacto->contacto.getCorreosElectronicos().contains(criterioBusqueda);
       }else if(tipo==TipoBusqueda.porFechaNacimiento){
           predicadoFiltrado=contacto->contacto.getFechaNacimiento().contains(criterioBusqueda);
       }else if(tipo==TipoBusqueda.porOcupacion){
           predicadoFiltrado=contacto->contacto.getOcupacion().contains(criterioBusqueda);
       }
       return predicadoFiltrado;
    }
    private List<Contacto> buscaContacto(String criterioBusqueda, TipoBusqueda tipo){
        return this.contactos
                .stream()
                .filter(filtraContacto(criterioBusqueda, tipo))
                .collect(Collectors.toList());
        
    }
    public boolean guardarContacto(Contacto contacto){
        return this.contactos.add(contacto);
    }
    public void imprimirBusqueda(List<Contacto> lista){
        if(tamanoLista2(lista)==0){
            System.out.println("No se han encontrado resultados");
        }
        for(int i=0;i<tamanoLista2(lista);i++){
            imprimirContacto(lista.get(i));
        }
    }
    public List<Contacto> buscarPorNombre(String nombreBuscar){
        return this.buscaContacto(nombreBuscar, TipoBusqueda.porNombre);
    }
    public List<Contacto> buscarPorOcupacion(String ocupacionBuscar){
        return this.buscaContacto(ocupacionBuscar, TipoBusqueda.porOcupacion);
    }
    public List<Contacto> buscarPorFechaNacimiento(String fechaBuscar){
        return this.buscaContacto(fechaBuscar, TipoBusqueda.porFechaNacimiento);
    }
    public List<Contacto> buscarPorCorreoElectronico(String correoBuscar){
        return this.buscaContacto(correoBuscar, TipoBusqueda.porCorreo);
    }
    public boolean eliminarContacto(String nombreContactoEliminar){
        boolean contactoEliminado=false;
        if (tamanoLista()==0){
          System.out.println("No hay contactos agregados");
        }else{
            for(int i=0; i<contactos.size(); i++){
                if(contactos.get(i).getNombre().equals(nombreContactoEliminar)){
                contactos.remove(i);
                contactoEliminado=true;
                }
            }
        }
        return contactoEliminado;
    }
    public int tamanoLista(){                                   //Función que regresa el numero de  
        return contactos.size();                                //contactos guardados en la agenda
    }
    public int tamanoLista2(List<Contacto> lista){                                   //Función que regresa el numero de  
        return lista.size();                                //contactos guardados en la agenda
    }
    public void imprimirContacto(Contacto contacto){
        System.out.println("-------------------------------------");
        System.out.println("Nombre: "+contacto.getNombre());
        System.out.println("Direccion: "+contacto.getDireccion());
        System.out.println("Fecha de Nacimiento: "+contacto.getFechaNacimiento());
        System.out.println("Ocupacion: "+contacto.getOcupacion());
        contacto.mostrarTelefonos();
        contacto.mostrarRedesSociales();
    }
    public void mostrarContactos(){
        if(tamanoLista()==0){
            System.out.println("No hay contactos en la agenda");
        }else{
        for(int i=0;i<tamanoLista();i++){
            System.out.println("Contacto "+i+1);
            imprimirContacto(contactos.get(i));
        }
        }
    }
}