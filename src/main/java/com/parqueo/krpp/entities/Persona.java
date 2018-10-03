
package com.parqueo.krpp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer idPersona;

    @Column(name="NRO_CEDULA")
    private Integer nroCedula;
    
    @Column(name="NOMBRE_COMPLETO")
    private String nombreCompleto;
      
    @Column(name="FECHA_NACIMIENTO")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Column(name="ESTADO_CIVIL")
    private String estadoCivil;
    
    @Column(name="SEXO")
    private String sexo;
    

    public Persona() {
    }

    public Persona(Integer idPersona, Integer nroCedula, String nombreCompleto, Date fechaNacimiento, String estadoCivil, String sexo) {
        this.idPersona = idPersona;
        this.nroCedula = nroCedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public Integer getNroCedula() {
        return nroCedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void setNroCedula(Integer nroCedula) {
        this.nroCedula = nroCedula;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


}
