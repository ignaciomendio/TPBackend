
package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="EXPERIENCIA_LABORAL")
public class ExperienciaLaboral {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empleador;
    private String funcion;
    private String descrpcion;
    private String inicio;
    private String fin;
    private Boolean actual;
    private String imagen;
    
}
