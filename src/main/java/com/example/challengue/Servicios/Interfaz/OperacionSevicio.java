package com.example.challengue.Servicios.Interfaz;

import com.example.challengue.Dto.OperacionDTO;
import com.example.challengue.Entidad.Operacion;

import java.math.BigDecimal;

public interface OperacionSevicio {
    /**
     * @author cristina
     * @since 08/03/2023
     *
     * @return
     * @throws Exception
     */

    public OperacionDTO procesarPago (String origen, String destino, BigDecimal monto) throws Exception;

    /**
     * @author cristina
     * @since 08/03/2023
     *
     * @return
     * @throws Exception
     */

    public Operacion buscarOperacionPorId (Long id) throws Exception;
}
