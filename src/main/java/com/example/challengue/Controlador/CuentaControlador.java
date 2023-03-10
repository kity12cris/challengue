package com.example.challengue.Controlador;

import com.example.challengue.Entidad.Cuenta;
import com.example.challengue.Servicios.Interfaz.CuentaServicio;
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

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CuentaControlador {
    public Logger logger = LoggerFactory.getLogger(CuentaControlador.class);

    @Autowired
    public CuentaServicio cuentaServicio;

    @GetMapping("/{id}")
    public Cuenta getById(@PathVariable(value = "id") String numeroCuenta) {
        try {
            return cuentaServicio.buscarCuentaPorNumeroCuenta(numeroCuenta);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al crear el evento");
        }
    }


}
