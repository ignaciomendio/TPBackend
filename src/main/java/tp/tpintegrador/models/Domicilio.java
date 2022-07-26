
package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="DOMICILIO")
public class Domicilio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String pais;
    private String postal;
    
    
}
