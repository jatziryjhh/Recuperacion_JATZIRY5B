package mx.edu.utez.Recupera.controller.usuario;

import lombok.AllArgsConstructor;
import mx.edu.utez.Recupera.model.usuario.UsuarioBean;
import mx.edu.utez.Recupera.model.usuario.UsuarioDto;
import mx.edu.utez.Recupera.service.usuario.IUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final IUsuario usuarioService;

    @PostMapping("/")
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto) {
        String contrasenia = generarContrasenia();
        UsuarioBean usuario = usuarioService.save(usuarioDto);
        usuario.setContrasenia(contrasenia);
        return UsuarioDto.builder()
                .id(usuario.getId())
                .usuario(usuario.getUsuario())
                .contrasenia(usuario.getContrasenia())
                .estado(usuario.getEstado())
                .build();
    }



    @PutMapping("/")
    public UsuarioDto update(UsuarioDto usuarioDto){
        UsuarioBean usuario=usuarioService.save(usuarioDto);
        return UsuarioDto.builder()
                .id(usuario.getId())
                .usuario(usuario.getUsuario())
                .contrasenia(usuario.getContrasenia())
                .estado(usuario.getEstado())
                .build();
    }

    @GetMapping("/")
    public List<UsuarioBean> getUsuario(){
        return usuarioService.findAll();
    }
    @GetMapping("/{id}")
    public UsuarioBean showById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        UsuarioBean usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }

    private String generarContrasenia() {
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String especiales = "!@#$%^&*()_-+=<>?";

        String caracteres = minusculas + mayusculas + numeros + especiales;
        int longitud = 8;

        StringBuilder contrasenia = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            contrasenia.append(caracteres.charAt(index));
        }

        return contrasenia.toString();
    }
}