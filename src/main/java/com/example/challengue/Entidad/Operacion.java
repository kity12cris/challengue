package com.example.challengue.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="operacion")
@Getter @Setter
public class Operacion implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * numero de autoincremental de la Entidad
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion")
    private Long idOperacion;

    /**
     * Monto que se uso para actualizar saldo de una cuenta
     */
    @Column(name = "monto")
    private BigDecimal monto;

    /**
     * Id de la cuenta de Origen
     */
    @JoinColumn(name = "id_cuenta_origen", referencedColumnName = "id_cuenta", foreignKey = @ForeignKey(name = "fk_operacion_cuenta_origen"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuentaOrigen;

    /**
     * Id de la cuenta de Origen
     */
    @JoinColumn(name = "id_cuenta_destino", referencedColumnName = "id_cuenta", foreignKey = @ForeignKey(name = "fk_operacion_cuenta_destino"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuentaDestino;


    /**
     * fecha en la que se realizo la operacion
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    public Operacion(BigDecimal monto, Cuenta cuentaOrigen, Cuenta cuentaDestino, Date fecha) {
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fecha = fecha;
    }
    public Operacion() {

    }
}
