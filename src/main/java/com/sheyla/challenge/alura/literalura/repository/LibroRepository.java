package com.sheyla.challenge.alura.literalura.repository;

import com.sheyla.challenge.alura.literalura.model.entity.Idioma;
import com.sheyla.challenge.alura.literalura.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface LibroRepository  extends JpaRepository<Libro, Long>{

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> obtenerLibrosPorIdioma(Idioma idioma);

    Optional<Libro> findByTitulo(String titulo);

}
