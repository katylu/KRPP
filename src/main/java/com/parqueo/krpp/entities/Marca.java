
package com.parqueo.krpp.entities;

import javax.persistence.*;

@Entity
@Table(name = "MARCA")
@NamedQueries({
   @NamedQuery(name = "Marca.getAll", query = "SELECT c FROM Marca c "),
})
public class Marca {

    @Id
    @Column(name = "ID")
    private Integer idMarca;

    @Column(name = "NOMBRE_MARCA")
    private String nombreMarca;

    public Marca() {
    }

    public Marca(Integer idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
    
}
