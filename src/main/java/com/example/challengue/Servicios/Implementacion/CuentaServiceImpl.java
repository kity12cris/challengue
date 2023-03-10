package com.example.challengue.Servicios.Implementacion;

import com.example.challengue.Controlador.CuentaControlador;
import com.example.challengue.Entidad.Cuenta;
import com.example.challengue.Enum.TipoOperacionEnum;
import com.example.challengue.Repositorio.CuentaRepo;
import com.example.challengue.Servicios.Interfaz.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaServiceImpl implements CuentaServicio {
    @Autowired
    private CuentaRepo cuentaRepo;

    @Override
    public Cuenta buscarCuentaPorNumeroCuenta (String numero) throws Exception{
        Cuenta cuenta= new Cuenta();
        cuenta=cuentaRepo.findByNumeroCuenta(numero);
        return cuenta;
    }

    @Override
    public Cuenta actualizarSaldo(String tipoOperacion, BigDecimal cantidad, String numeroCuenta)throws Exception{
        Cuenta cuenta=new Cuenta();
        cuenta=cuentaRepo.findByNumeroCuenta(numeroCuenta);
        if(tipoOperacion.equals(TipoOperacionEnum.RESTA.getCodigo())){
            if(comparaCantidadySaldo(cantidad,cuenta.getSaldo())){
                cuenta.setSaldo(cuenta.getSaldo().subtract(cantidad));
            }else{
                return null;
            }
        }else if(tipoOperacion.equals(TipoOperacionEnum.SUMA.getCodigo())){
            cuenta.setSaldo(cuenta.getSaldo().add(cantidad));
        }
        cuenta=cuentaRepo.save(cuenta);
        return cuenta;
    }

    public boolean comparaCantidadySaldo(BigDecimal cantidad,BigDecimal saldo){
        if(cantidad.compareTo(saldo)==1){
            return false;
        }
        return true;
    }
}
