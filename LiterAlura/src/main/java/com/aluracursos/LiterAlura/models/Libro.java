package com.aluracursos.LiterAlura.models;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;


@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    private String autor;
    private List<String> language;
    private String numeroDeDescargas;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autor = datosLibro.autor().toString();
        this.language = Collections.singletonList(datosLibro.idiomas().get(0));
        this.numeroDeDescargas = datosLibro.numDescargas();
    }

    public Libro(Datos datos) {
    }


    @Override
    public String toString() {
        return
                " titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", language='" + language + '\'' +
                ", Descargas= " + numeroDeDescargas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public String getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(String numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
