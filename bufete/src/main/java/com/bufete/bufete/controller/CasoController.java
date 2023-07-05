package com.bufete.bufete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bufete.bufete.entity.Caso;
import com.bufete.bufete.service.CasoService;

@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private CasoService casoService;

    @PostMapping
    public Caso guardarCaso(@RequestBody Caso caso) {
        return casoService.guardarCaso(caso);
    }

    @GetMapping
    public List<Caso> obtenerTodosLosCasos() {
        return casoService.obtenerTodosLosCasos();
    }

    @GetMapping("/{id}")
    public Caso obtenerCasoPorId(@PathVariable Long id) {
        return casoService.obtenerCasoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCaso(@PathVariable Long id) {
        casoService.eliminarCaso(id);
    }

    @PostMapping("/{casoId}/testigos/{testigoId}")
    public void agregarTestigoACaso(@PathVariable Long casoId, @PathVariable Long testigoId) {
        casoService.agregarTestigoACaso(casoId, testigoId);
    }

    @DeleteMapping("/{casoId}/testigos/{testigoId}")
    public void eliminarTestigoDeCaso(@PathVariable Long casoId, @PathVariable Long testigoId) {
        casoService.eliminarTestigoDeCaso(casoId, testigoId);
    }

    @PutMapping("/{id}/proceso/{procesoId}")
    public Caso asignarProcesoACaso(@PathVariable Long id, @PathVariable Long procesoId) {
        return casoService.asignarProcesoACaso(id, procesoId);
    }
}
