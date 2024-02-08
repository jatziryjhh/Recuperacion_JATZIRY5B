package mx.edu.utez.Recupera.controller.persona;

import lombok.AllArgsConstructor;
import mx.edu.utez.Recupera.model.persona.PersonaBean;
import mx.edu.utez.Recupera.model.persona.PersonaDto;
import mx.edu.utez.Recupera.service.persona.IPersona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {

    private final IPersona personaService;

    @GetMapping("/")
    public List<PersonaBean> getPersona(){return personaService.findAll();}

    @GetMapping("/{id}")
    public PersonaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public PersonaDto create(@RequestBody PersonaDto personaDto){
        PersonaBean personaCreate =personaService.save(personaDto) ;
        return personaDto.builder()
                .id(personaCreate.getId())
                .nombre(personaCreate.getNombre())
                .apellidoP(personaCreate.getApellidoP())
                .apellidoM(personaCreate.getApellidoM())
                .direccion(personaCreate.getDireccion())
                .telefono(personaCreate.getTelefono())
                .build();
    }

    @PutMapping("/")
    public PersonaDto update(@RequestBody PersonaDto personaDto){
        PersonaBean personaCreate =personaService.save(personaDto) ;
        return personaDto.builder()
                .id(personaCreate.getId())
                .nombre(personaCreate.getNombre())
                .apellidoP(personaCreate.getApellidoP())
                .apellidoM(personaCreate.getApellidoM())
                .direccion(personaCreate.getDireccion())
                .telefono(personaCreate.getTelefono())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        PersonaBean persona=personaService.findById(id);
        personaService.delete(persona);
    }
}
