package com.bufete.bufete.entity;

public enum TipoPersona {
    CLIENTE("Cliente"),
    TESTIGO("Testigo");

    private final String descripcion;

    TipoPersona(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}