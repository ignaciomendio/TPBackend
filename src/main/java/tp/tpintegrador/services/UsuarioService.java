/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.services;

import tp.tpintegrador.models.Usuario;

/**
 *
 * @author imendiol
 */
public interface UsuarioService {
    
    public Usuario findById (Long id);
    public Usuario findByUserName (String userName);
    public Usuario save (Usuario usuario);
    
    
}
