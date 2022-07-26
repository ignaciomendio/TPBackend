/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import tp.tpintegrador.models.Domicilio;
import tp.tpintegrador.services.DomicilioService;

/**
 *
 * @author imendiol
 */

@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/domicilio")
public class DomicilioController {
    
    @Autowired 
    private DomicilioService domicilioService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Domicilio>> listarDomicilios(){
        return new ResponseEntity<>(domicilioService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Domicilio> agregarDomicilio(@RequestBody Domicilio domicilio){
        return new ResponseEntity<>(domicilioService.save(domicilio), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Domicilio> actualizarDomicilio(@PathVariable Long id, @RequestBody Domicilio domicilio){
        Domicilio domicilioEncontrado = domicilioService.findById(id);
        if (domicilioEncontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                domicilioEncontrado.setDomicilio(domicilio.getDomicilio());
                domicilioEncontrado.setLocalidad(domicilio.getLocalidad());
                domicilioEncontrado.setPais(domicilio.getPais());
                domicilioEncontrado.setPostal(domicilio.getPostal());
                domicilioEncontrado.setProvincia(domicilio.getProvincia());
                return new ResponseEntity<>(domicilioService.save(domicilioEncontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Domicilio> findById (@PathVariable Long id){
        Domicilio domicilioEncontrado = domicilioService.findById(id);
        if (domicilioEncontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(domicilioEncontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        domicilioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
