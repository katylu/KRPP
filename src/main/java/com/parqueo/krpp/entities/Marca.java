
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
    @SequenceGenerator(name="marca_seq", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_seq")
    private Integer idMarca;

    @Column(name = "NOMBRE_MARCA")
    private String nombreMarca;

    public Marca() {
    }

    public Marca(Integer idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public Marca(String nombreMarca) {
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

    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", nombreMarca='" + nombreMarca + '\'' +
                '}';
    }
}
