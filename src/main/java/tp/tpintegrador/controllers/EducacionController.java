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
import tp.tpintegrador.models.Educacion;
import tp.tpintegrador.services.EducationService;

/**
 *
 * @author imendiol
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/educacion")
public class EducacionController {
    
    @Autowired 
    private EducationService educacionService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Educacion>> listarEducacion(){
        return new ResponseEntity<>(educacionService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
        return new ResponseEntity<>(educacionService.save(educacion), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Educacion> actualizarEducacion(@PathVariable Long id, @RequestBody Educacion educacion){
        Educacion Encontrado = educacionService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                Encontrado.setCarrera(educacion.getCarrera());
                Encontrado.setFin(educacion.getFin());
                Encontrado.setFinalizada(educacion.getFinalizada());
                Encontrado.setImagen(educacion.getImagen());
                Encontrado.setInicio(educacion.getInicio());
                Encontrado.setInstitucion(educacion.getInstitucion());
                Encontrado.setPuntaje(educacion.getPuntaje());
                Encontrado.setTitulo(educacion.getTitulo());
                return new ResponseEntity<>(educacionService.save(Encontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Educacion> findById (@PathVariable Long id){
        Educacion Encontrado = educacionService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(Encontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        educacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
