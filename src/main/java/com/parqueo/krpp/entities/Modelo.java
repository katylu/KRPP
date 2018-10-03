
package com.parqueo.krpp.entities;

import javax.persistence.*;

@Entity
@Table(name = "MODELO")
public class Modelo {
    @Id
    @Column(name = "ID")
    private Integer idModelo;

    @Column(name="NOMBRE_MODELO")
    private String nombreModelo;

    @JoinColumn(name = "MARCA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Marca marca;

    public Modelo(Integer idModelo, String nombreModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
