package com.sheyla.challenge.alura.literalura.model.entity;

import com.sheyla.challenge.alura.literalura.model.DatosAutor;
import jakarta.persistence.*;

import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer anhioDeNacimiento;
    private Integer anhioDeFallecimiento;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private Set<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor autor) {
        this.nombre = autor.nombre();
        this.anhioDeNacimiento = autor.anhioDeNacimiento();
        this.anhioDeFallecimiento = autor.anhioDeFallecimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnhioDeNacimiento() {
        return anhioDeNacimiento;
    }

    public void setAnhioDeNacimiento(Integer anhioDeNacimiento) {
        this.anhioDeNacimiento = anhioDeNacimiento;
    }

    public Integer getAnhioDeFallecimiento() {
        return anhioDeFallecimiento;
    }

    public void setAnhioDeFallecimiento(Integer anhioDeFallecimiento) {
        this.anhioDeFallecimiento = anhioDeFallecimiento;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String librosEscritos = libros.stream()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));

        return """
                 ------------AUTOR--------------
                Autor: %s
                Fecha de nacimiento: %d
                Fecha de fallecimiento: %d
                Libros: [%s]
                 ------------------------------
                """.formatted(nombre, anhioDeNacimiento, anhioDeFallecimiento, librosEscritos);
    }
}
