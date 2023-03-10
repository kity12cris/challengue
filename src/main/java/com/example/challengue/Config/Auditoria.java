package com.example.challengue.Config;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter @Setter
public abstract class Auditoria {

    @CreatedBy
    protected String usuarioCreacion;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaCreacion;

    @LastModifiedBy
    protected String usuarioUltimaActualizacion;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaultimaActualizacon;
}
