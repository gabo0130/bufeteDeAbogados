package com.bufete.bufete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bufete.bufete.entity.Caso;
import com.bufete.bufete.repository.CasoRepository;

import java.util.List;

@Service
public class CasoService {

    @Autowired
    private CasoRepository casoRepository;

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
}
