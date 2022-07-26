package tp.tpintegrador.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="EDUCACION")
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institucion;
    private String titulo;
    private String imagen;
    private String carrera;
    private Float puntaje;
    private String inicio;
    private String fin;
    private Boolean finalizada;
    
    
}
