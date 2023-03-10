package com.example.challengue.Repositorio;

import com.example.challengue.Entidad.Cuenta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CuentaRepo extends CrudRepository<Cuenta, Long> {

    Cuenta findByNumeroCuenta(String numeroCuenca);
}
