package com.aluracursos.LiterAlura.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    //@ManyToOne(fetch = FetchType.LAZY)
    private String titulo;
    private String autor;
    private String language;
    private Double numeroDeDescargas;


    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
       // this.autor = datosLibro.autor().toString();
        //this.language = datosLibro.language().toString();
    }

   // public Libro() {}

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autores=" + autor +
                ", language='" + language + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
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

    public String getAutores() {
        return autor;
    }

    public void setAutores(String autores) {
        this.autor = autores;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
