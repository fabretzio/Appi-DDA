package com.ob.ob.Service;

import java.util.Optional;

import com.ob.ob.Entity.ClienteEntity;
import com.ob.ob.Utils.AppException;

public interface ClienteService {
    public ClienteEntity save (ClienteEntity clienteEntity);
    public String delete (int id) throws AppException;
    public ClienteEntity update (ClienteEntity clienteEntity) throws AppException;
    public Optional<ClienteEntity> get (int id);
}
