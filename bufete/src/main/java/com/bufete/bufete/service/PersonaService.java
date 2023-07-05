package com.bufete.bufete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.bufete.bufete.entity.Persona;
import com.bufete.bufete.repository.PersonaRepository;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow();
    }

    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona persona){
        Persona personaActualizada = personaRepository.findById(id)
                .map(personaEncontrada -> {
                    personaEncontrada.setNombre(persona.getNombre());
                    personaEncontrada.setDireccion(persona.getDireccion());
                    personaEncontrada.setTelefono(persona.getTelefono());
                    return personaRepository.save(personaEncontrada);
                })
                .orElseThrow();
        return personaActualizada;
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}

