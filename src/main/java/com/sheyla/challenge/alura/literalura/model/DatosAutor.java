package com.sheyla.challenge.alura.literalura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") Integer anhioDeNacimiento,
        @JsonAlias("death_year") Integer anhioDeFallecimiento
) {}
