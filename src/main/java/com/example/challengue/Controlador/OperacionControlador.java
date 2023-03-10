package com.example.challengue.Controlador;

import com.example.challengue.Dto.OperacionDTO;
import com.example.challengue.Entidad.Operacion;
import com.example.challengue.Servicios.Interfaz.OperacionSevicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@RequestMapping("/operacion")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class OperacionControlador {
    public Logger logger = LoggerFactory.getLogger(CuentaControlador.class);

    @Autowired
    public OperacionSevicio operacionSevicio;

    @GetMapping("/{cuentaOrigen}/{cuentaDestino}/{monto}")
    public OperacionDTO getById(@PathVariable(value = "cuentaOrigen") String cuentaOrigen,
                                @PathVariable(value = "cuentaDestino") String cuentaDestino,
                                @PathVariable(value = "monto") BigDecimal monto) {
        try {
            return operacionSevicio.procesarPago(cuentaOrigen,cuentaDestino,monto);
        } catch (Exception e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Error al procesar pago");
        }
    }
    @GetMapping("buscarOperacionPorId/{id}")
    public Operacion getById(@PathVariable(value = "id") Long id) {
        try {
            return operacionSevicio.buscarOperacionPorId(id);
        } catch (Exception e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Error al buscar la operacion");
        }
    }
}
