package com.bufete.bufete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bufete.bufete.entity.Caso;
import com.bufete.bufete.entity.Persona;
import com.bufete.bufete.entity.Proceso;
import com.bufete.bufete.repository.CasoRepository;
import com.bufete.bufete.repository.PersonaRepository;

import java.util.List;

@Service
public class CasoService {

    @Autowired
    private CasoRepository casoRepository;
    
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private ProcesoService procesoService;
    
    public Caso guardarCaso(Caso caso) {
        return casoRepository.save(caso);
    }

    public List<Caso> obtenerTodosLosCasos() {
        return casoRepository.findAll();
    }

    public Caso obtenerCasoPorId(Long id) {
        return casoRepository.findById(id)
                .orElseThrow();
    }

    public void eliminarCaso(Long id) {
        casoRepository.deleteById(id);
    }

    public void agregarTestigoACaso(Long casoId, Long testigoId) {
        Caso caso = casoRepository.findById(casoId).orElseThrow();
        Persona testigo = personaRepository.findById(testigoId).orElseThrow();
        caso.agregarTestigo(testigo);
        casoRepository.save(caso);
    }

    public void eliminarTestigoDeCaso(Long casoId, Long testigoId) {
        Caso caso = casoRepository.findById(casoId).orElseThrow();
        Persona testigo = personaRepository.findById(testigoId).orElseThrow();
        caso.eliminarTestigo(testigo);
        casoRepository.save(caso);
    }

    public Caso asignarProcesoACaso(Long casoId, Long procesoId) {
    Caso caso = obtenerCasoPorId(casoId);
    Proceso proceso = procesoService.obtenerProcesoPorId(procesoId);
    caso.setProceso(proceso);
    return guardarCaso(caso);
    }

}
