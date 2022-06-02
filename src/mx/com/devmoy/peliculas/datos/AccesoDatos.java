/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.devmoy.peliculas.datos;

import java.util.List;
import mx.com.devmoy.peliculas.domain.Pelicula;
import mx.com.devmoy.peliculas.excepciones.AccesoADatosEx;

/**
 *
 * @author Moy
 */
public interface AccesoDatos {
    
    boolean existe(String nombreArchivo) throws AccesoADatosEx;
    public List<Pelicula> listar(String nombre) throws AccesoADatosEx;
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoADatosEx;
    public String buscar(String nombreArchivo, String buscar) throws AccesoADatosEx;
    public void crear(String nombreArchivo) throws AccesoADatosEx;
    public void borrar(String nombreArchivo) throws AccesoADatosEx;
}
