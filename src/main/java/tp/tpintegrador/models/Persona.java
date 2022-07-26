
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
    private String fecha_nacimiento;
    private String nacionalidad;
    private String mail;
    private String sobre_mi;
    private String image_background_header;
    private String image_perfil;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_domicilio")
    private Domicilio domicilio;
    
}
