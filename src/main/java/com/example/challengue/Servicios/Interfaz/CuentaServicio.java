package com.example.challengue.Servicios.Interfaz;

import com.example.challengue.Entidad.Cuenta;

import java.math.BigDecimal;

public interface CuentaServicio {
    /**
     * @author cristina
     * @since 03/03/2023
     *
     * @return
     * @throws Exception
     */
    public Cuenta buscarCuentaPorNumeroCuenta (String numero) throws Exception;

    /**
     * @author cristina
     * @since 08/03/2023
     *
     * @return
     * @throws Exception
     */
    public Cuenta actualizarSaldo(String tipoOperacion, BigDecimal cantidad, String numeroCuenta)throws Exception;
}
