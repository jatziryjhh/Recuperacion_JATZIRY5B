package mx.edu.utez.Recupera.model.persona;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persona")
public class PersonaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

    @Column(name = "apellidoP",length = 50,nullable = false)
    private String apellidoP;

    @Column(name = "apellidoM",length = 50,nullable = false)
    private String apellidoM;

    @Column(name="direccion",length = 50,nullable = false)
    private String direccion;

    @Column(name = "telefono",length = 50,nullable = false)
    private String telefono;

}