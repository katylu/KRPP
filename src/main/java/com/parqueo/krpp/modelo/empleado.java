
package com.parqueo.krpp.modelo;


public class empleado extends persona{
    private String cargo;
    private departamento departamento;
    private String anhoIngreso;

    public empleado(String cargo, departamento departamento, String anhoIngreso) {
        this.cargo = cargo;
        this.departamento = departamento;
        this.anhoIngreso = anhoIngreso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(departamento departamento) {
        this.departamento = departamento;
    }

    public String getAnhoIngreso() {
        return anhoIngreso;
    }

    public void setAnhoIngreso(String anhoIngreso) {
        this.anhoIngreso = anhoIngreso;
    }
    
}
