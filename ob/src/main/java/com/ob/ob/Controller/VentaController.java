package com.ob.ob.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ob.ob.Entity.VentaEntity;
import com.ob.ob.Service.VentaService;
import com.ob.ob.Utils.AppException;

@Controller
@RequestMapping("/Venta")

public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<?> altaVenta(@RequestBody VentaEntity ventaEntity){
       return ResponseEntity.status(HttpStatus.OK).body(ventaService.save(ventaEntity));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getVenta(@PathVariable int id){
       return ResponseEntity.status(HttpStatus.OK).body(ventaService.get(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable int id){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.delete(id));
        } 
        catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problema interno en el servidor.");
        }
    }


}
