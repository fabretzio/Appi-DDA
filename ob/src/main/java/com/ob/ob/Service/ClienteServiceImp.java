package com.ob.ob.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.ob.Entity.ClienteEntity;
import com.ob.ob.Repository.ClienteRepository;
import com.ob.ob.Utils.AppException;

@Service
public class ClienteServiceImp implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteEntity save (ClienteEntity clienteEntity){
        return clienteRepository.save(clienteEntity);
    }

    @Override
    public String delete (int id) throws AppException{
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return "Cliente eliminado con éxito";
        }
        throw new AppException("El id de cliente no existe");
    }

    @Override
    public ClienteEntity update(ClienteEntity clienteEntity) throws AppException{
        if(clienteRepository.existsById(clienteEntity.getId())){
            return clienteRepository.save(clienteEntity);
        }
        throw new AppException("El empleado no existe");

    }

    @Override
    public Optional<ClienteEntity> get(int id){
        return clienteRepository.findById(id);
    }
}
