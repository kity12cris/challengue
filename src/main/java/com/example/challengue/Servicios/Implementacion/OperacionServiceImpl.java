package com.example.challengue.Servicios.Implementacion;

import com.example.challengue.Dto.OperacionDTO;
import com.example.challengue.Entidad.Cuenta;
import com.example.challengue.Entidad.Operacion;
import com.example.challengue.Enum.TipoOperacionEnum;
import com.example.challengue.Repositorio.OperacionRepo;
import com.example.challengue.Servicios.Interfaz.CuentaServicio;
import com.example.challengue.Servicios.Interfaz.OperacionSevicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OperacionServiceImpl implements OperacionSevicio {

    @Autowired
    private OperacionRepo operacionRepo;

    @Autowired
    private CuentaServicio cuentaServicio;

    @Override
    public OperacionDTO procesarPago (String origen, String destino, BigDecimal monto) throws Exception{
        Cuenta cuentaOrigen= cuentaServicio.buscarCuentaPorNumeroCuenta(origen);
        Cuenta cuentaDestino=cuentaServicio.buscarCuentaPorNumeroCuenta(destino);
        if(cuentaServicio.actualizarSaldo(TipoOperacionEnum.RESTA.getCodigo(),monto,cuentaOrigen.getNumeroCuenta())!=null){
            cuentaServicio.actualizarSaldo(TipoOperacionEnum.SUMA.getCodigo(),monto,cuentaDestino.getNumeroCuenta());
        }
        Operacion operacion=new Operacion(monto,cuentaOrigen,cuentaDestino,new Date());
        operacion=operacionRepo.save(operacion);
        OperacionDTO dto=contruirDto(operacion);
        return dto;
    }
    public OperacionDTO contruirDto(Operacion operacion) throws Exception{
        OperacionDTO dto=new OperacionDTO();
        dto.setCuentaOrigen(operacion.getCuentaOrigen().getNumeroCuenta());
        dto.setCuentaDestino(operacion.getCuentaDestino().getNumeroCuenta());
        dto.setNumeroOperacion(operacion.getIdOperacion());
        dto.setSaldoCuentaOrigen(operacion.getCuentaOrigen().getSaldo());
        dto.setSaldoCuentaDestino(operacion.getCuentaDestino().getSaldo());
        dto.setMonto(operacion.getMonto());
        return dto;
    }
    @Override
    public Operacion buscarOperacionPorId (Long id) throws Exception{
        Operacion operacion= new Operacion();
        operacion= operacionRepo.findById(id).orElse(null);
        return operacion;
    }
}
