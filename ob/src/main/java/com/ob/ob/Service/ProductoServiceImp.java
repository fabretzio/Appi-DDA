package com.ob.ob.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.Entity.ProductoEntity;
import com.ob.ob.Repository.ProductoRepository;
import com.ob.ob.Utils.AppException;

@Service
public class ProductoServiceImp implements ProductoService{
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public ProductoEntity save(ProductoEntity productoEntity){
        return productoRepository.save(productoEntity);
    }

    @Override
    public String delete( int id ) throws AppException{
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return "Producto eliminado con éxito";
        }
        throw new AppException("El codigo de producto no existe");
    }

    @Override
    public ProductoEntity update(ProductoEntity productoEntity) throws AppException{
        if(productoRepository.existsById(productoEntity.getCodigo())){
            return productoRepository.save(productoEntity);
        }
        throw new AppException("El producto no existe");

    }

    @Override
    public Optional<ProductoEntity> get (int id){
        return productoRepository.findById(id);
    }
}
