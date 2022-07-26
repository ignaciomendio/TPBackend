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
import tp.tpintegrador.models.ExperienciaLaboral;
import tp.tpintegrador.services.ExperienciaLaboralService;

/**
 *
 * @author imendiol
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaLaboralController {
    
    @Autowired 
    private ExperienciaLaboralService experienciaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<ExperienciaLaboral>> listarExperiencia(){
        return new ResponseEntity<>(experienciaService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<ExperienciaLaboral> agregarExperiencia(@RequestBody ExperienciaLaboral experiencia){
        return new ResponseEntity<>(experienciaService.save(experiencia), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<ExperienciaLaboral> actualizarExperiencia(@PathVariable Long id, @RequestBody ExperienciaLaboral experiencia){
        ExperienciaLaboral Encontrado = experienciaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                Encontrado.setActual(experiencia.getActual());
                Encontrado.setDescrpcion(experiencia.getDescrpcion());
                Encontrado.setEmpleador(experiencia.getEmpleador());
                Encontrado.setFin(experiencia.getFin());
                Encontrado.setFuncion(experiencia.getFuncion());
                Encontrado.setInicio(experiencia.getInicio());

                return new ResponseEntity<>(experienciaService.save(Encontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<ExperienciaLaboral> findById (@PathVariable Long id){
        ExperienciaLaboral Encontrado = experienciaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(Encontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        experienciaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
