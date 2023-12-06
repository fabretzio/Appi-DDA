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

import com.ob.ob.Entity.ClienteNormalEntity;
import com.ob.ob.Entity.ClienteVipEntity;
import com.ob.ob.Service.ClienteService;
import com.ob.ob.Utils.AppException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clienteVip")
    public ResponseEntity<?> altaVip(@RequestBody ClienteVipEntity clienteVipEntity){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteVipEntity));
    }

    @PostMapping("/clienteNormal")
    public ResponseEntity<?> altaClienteNormal(@RequestBody ClienteNormalEntity clienteNormalEntity){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(clienteNormalEntity));
    }
   
    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable int id){
        try {
           clienteService.delete(id);
           return ResponseEntity.status(HttpStatus.OK).body("Cliente eliminado");
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
         catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno.");
        }
    }

    @PutMapping("/ClienteVip")
    public ResponseEntity<?> modificarVip(@RequestBody ClienteVipEntity clienteVipEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(clienteVipEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno.");
        }
    }
     @PutMapping("/ClienteNormal")
    public ResponseEntity<?> modificarNormal(@RequestBody ClienteNormalEntity clienteNormalEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(clienteNormalEntity));
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error interno.");
        }
    }
}
