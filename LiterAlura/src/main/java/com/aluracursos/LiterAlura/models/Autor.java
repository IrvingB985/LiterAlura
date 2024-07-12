package com.aluracursos.LiterAlura.models;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombreAutor;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;

    //public Autor() {}

    public Autor(DatosAutor autor) {
        this.nombreAutor = autor.nombre();
        this.fechaDeNacimiento = Integer.valueOf(autor.fechaDeNacimiento());
        this.fechaDeFallecimiento= Integer.valueOf(autor.fechaDeMuerte());

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", fechaDeFallecimiento=" + fechaDeFallecimiento +
                '}';
    }
}
