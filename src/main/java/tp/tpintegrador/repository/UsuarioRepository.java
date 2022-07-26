/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.tpintegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.tpintegrador.models.Usuario;

/**
 *
 * @author imendiol
 */
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
}
