package com.bufete.bufete.entity;

public enum TipoDocumento {
    CC("CC - CEDULA DE CIUDADANIA"),
    TI("TI - TARJETA DE IDENTIDAD"),
    PA("PA - PASAPORTE"),
    MS("MS - MENOR SIN IDENTIFICACION"),
    AS("AS - ADULTO SIN IDENTIFICACION"),
    CE("CE - CEDULA DE EXTRANJERIA"),
    RC("RC - REGISTRO CIVIL"),
    CD("CD - CARNE DIPLOMATICO"),
    NI("NI - NIT"),
    NIU("NIU - NUMERO UNICO DE IDENTIFICACION"),
    PE("PE - PERMISO ESPECIAL PERMANENCIA"),
    SC("SC - SALVO CONDUCTO DC PERMANENCIA"),
    PT("PT - PERMISO POR PROTECCION TEMPORAL"),
    DE("DE - DOCUMENTO EXTRANJERO");

    private final String descripcion;

    TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
