
package com.parqueo.krpp.modelo;


abstract class persona {
    private Integer nroCedula;
    private String nombreCompleto;
    private Integer edad;
    private sexo sexo;
    private estadoCivil estadoCivil;
    private Integer anhoNacimiento;

   

   
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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
        return anhoNacimiento;
    }

    public void setAnhoNacimiento(Integer anhoNacimiento) {
        this.anhoNacimiento = anhoNacimiento;
    }
    
}
