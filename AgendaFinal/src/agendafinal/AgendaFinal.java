/* Autores: Francisco Miranda y Renato Vargas
    Archivo: Agenda.java
    Fecha: 16/02/2016
    Descripción: Este programa permite al usuario tener un registro
                 de sus contactos.
*/
package agendafinal;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contacto;
import modelo.RedSocial;
import modelo.Telefono;

public class AgendaFinal {
    
    public static void main(String[] args) {
        boolean boleano=true;
        int x;
        String nombreContacto, fecha_nacimientoContacto,ocupacionContacto,direccionContacto, correoContacto;
        
        Agenda miAgenda=new Agenda();
        Scanner teclado = new Scanner(System.in);
        while(boleano==true){
        System.out.println("1.- Agregar contacto");
        System.out.println("2.- Eliminar contacto");
        System.out.println("3.- Mostrar contactos");
        System.out.println("4.- Buscar contactos");
        System.out.println("5.-Salir");
        x=teclado.nextInt();
        switch(x){
            case 1:
                Contacto contacto=new Contacto();          //Se crea un objeto de tipo Contacto
                                                    //Para almacenarlo en la lista
                System.out.println("Nombre: ");
                teclado.nextLine();
                nombreContacto= teclado.nextLine();
                contacto.setNombre(nombreContacto);

                System.out.println("Fecha de nacimiento: ");
                fecha_nacimientoContacto= teclado.nextLine();
                contacto.setFechaNacimiento(fecha_nacimientoContacto);   

                System.out.println("Ocupacion: ");
                ocupacionContacto= teclado.nextLine();
                contacto.setOcupacion(ocupacionContacto);

                System.out.println("Direccion: ");
                direccionContacto= teclado.nextLine();
                contacto.setDireccion(direccionContacto);
        
                RedSocial redsocial=new RedSocial();                        //Se crea un objeto de tipo Red Social                  //Se crea una lista de Redes sociales (Una lista por contacto)
                String tipo="", nombreusuario="", opcion="si", numero="";
                while(opcion.equals("si") || opcion.equals("SI") || opcion.equals("Si") || opcion.equals("sI")){
                    System.out.println("Ingresa el tipo de red social");
                    tipo=teclado.nextLine();
                    redsocial.setTipo(tipo);
                                                                            //Se lee la informacion
                    System.out.println("Ingresa el nombre de usuario");
                    nombreusuario=teclado.nextLine();
                    redsocial.setNombreUsuario(nombreusuario);

                    contacto.registrarRedesSociales(redsocial);                           //Se guarda el objeto en la lista
                    int band=0;
                    while(band==0){
                    System.out.println("¿Deseas agregar otra cuenta?(Si/No)");
                    opcion=teclado.nextLine();
                    if(opcion.equals("si")||opcion.equals("no")||opcion.equals("NO")||opcion.equals("nO")||opcion.equals("No")){
                        band=1;
                    }
                    }
                }
                 Telefono telefono=new Telefono();                   //Se crea un objeto de tipo telefono
                opcion="si";                                                     //Se crea una lista de Telefonos (Una lista por contacto)
                while(opcion.equals("si") || opcion.equals("SI") || opcion.equals("Si") || opcion.equals("sI")){
                    System.out.println("Ingresa el tipo de telefono");
                    tipo=teclado.nextLine();
                    telefono.setTipo(tipo);
                                                                            //Se leen los datos
                    System.out.println("Ingresa el numero de telefono");
                    numero=teclado.nextLine();
                    telefono.setNumero(numero);

                    contacto.registrarTelefonos(telefono);                               //Se guarda el objeto en la lista

                    int band=0;
                    while(band==0){
                    System.out.println("¿Deseas agregar otro telefono?(Si/No)");
                    opcion=teclado.next();
                    if(opcion.equals("si")||opcion.equals("no")||opcion.equals("NO")||opcion.equals("nO")||opcion.equals("No")){
                        band=1;
                    }
                    }
                }
                opcion="si";
                String correoElectronico="";
                while(opcion.equals("si") || opcion.equals("SI") || opcion.equals("Si") || opcion.equals("sI")){
                    System.out.println("Ingresa el correo electronico");
                    correoElectronico=teclado.next();
                    
                    contacto.registrarCorreosElectronicos(correoElectronico);                               //Se guarda el objeto en la lista

                    opcion="si";
                    int band=0;
                    while(band==0){
                    System.out.println("¿Deseas agregar otro correo electronico?(Si/No)");
                    opcion=teclado.next();
                    if(opcion.equals("si")||opcion.equals("no")||opcion.equals("NO")||opcion.equals("nO")||opcion.equals("No")){
                        band=1;
                    }
                    }
                }
                if(miAgenda.guardarContacto(contacto)==true){
                    System.out.println("El contacto se ha agregado correctamente");
                }else{
                    System.out.println("Ha habido un error, intenta nuevamente");
                }
                break;
            case 2:
                System.out.println("Ingrese el nombre del contacto");
                nombreContacto=teclado.next();
                if(miAgenda.eliminarContacto(nombreContacto)==false){
                    System.out.println("No se pudo eliminar el contacto o el nombre es incorrecto");
                }else{
                    System.out.println("Contacto eliminado correctamente");
                }
                break;
            case 3:
                miAgenda.mostrarContactos();
                break;
            case 4:
                boolean realizarBusqueda=true;
                int opcionBusqueda;
                while(realizarBusqueda==true){
                    System.out.println("Cómo desea buscar al contacto");
                    System.out.println("1.- Buscar por nombre");
                    System.out.println("2.- buscar por ocupacion");
                    System.out.println("3.- Buscar por fecha de nacimiento");
                    System.out.println("4.-Regresar");
                    opcionBusqueda=teclado.nextInt();
                    switch(opcionBusqueda){
                    case 1:
                        System.out.println("Ingrese el nombre del contacto");
                        nombreContacto=teclado.next();
                        miAgenda.imprimirBusqueda(miAgenda.buscarPorNombre(nombreContacto));
                        break;
                    case 2:
                        System.out.println("Ingrese la ocupacion del contacto");
                        ocupacionContacto=teclado.next();
                        miAgenda.imprimirBusqueda(miAgenda.buscarPorOcupacion(ocupacionContacto));
                        break;
                    case 3:
                        System.out.println("Ingrese la fecha de nacimiento del contacto");
                        fecha_nacimientoContacto=teclado.nextLine();
                         miAgenda.imprimirBusqueda(miAgenda.buscarPorFechaNacimiento(fecha_nacimientoContacto));
                        break;
                    case 4:
                        System.out.println("Ingrese el correo electronico");
                        correoContacto=teclado.next();
                         miAgenda.imprimirBusqueda(miAgenda.buscarPorFechaNacimiento(correoContacto));
                        break;
                    case 5:
                        realizarBusqueda=false;
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
                }
                        break;
            case 5:
                boleano=false;
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;
        }
        }       
    }
}

