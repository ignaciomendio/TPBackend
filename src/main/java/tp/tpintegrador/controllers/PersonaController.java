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
import tp.tpintegrador.models.Persona;
import tp.tpintegrador.services.PersonaService;


/**
 *
 * @author imendiol
 */
@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    @Autowired 
    private PersonaService personaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarPersona(){
        return new ResponseEntity<>(personaService.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/agregar")
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }
    
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona){
        Persona Encontrado = personaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            try{
                Encontrado.setApellido(persona.getApellido());
                Encontrado.setDomicilio(persona.getDomicilio());
                Encontrado.setFecha_nacimiento(persona.getFecha_nacimiento());
                Encontrado.setImage_background_header(persona.getImage_background_header());
                Encontrado.setImage_perfil(persona.getImage_perfil());
                Encontrado.setMail(persona.getMail());
                Encontrado.setNacionalidad(persona.getNacionalidad());
                Encontrado.setNombres(persona.getNombres());
                Encontrado.setSobre_mi(persona.getSobre_mi());
                return new ResponseEntity<>(personaService.save(Encontrado), HttpStatus.CREATED);
            }
            catch (DataAccessException e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> findById (@PathVariable Long id){
        Persona Encontrado = personaService.findById(id);
        if (Encontrado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(Encontrado, HttpStatus.OK);
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
