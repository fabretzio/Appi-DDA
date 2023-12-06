package com.ob.ob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ob.ob.Entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer>{
    
}
