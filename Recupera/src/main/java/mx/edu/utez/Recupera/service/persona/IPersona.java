package mx.edu.utez.Recupera.service.persona;

import mx.edu.utez.Recupera.model.persona.PersonaBean;
import mx.edu.utez.Recupera.model.persona.PersonaDto;

import java.util.List;

public interface IPersona {

    List<PersonaBean> findAll();

    PersonaBean findById(Integer id);

    PersonaBean save(PersonaDto personaDto);

    void delete(PersonaBean persona);
}
