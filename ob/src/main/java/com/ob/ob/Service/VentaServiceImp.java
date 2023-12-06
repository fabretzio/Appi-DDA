package com.ob.ob.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.Entity.VentaEntity;
import com.ob.ob.Repository.ClienteRepository;
import com.ob.ob.Repository.ProductoRepository;
import com.ob.ob.Repository.VentaRepository;
import com.ob.ob.Utils.AppException;

@Service
public class VentaServiceImp implements VentaService{
    
    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProductoRepository productoRepository;


    @Override
    public VentaEntity save(VentaEntity ventaEntity){
        ventaRepository.save(ventaEntity);
        System.out.println(ventaRepository.findById(ventaEntity.getId()).get().getCliente().getNombre());
        return ventaRepository.findById(ventaEntity.getId()).get();
    }

    @Override
    public String delete( int id ) throws AppException{
        if(ventaRepository.existsById(id)){
            ventaRepository.deleteById(id);
            return "Venta eliminada con éxito";
        }
        throw new AppException("El codigo de venta no existe");
    }

    @Override
    public VentaEntity update(VentaEntity ventaEntity) throws AppException{
        if(ventaRepository.existsById(ventaEntity.getId())){
            return ventaRepository.save(ventaEntity);
        }
        throw new AppException("La venta no existe");

    }

    @Override
    public Optional<VentaEntity> get (int id){
        return ventaRepository.findById(id);
    }
}
