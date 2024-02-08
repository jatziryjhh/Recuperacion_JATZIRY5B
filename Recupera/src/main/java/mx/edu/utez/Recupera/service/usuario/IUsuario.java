package mx.edu.utez.Recupera.service.usuario;

import mx.edu.utez.Recupera.model.usuario.UsuarioBean;
import mx.edu.utez.Recupera.model.usuario.UsuarioDto;

import java.util.List;

public interface IUsuario {
    void delete(UsuarioBean usuario);

    UsuarioBean findById(Integer id);

    List<UsuarioBean> findAll();

    UsuarioBean save(UsuarioDto usuarioDto);
}
