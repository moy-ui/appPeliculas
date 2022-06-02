/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.devmoy.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.devmoy.peliculas.domain.Pelicula;
import mx.com.devmoy.peliculas.excepciones.AccesoADatosEx;
import mx.com.devmoy.peliculas.excepciones.EscrituraDatosEx;
import mx.com.devmoy.peliculas.excepciones.LecturaDatosEx;

/**
 *
 * @author Moy
 */
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoADatosEx{
        File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");
        return file.exists();

    }

    @Override
    public List<Pelicula> listar(String nombreArchivo)throws AccesoADatosEx {
        List<Pelicula> peliculas = new ArrayList<>();
        File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea = br.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Error al listar peliculas:" + ex.getMessage());
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error al listar peliculas:" + ex.getMessage());
        }
        
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoADatosEx {

        //throw new EscrituraDatosEx("Error al escribir en el archivo");
        File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");

        try {
            FileWriter salida = new FileWriter(file,anexar);
            salida.write(pelicula.toString() + "\n");
            salida.close();
            System.out.println("Se a escrito informacion al archivo " + nombreArchivo);
        } catch (Exception ex) {
            ex.getMessage();
            throw new EscrituraDatosEx("Error al escribir lectura");
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws AccesoADatosEx {
        
        BufferedReader br = null;
        boolean resultado = false;
        var indice = 0;
        try {
            
            File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");
            br = new BufferedReader(new FileReader(file));
            String valor = br.readLine();
            
            while(valor != null){
                if (valor.equalsIgnoreCase(buscar)) {
                    resultado = true;
                }
                valor = br.readLine();
                indice++;
                
            }

        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                throw  new LecturaDatosEx("Hubo un error al buscar pelicula");
            }
        }
        return resultado ? "#" + indice + ".-" + buscar : "no se encontro nada";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoADatosEx {
        File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");

        try {
            FileWriter fw = new FileWriter(file);
            fw.close();
            System.out.println("Se ha creado con existo");
        } catch (Exception e) {
            e.printStackTrace();
            throw new AccesoADatosEx("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoADatosEx {
        File file = new File("C:\\CatalogoPeliculas\\" + nombreArchivo + ".txt");
        
        if (file.exists()) {
            boolean status = file.delete();
            System.out.println(status ? "Eliminado" : "hubo algun error");
        }
        

    }

}
