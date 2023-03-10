package com.example.challengue.Enum;

public enum TipoOperacionEnum {
    SUMA("SUM", "SUMA"),
    RESTA("RES", "RESTA");

    /**
     * Texto corto que respresenta el código que identifica el tipo de operación
     */
    private String codigo;

    /**
     * Texto que describe el tipo de operación
     */
    private String descripcion;

    private TipoOperacionEnum(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
