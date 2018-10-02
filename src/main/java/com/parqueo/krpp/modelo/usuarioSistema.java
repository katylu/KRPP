
package com.parqueo.krpp.modelo;

import sun.security.util.Password;


public class usuarioSistema {
    private String nombreUsuario;
    private Password contraseña;
    private String nombreVisualizado;
    private privilegioUsuario privilegio;

    public usuarioSistema() {
    }

    public usuarioSistema(String nombreUsuario, Password contraseña, String nombreVisualizado, privilegioUsuario privilegio) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombreVisualizado = nombreVisualizado;
        this.privilegio = privilegio;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Password getContraseña() {
        return contraseña;
    }

    public void setContraseña(Password contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreVisualizado() {
        return nombreVisualizado;
    }

    public void setNombreVisualizado(String nombreVisualizado) {
        this.nombreVisualizado = nombreVisualizado;
    }

    public privilegioUsuario getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(privilegioUsuario privilegio) {
        this.privilegio = privilegio;
    }
    
    
}
