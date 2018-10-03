
package com.parqueo.krpp.modelo;


abstract class persona {
    private Integer nroCedula;
    private String nombreCompleto;
    private sexo sexo;
    private estadoCivil estadoCivil;
    private Integer fechaNacimiento;

   

   
    public Integer getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(Integer nroCedula) {
        this.nroCedula = nroCedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public sexo getSexo() {
        return sexo;
    }

    public void setSexo(sexo sexo) {
        this.sexo = sexo;
    }

    public estadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(estadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getAnhoNacimiento() {
        return fechaNacimiento;
    }

    public void setAnhoNacimiento(Integer anhoNacimiento) {
        this.fechaNacimiento = anhoNacimiento;
    }
    
}
