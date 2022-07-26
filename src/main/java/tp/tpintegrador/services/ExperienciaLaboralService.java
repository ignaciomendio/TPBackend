/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.ExperienciaLaboral;

/**
 *
 * @author imendiol
 */
public interface ExperienciaLaboralService {
    
    public ExperienciaLaboral save(ExperienciaLaboral experiencia);
    public ExperienciaLaboral findById (Long id);
    public List<ExperienciaLaboral> findAll ();
    public void delete (Long id);
    
}
