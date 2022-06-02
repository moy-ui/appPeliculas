/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.devmoy.peliculas.domain;

/**
 *
 * @author Moy
 */
public class Pelicula {
    private String nombre;
    
    public Pelicula(){
        
    }
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    //Setters y getters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre);
        return sb.toString();
    }
    
    
    
}
