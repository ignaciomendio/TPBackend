/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Domicilio;
import tp.tpintegrador.repository.DomicilioRepository;

/**
 *
 * @author imendiol
 */
@Service
public class DomicilioServiceImpl implements DomicilioService{
    
    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public Domicilio save(Domicilio domicilio) {
         return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio findById(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Domicilio> findAll() {
        return domicilioRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        domicilioRepository.deleteById(id);
    }
    
}
