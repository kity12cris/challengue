package com.example.challengue.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OperacionDTO {
    private String cuentaOrigen;
    private String cuentaDestino;
    private Long numeroOperacion;
    private BigDecimal saldoCuentaOrigen;
    private BigDecimal saldoCuentaDestino;
    private BigDecimal monto;
    public OperacionDTO(){

    }

}
