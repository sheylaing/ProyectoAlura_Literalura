package com.sheyla.challenge.alura.literalura.ui;

import com.sheyla.challenge.alura.literalura.domain.LibroDTO;
import com.sheyla.challenge.alura.literalura.domain.AutorDTO;
import com.sheyla.challenge.alura.literalura.model.Datos;
import com.sheyla.challenge.alura.literalura.model.DatosLibro;
import com.sheyla.challenge.alura.literalura.model.entity.Autor;
import com.sheyla.challenge.alura.literalura.model.entity.Idioma;
import com.sheyla.challenge.alura.literalura.model.entity.Libro;
import com.sheyla.challenge.alura.literalura.service.AutorService;
import com.sheyla.challenge.alura.literalura.service.provider.ConsumoAPI;
import com.sheyla.challenge.alura.literalura.service.provider.ConvertirDatos;
import com.sheyla.challenge.alura.literalura.service.LibroService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class AppConsole {
    private static final String URL_BASE = "https://gutendex.com/books/";

    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = ConsumoAPI.getInstance();
    private ConvertirDatos conversor = ConvertirDatos.getInstance();

    public void ejecutarOperaciones() {
        int operacion = -1;
        while (operacion != 0) {
            mostrarMenu();
            try {
                operacion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opciones válidas: 0, 1, 2, 3, 4, 5");
                continue;
            } finally {
                teclado.nextLine();
            }
            switch (operacion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosPorAnio();
                    break;
                case 5:
                    mostrarIdiomas();
                    listarLibrosPorIdioma();
                    break;
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("""
                Menu de opciones:
                1- Búsqueda de libro por título
                2- Listar libros registrados
                3- Listar autores registrados
                4- Listar autores vivos en un determinado año
                5- Listar libros por idioma
                0- Salir
                Elija la opción a través de su número:                
                """);
    }

    public void mostrarIdiomas() {
        for (Idioma idioma : Idioma.values()) {
            System.out.println(idioma.mostrar());
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el Titulo del libro que desea buscar");
        String titulo = teclado.nextLine();

        String json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));

        DatosLibro libroBuscado = conversor.obtenerDatos(json, Datos.class).libros().get(0);
        LibroDTO libroNuevo = libroService.guardarLibro(libroBuscado);
        System.out.println(libroNuevo);
    }

    private void listarLibrosRegistrados() {
        List<LibroDTO> librosRegistrados = libroService.obtenerLibros();
        librosRegistrados.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<AutorDTO> autoresRegistrados = autorService.obtenerAutores();
        autoresRegistrados.forEach(System.out::println);
    }

    private void listarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año para listar los autores vivos: ");
        int anio = 0;
        try {
            anio = teclado.nextInt();
            List<AutorDTO> autoresVivos = autorService.obtenerAutoresVivosPorAnio(anio);
            autoresVivos.forEach(System.out::println);
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un año inválido. No se pudo realizar la búsqueda.");
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma deseado: ");
        String abreviatura = teclado.nextLine();
        Idioma idioma = Idioma.fromString(abreviatura);

        List<LibroDTO> librosPorIdioma = libroService.obtenerLibrosPorIdioma(idioma);
        librosPorIdioma.forEach(System.out::println);
    }
}
