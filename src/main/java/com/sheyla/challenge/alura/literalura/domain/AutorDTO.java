package com.sheyla.challenge.alura.literalura.domain;
import com.sheyla.challenge.alura.literalura.model.entity.Autor;
import com.sheyla.challenge.alura.literalura.model.entity.Libro;

import java.util.stream.Collectors;

public record AutorDTO( String nombre,
                        Integer anhioDeNacimiento,
                        Integer anhioDeFallecimiento,
                        String librosEscritos) {

    public AutorDTO(Autor autor) {
        this(
                autor.getNombre(),
                autor.getAnhioDeNacimiento(),
                autor.getAnhioDeFallecimiento(),
                autor.getLibros()
                        .stream()
                        .map(Libro::getTitulo)
                        .collect(Collectors.joining(", "))
        );
    }

    @Override
    public String toString() {
        return """
                 --------- AUTOR ---------
                Autor: %s
                Fecha de nacimiento: %d
                Fecha de fallecimiento: %d
                Libros: [%s]
                 --------------------------
                """.formatted(nombre, anhioDeNacimiento, anhioDeFallecimiento, librosEscritos);
    }


}
