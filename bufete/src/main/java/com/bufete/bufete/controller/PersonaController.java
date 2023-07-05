package com.bufete.bufete.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bufete.bufete.entity.Persona;
import com.bufete.bufete.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaService.obtenerTodasLasPersonas();
    }

    @GetMapping("/{id}")
    public Persona obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {
        Persona personaActualizada = personaService.actualizarPersona(id, persona);
        return ResponseEntity.ok(personaActualizada);
    }
    
}

