package mx.edu.utez.Recupera.model.usuario;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class UsuarioBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario",length =50, nullable = false, unique = true)
    private String usuario;
    @Column(name = "contrasenia",length = 8)
    private String contrasenia;

    @Column(name="estado",nullable = false)
    private Boolean estado;
}
