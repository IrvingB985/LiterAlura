package com.aluracursos.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;





@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title") String titulo,
        //@JsonAlias("authors") List<DatosAutor> autor
        @JsonAlias("authors") String autor)
        //@JsonAlias("languages") List<String> language)
        {

}
