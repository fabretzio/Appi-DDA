package com.ob.ob.Service;

import java.util.Optional;

import com.ob.ob.Entity.ProductoEntity;
import com.ob.ob.Utils.AppException;

public interface ProductoService {
    public ProductoEntity save (ProductoEntity productoEntity);
    public String delete (int id) throws AppException;
    public ProductoEntity update (ProductoEntity productoEntity) throws AppException;
    public Optional<ProductoEntity> get (int id);
}
