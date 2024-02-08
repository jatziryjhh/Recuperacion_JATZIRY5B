package mx.edu.utez.Recupera.service.usuario;

import mx.edu.utez.Recupera.model.usuario.UsuarioBean;
import mx.edu.utez.Recupera.model.usuario.UsuarioDao;
import mx.edu.utez.Recupera.model.usuario.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements IUsuario {
    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public void delete(UsuarioBean usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public UsuarioBean findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public List<UsuarioBean> findAll() {
        return (List<UsuarioBean>) usuarioDao.findAll();
    }

    @Override
    public UsuarioBean save(UsuarioDto usuarioDto) {
        UsuarioBean usuario = UsuarioBean.builder()
                .id(usuarioDto.getId())
                .usuario(usuarioDto.getUsuario())
                .contrasenia(usuarioDto.getContrasenia())
                .estado(usuarioDto.getEstado())
                .build();
        return usuarioDao.save(usuario);
    }
}
