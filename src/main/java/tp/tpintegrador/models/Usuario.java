/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author imendiol
 */

@Getter @Setter
@Entity
@Table(name="USUARIOS")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    
    
}
