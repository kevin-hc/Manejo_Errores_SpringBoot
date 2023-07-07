package com.spring.error.errors;

public class UsuarioNoEncontrado extends RuntimeException{

    public UsuarioNoEncontrado(String id) {
        super("Usuario con id: ".concat(id).concat(" no existe en el sistema"));
    }

    private static final long serialVersionUID = 1L;
}
