package com.aluracursos.LiterAlura.Principal;

import com.aluracursos.LiterAlura.Services.ConsumoAPI;
import com.aluracursos.LiterAlura.Services.ConvierteDatos;
import com.aluracursos.LiterAlura.models.Datos;
import com.aluracursos.LiterAlura.models.DatosLibro;
import com.aluracursos.LiterAlura.models.Libro;
import com.aluracursos.LiterAlura.repository.LibroRepository;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private final String URL = "https://gutendex.com/books/?search=";
    ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;

    public Principal(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }

    //###############Menu###################################
    public void muestaMenu() {
        var opcion = -1;
        while (opcion != 0) {

            var menu = """
                    #/#/#/#/#/#/#/#/#/#/#/#/#/#/#/#/
                    1 - Buscar series
                    2 - Mostrar búsqueda

                    0 - Salir
                    #/#/#/#/#/#/#/#/#/#/#/#/#/#/#/#/
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    opcion1();
                    break;
                case 2:
                    mostrarlista();
                    break;
                case 3:
                    filtroIdioma();
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }
    //##############opciones#############

    private DatosLibro buscarlibro() {
        System.out.println("###############################");
        System.out.println("# Escribe el título del libro #");
        System.out.println("###############################");
        var nombreLibro = teclado.nextLine();
        var json = ConsumoAPI.obtenerDatos(URL+nombreLibro.replace(" ","+"));
        return conversor.obtenerDatos(json, Datos.class).resultados().get(0);}

    private void opcion1(){
        DatosLibro datos =  buscarlibro();
        Libro libro = new Libro(datos);
        repositorio.save(libro);
        System.out.println(datos);}

    private void mostrarlista() {
        List<Libro> libros=repositorio.findAll();
        libros.forEach(System.out::println);

    }
    private boolean validadorIdioma(String idioma){
        return idioma.equals("es")||idioma.equals("en");
    }

    private void filtroIdioma() {
        System.out.println("""
                Filtrar por Idioma
                es - Español
                en - Ingles
                fr - Frances
                """);
        String idioma = teclado.nextLine().trim().toLowerCase();
        if(!validadorIdioma(idioma)){
            System.out.println("No existe");
            return;
        }
        List<Libro> librosPorIdioma = repositorio.findLibrosByIdiomasContaining(idioma);
    }

}

