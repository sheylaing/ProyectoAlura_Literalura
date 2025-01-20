package com.sheyla.challenge.alura.literalura.service;

import com.sheyla.challenge.alura.literalura.domain.AutorDTO;
import com.sheyla.challenge.alura.literalura.domain.LibroDTO;
import com.sheyla.challenge.alura.literalura.model.entity.Autor;
import com.sheyla.challenge.alura.literalura.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;


    public List<AutorDTO> obtenerAutores() {
        List<AutorDTO> autores = repository.findAll().stream()
                .map(autor -> new AutorDTO(autor))
                .toList();
        if (autores.isEmpty()) {
            imprimirSinResultados();
        }

        return autores;
    }


    public List<AutorDTO> obtenerAutoresVivosPorAnio(int anio) {
        List<AutorDTO> autoresVivos = repository.obtenerAutoresVivosPorAnio(anio).stream()
                .map(autor -> new AutorDTO(autor))
                .toList();
        if (autoresVivos.isEmpty()) {
            imprimirSinResultados();
        }

        return autoresVivos;
    }

    private void imprimirSinResultados() {
        System.out.println("---------- RESULTADO -----------");
        System.out.println("sin resultados");
        System.out.println("--------------------------------");
    }
}
