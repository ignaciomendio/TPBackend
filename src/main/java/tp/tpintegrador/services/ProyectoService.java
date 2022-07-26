/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.Proyecto;

/**
 *
 * @author imendiol
 */
public interface ProyectoService {
    
    public Proyecto save(Proyecto domicilio);
    public Proyecto findById (Long id);
    public List<Proyecto> findAll ();
    public void delete (Long id);
    
}
