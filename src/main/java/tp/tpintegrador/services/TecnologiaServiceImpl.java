/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Tecnologia;
import tp.tpintegrador.repository.TecnologiaRepository;

/**
 *
 * @author imendiol
 */
@Service
public class TecnologiaServiceImpl implements TecnologiaService{

    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    
    @Override
    public Tecnologia save(Tecnologia tecnologia) {
        return tecnologiaRepository.save(tecnologia);
    }

    @Override
    public Tecnologia findById(Long id) {
        return tecnologiaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tecnologia> findAll() {
        return tecnologiaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        tecnologiaRepository.deleteById(id);
    }
    
}
