package com.ob.ob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ob.ob.Entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer>{
    
}
