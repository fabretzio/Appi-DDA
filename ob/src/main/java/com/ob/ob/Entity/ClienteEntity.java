package com.ob.ob.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ClienteEntity {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;

    @Column
    private String direccion;

    @Column
    private int numTel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public ClienteEntity(int id, String nombre, String direccion, int numTel) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numTel = numTel;
    }

    public ClienteEntity() {
    }

    
}
