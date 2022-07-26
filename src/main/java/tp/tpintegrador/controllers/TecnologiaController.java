/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.tpintegrador.models.Tecnologia;
import tp.tpintegrador.services.TecnologiaService;


/**
 *
 * @author imendiol
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/tecnologia")
public class TecnologiaController {
    
    @Autowired 
    private TecnologiaService tecnologiaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Tecnologia>> listarTecnologia(){
        return new ResponseEntity<>(tecnologiaService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Tecnologia> agregarTecnologia(@RequestBody Tecnologia tecnologia){
        return new ResponseEntity<>(tecnologiaService.save(tecnologia), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Tecnologia> actualizarTecnologia(@PathVariable Long id, @RequestBody Tecnologia tecnologia){
        Tecnologia Encontrado = tecnologiaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                Encontrado.setTecnologia(tecnologia.getTecnologia());
                return new ResponseEntity<>(tecnologiaService.save(Encontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Tecnologia> findById (@PathVariable Long id){
        Tecnologia Encontrado = tecnologiaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(Encontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        tecnologiaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
