package mx.edu.utez.Recupera.model.usuario;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {
    private Integer id;

    private String usuario;

    private String contrasenia;

    private Boolean estado;
}
