/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Proyecto;
import tp.tpintegrador.repository.ProyectoRepository;

/**
 *
 * @author imendiol
 */
@Service
public class ProyectoServiceImpl implements ProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto findById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
    
}
