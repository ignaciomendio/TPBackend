
package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellido;
    private String titulo; 
    private String mail;
    private String telefono;
    private String domicilio;
    private String pais;
    private String sobre_mi;
    private String image_perfil;
    
}
