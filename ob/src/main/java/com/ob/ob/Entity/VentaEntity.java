package com.ob.ob.Entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class VentaEntity {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int cantidad;

    @Column
    @DateTimeFormat
    private Date fechaVenta;

    @ManyToOne
    @JoinColumn(name="cliente", referencedColumnName = "id")
    private ClienteEntity cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany
    @JoinTable(name = "ventasProductos",
    joinColumns = @JoinColumn(name="id_venta"),
    inverseJoinColumns = @JoinColumn(name="idProducto"))
    private Set<ProductoEntity> productos = new HashSet<>();

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
 
    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Set<ProductoEntity> getProductos() {
        return productos;
    }

    public void setProductos(Set<ProductoEntity> productos) {
        this.productos = productos;
    }

    public VentaEntity(int id, int cantidad, Date fechaVenta, ClienteEntity cliente, Set<ProductoEntity> productos) {
        this.id = id;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.cliente = cliente;
        this.productos = productos;
    }

    public VentaEntity() {
    }

    
}
