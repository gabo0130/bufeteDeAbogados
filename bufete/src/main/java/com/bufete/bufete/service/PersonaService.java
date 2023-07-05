package com.bufete.bufete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}

