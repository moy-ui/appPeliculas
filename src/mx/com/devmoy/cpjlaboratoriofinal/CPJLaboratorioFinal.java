package mx.com.devmoy.cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.devmoy.peliculas.negocio.CatalogoPeliculasImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Moy
 */
public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        String nombreArchivo;
        String nombre;

        CatalogoPeliculasImpl catalogoPeliculas = new CatalogoPeliculasImpl();
        Scanner inn = new Scanner(System.in);

        do {
            System.out.println("Elige un numero \n"
                    + "1.- Iniciar Catalogo de peliculas \n"
                    + "2.- Agregar pelicula\n"
                    + "3.-Listar Peliculas\n"
                    + "4.-Buscar Pelicula\n"
                    + "0.-Salir");
            opcion = in.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Gracias!!!");
                    break;
                case 1:
                    System.out.println("Introdusca el nombre del catalogo:");
                    nombre = inn.nextLine();
                    catalogoPeliculas.iniciarArchivo(nombre);
                    break;
                case 2:
                    System.out.println("Escriba el nombre de la pelicula:");
                    String nombrePelicula = inn.nextLine();
                    System.out.println("Escriba el nombre del catalogo");
                    nombreArchivo = inn.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula, nombreArchivo);
                    break;
                case 3: 
                    System.out.println("Escriba el nombre del archivo para ver su contenido");
                    nombreArchivo = inn.nextLine();
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Escriba la pelicula que desea buscar");
                    nombre = inn.nextLine();
                    System.out.println("Escriba La categoria a la que pertenece");
                    nombreArchivo = inn.nextLine();
                    catalogoPeliculas.buscarPelicula(nombreArchivo, nombre);
                    break;
                default:
                    System.out.println("La opcion no exite seleccione otra opcion");
                    break;
                    
            }

        } while (opcion != 0);
    }
}
