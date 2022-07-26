/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.Tecnologia;

/**
 *
 * @author imendiol
 */
public interface TecnologiaService {
    
    public Tecnologia save(Tecnologia tecnologia);
    public Tecnologia findById (Long id);
    public List<Tecnologia> findAll ();
    public void delete (Long id);
    
}
