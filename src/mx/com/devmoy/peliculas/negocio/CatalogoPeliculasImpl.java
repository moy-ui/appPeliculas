/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.devmoy.peliculas.negocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.devmoy.peliculas.datos.*;
import mx.com.devmoy.peliculas.domain.Pelicula;
import mx.com.devmoy.peliculas.excepciones.AccesoADatosEx;

/**
 *
 * @author Moy
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    private final AccesoDatos datos;
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        
        try {
            AccesoDatosImpl acceso = new AccesoDatosImpl();
            Pelicula pelicula = new Pelicula(nombrePelicula);
            
            acceso.escribir(pelicula, nombreArchivo, true);
        } catch (AccesoADatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        int contador = 0;
        try {
            AccesoDatosImpl acceso = new AccesoDatosImpl();
            List list = acceso.listar(nombreArchivo);
            
            System.out.println("PELICULAS --> " + nombreArchivo);
            list.forEach(Peliculas ->{
                System.out.println("### " + Peliculas + " ###");
            });
        } catch (AccesoADatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            AccesoDatosImpl acceso = new AccesoDatosImpl();
            String nombre = acceso.buscar(nombreArchivo, buscar);
            System.out.println("Pelicula= " + nombre);
        } catch (AccesoADatosEx ex) {
            ex.getMessage();
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            AccesoDatosImpl acceso = new AccesoDatosImpl();
            acceso.crear(nombreArchivo);
        } catch (AccesoADatosEx ex) {
            ex.getMessage();
        }
    }
    
}
