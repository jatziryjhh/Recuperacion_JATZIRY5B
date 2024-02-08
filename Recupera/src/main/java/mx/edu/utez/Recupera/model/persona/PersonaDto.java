package mx.edu.utez.Recupera.model.persona;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonaDto {
    private Long id;

    private String nombre;

    private String apellidoP;

    private String apellidoM;

    private String direccion;

    private String telefono;
}
