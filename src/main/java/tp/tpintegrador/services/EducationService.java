/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.Educacion;

/**
 *
 * @author imendiol
 */
public interface EducationService {
    
    public Educacion save(Educacion educacion);
    public Educacion findById (Long id);
    public List<Educacion> findAll ();
    public void delete (Long id);
}
