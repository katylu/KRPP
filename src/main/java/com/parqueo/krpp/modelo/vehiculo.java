
package com.parqueo.krpp.modelo;


public class vehiculo {
    private Integer nroChapa;
    private tipoVehiculo tipoVehiculo;
    private marca marca;
    private modelo modelo;
    private Integer anhoVehiculo;
    private String color;

    public vehiculo(Integer nroChapa, tipoVehiculo tipoVehiculo, marca marca, modelo modelo, Integer anhoVehiculo, String color) {
        this.nroChapa = nroChapa;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anhoVehiculo = anhoVehiculo;
        this.color = color;
    }

    public Integer getNroChapa() {
        return nroChapa;
    }

    public void setNroChapa(Integer nroChapa) {
        this.nroChapa = nroChapa;
    }

    public tipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(tipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public marca getMarca() {
        return marca;
    }

    public void setMarca(marca marca) {
        this.marca = marca;
    }

    public modelo getModelo() {
        return modelo;
    }

    public void setModelo(modelo modelo) {
        this.modelo = modelo;
    }

    public Integer getAnhoVehiculo() {
        return anhoVehiculo;
    }

    public void setAnhoVehiculo(Integer anhoVehiculo) {
        this.anhoVehiculo = anhoVehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
