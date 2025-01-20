package com.sheyla.challenge.alura.literalura.service;

import com.sheyla.challenge.alura.literalura.domain.LibroDTO;
import com.sheyla.challenge.alura.literalura.model.DatosLibro;
import com.sheyla.challenge.alura.literalura.model.entity.Idioma;
import com.sheyla.challenge.alura.literalura.model.entity.Libro;
import com.sheyla.challenge.alura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;


    public LibroDTO guardarLibro(DatosLibro datos) {
        Optional<Libro> nuevo = repository.findByTitulo(datos.titulo());

        if(!nuevo.isPresent()) {
            Libro libro = repository.save(new Libro(datos));
            return new LibroDTO(libro);
        } else {
            System.out.println("------------- RESULTADO -------------");
            System.out.println("El libro ya existe en la base de datos");
            System.out.println("--------------------------------------");
        }

        return new LibroDTO(nuevo.get());
    }


    public LibroDTO obtenerLibroPorId(Long id) {
        return repository.findById(id).map(LibroDTO::new).orElse(null);
    }

    public List<LibroDTO> obtenerLibros() {
        List<LibroDTO> libros = repository.findAll().stream()
                .map(LibroDTO::new)
                .toList();

        if (libros.isEmpty()) {
            imprimirSinResultados();
        }

        return libros;
    }


    public List<LibroDTO> obtenerLibrosPorIdioma(Idioma idioma) {
        List<LibroDTO> librosPorIdioma =  repository.obtenerLibrosPorIdioma(idioma).stream()
                .map(LibroDTO::new)
                .toList();

        if (librosPorIdioma.isEmpty()) {
            imprimirSinResultados();
        }

        return librosPorIdioma;
    }

    private void imprimirSinResultados() {
        System.out.println("---------- RESULTADO -----------");
        System.out.println("sin resultados");
        System.out.println("--------------------------------");
    }
}
