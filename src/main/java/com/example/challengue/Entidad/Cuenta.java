package com.example.challengue.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="cuenta")
@Getter @Setter
public class Cuenta implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * numero de autoincremental de la Entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta")
    private Long idCuenta;

    /**
     * Saldo actual de la cuenta
     */
    @Column(name = "saldo")
    private BigDecimal saldo;

    /**
     * Tipo de cuenta
     */
    @Column(name = "tipo_cuenta")
    private String tipoCuenca;

    /**
     * numero de cuenta
     */
    @Column(name = "numero_cuenta")
    private String numeroCuenta;

}


