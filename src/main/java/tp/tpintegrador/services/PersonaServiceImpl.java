/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Persona;
import tp.tpintegrador.repository.PersonaRepository;

/**
 *
 * @author imendiol
 */
@Service
public class PersonaServiceImpl implements PersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona save(Persona persona) {
       return personaRepository.save(persona);
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
    
}
