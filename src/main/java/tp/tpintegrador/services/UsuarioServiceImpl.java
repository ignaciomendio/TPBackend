/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.tpintegrador.models.Usuario;
import tp.tpintegrador.repository.UsuarioRepository;

/**
 *
 * @author imendiol
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario findByUserName(String userName) {
        return null; //a desarrollar
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
    