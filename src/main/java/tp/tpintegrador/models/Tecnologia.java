
package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="TECNOLOGIAS")
public class Tecnologia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tecnologia;
}
