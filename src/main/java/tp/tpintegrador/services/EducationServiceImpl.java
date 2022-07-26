/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Educacion;
import tp.tpintegrador.repository.EducacionRepository;

/**
 *
 * @author imendiol
 */
@Service
public class EducationServiceImpl implements EducationService{
    
    @Autowired
    private EducacionRepository educacionRepository;


    @Override
    public Educacion save(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public Educacion findById(Long id) {
        return educacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Educacion> findAll() {
        return educacionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        educacionRepository.deleteById(id);
    }
    
}
