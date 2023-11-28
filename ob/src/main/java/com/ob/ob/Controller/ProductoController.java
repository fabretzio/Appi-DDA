package com.ob.ob.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ob.ob.Entity.ProductoEntity;
import com.ob.ob.Service.ProductoService;
import com.ob.ob.Utils.AppException;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> altaProducto(@RequestBody ProductoEntity productoEntity){
        return ResponseEntity.status(HttpStatus.OK).body(productoService.save(productoEntity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id){
        try {
        productoService.delete(id);
           return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado");
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno.");
        }
    }

    @PutMapping
    public ResponseEntity<?> modificarProducto(@RequestBody ProductoEntity productoEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productoService.update(productoEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno.");
        }
    }

}
