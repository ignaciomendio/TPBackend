/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import tp.tpintegrador.models.Domicilio;

/**
 *
 * @author imendiol
 */
public interface DomicilioService {
    
    public Domicilio save(Domicilio domicilio);
    public Domicilio findById (Long id);
    public List<Domicilio> findAll ();
    public void delete (Long id);
    
}
