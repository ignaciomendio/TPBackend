/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.ExperienciaLaboral;
import tp.tpintegrador.repository.ExperienciaLaboralRepository;

/**
 *
 * @author imendiol
 */
@Service
public class ExperienciaLaboralServiceImpl implements ExperienciaLaboralService {
    
    @Autowired
    private ExperienciaLaboralRepository experienciaRepository;

    @Override
    public ExperienciaLaboral save(ExperienciaLaboral experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @Override
    public ExperienciaLaboral findById(Long id) {
       return experienciaRepository.findById(id).orElse(null);
    }

    @Override
    public List<ExperienciaLaboral> findAll() {
        return experienciaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        experienciaRepository.deleteById(id);
    }
    
}
