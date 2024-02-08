package mx.edu.utez.Recupera.service.persona;

import jakarta.persistence.*;
import lombok.*;
import mx.edu.utez.Recupera.model.persona.PersonaBean;
import mx.edu.utez.Recupera.model.persona.PersonaDao;
import mx.edu.utez.Recupera.model.persona.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaImpl implements IPersona{
    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>)personaDao.findAll();
    }

    @Override
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona=PersonaBean.builder()
                .id(personaDto.getId())
                .nombre(personaDto.getNombre())
                .apellidoP(personaDto.getApellidoP())
                .apellidoM(personaDto.getApellidoM())
                .direccion(personaDto.getDireccion())
                .telefono(personaDto.getTelefono())
                .build();
        return personaDao.save(persona);
    }

    @Override
    public void delete(PersonaBean persona) {
        personaDao.delete(persona);
    }
}
