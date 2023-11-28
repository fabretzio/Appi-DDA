package com.ob.ob.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class ClienteVipEntity extends ClienteEntity{
    
    @Column
    @DateTimeFormat
    private Date fechaVip;

    public Date getFechaVip() {
        return fechaVip;
    }

    public void setFechaVip(Date fechaVip) {
        this.fechaVip = fechaVip;
    }

    public ClienteVipEntity(int id, String nombre, String direccion, int numTel, Date fechaVip) {
        super(id, nombre, direccion, numTel);
        this.fechaVip = fechaVip;
    }

    public ClienteVipEntity(){
    }
}
