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
import tp.tpintegrador.models.Proyecto;
import tp.tpintegrador.services.ProyectoService;


/**
 *
 * @author imendiol
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    
    @Autowired 
    private ProyectoService proyectoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Proyecto>> listarProyectos(){
        return new ResponseEntity<>(proyectoService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Proyecto> agregarProyecto(@RequestBody Proyecto proyecto){
        return new ResponseEntity<>(proyectoService.save(proyecto), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        Proyecto Encontrado = proyectoService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                Encontrado.setDescripcion(proyecto.getDescripcion());
                Encontrado.setNombre(proyecto.getNombre());
                Encontrado.setProjectLink(proyecto.getProjectLink());
                return new ResponseEntity<>(proyectoService.save(Encontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Proyecto> findById (@PathVariable Long id){
        Proyecto Encontrado = proyectoService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(Encontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        proyectoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
