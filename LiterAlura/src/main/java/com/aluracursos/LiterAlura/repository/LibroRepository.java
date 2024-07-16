package com.aluracursos.LiterAlura.repository;

import com.aluracursos.LiterAlura.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    List<Libro> findLibrosByIdiomasContaining(String idioma);
}
