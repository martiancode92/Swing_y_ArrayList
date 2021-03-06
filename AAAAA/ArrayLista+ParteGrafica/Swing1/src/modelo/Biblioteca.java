/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Biblioteca {

    ArrayList<Usuario> usuarios;
    ArrayList<Libro> libros;

    public Biblioteca() {

// creamos los dos conjuntos vacios de usuarios y libros               
        usuarios = new ArrayList<>();
        libros = new ArrayList<>();
        

    }

    /**
     * * Método para añadir libros sin ninguna comprobación
     * @param isbn
     * @param libro
     * @param autor
     * @param editorial
     */
    public void nuevoLibro(String isbn, String libro, String autor, String editorial) {

        libros.add(new Libro(isbn, libro, autor, editorial));
    }
    
    
 /*
         * @param login     
         * @param contra     
         * @return  devuelve si lo ha podido añadir o no    
 */   
    public int nuevoUsuario(String nombre, String login, String contra) {

        // No puede haber dos usuarios en la biblioteca con el mismo nombre
        int pos = busqueda(nombre);
        if (pos == -1) {
            // Si devuelve -1 es que no hay un usuario con ese nombre. 
            usuarios.add(new Usuario(nombre, login, contra));
        }
        return pos;
    }
    

        
 /*
    * Método de búsqueda de un nombre en la colección de usuarios    
    * @param nombre a buscar    
    * @return  devuelve el valor -1 en el caso de no encontrarlo y     
    * en caso contrario la posición donde lo ha encontrado      

 */   
     public int busqueda(String nombre) {
      
        
          boolean encontrado = false;
        int pos = 0;
        while (!encontrado && pos < usuarios.size()) {
            if (nombre.equalsIgnoreCase(usuarios.get(pos).getNombre())) {
                encontrado = true;
            } else {
                pos++;
                if (!encontrado) {
                    pos = -1;
                }
              

            }

        }
          return pos;
     }

}
