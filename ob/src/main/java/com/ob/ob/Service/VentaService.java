package com.ob.ob.Service;

import java.util.Optional;

import com.ob.ob.Entity.VentaEntity;
import com.ob.ob.Utils.AppException;

public interface VentaService {
    public VentaEntity save (VentaEntity ventaEntity);
    public String delete (int id) throws AppException;
    public VentaEntity update (VentaEntity ventaEntity) throws AppException;
    // public void addCliente(int idCliente, int idVenta) throws AppException;
    // public void addProducto (int idProducto, int idVenta) throws AppException;
    public Optional<VentaEntity> get (int id);
}
