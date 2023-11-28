package com.ob.ob.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ob.ob.Entity.ClienteEntity;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
    
}
