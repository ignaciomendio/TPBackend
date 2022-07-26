/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.Persona;

/**
 *
 * @author imendiol
 */
public interface PersonaService {
    
    public Persona save(Persona domicilio);
    public Persona findById (Long id);
    public List<Persona> findAll ();
    public void delete (Long id);
    
}
