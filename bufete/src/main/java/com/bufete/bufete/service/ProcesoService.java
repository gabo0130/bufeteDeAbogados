package com.bufete.bufete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bufete.bufete.entity.Proceso;
import com.bufete.bufete.repository.ProcesoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProcesoService {

    @Autowired
    private ProcesoRepository procesoRepository;


    public Proceso guardarProceso(Proceso proceso) {
        return procesoRepository.save(proceso);
    }

    public List<Proceso> obtenerTodosLosProcesos() {
        return procesoRepository.findAll();
    }

    public Proceso obtenerProcesoPorId(Long id) {
        return procesoRepository.findById(id)
                .orElseThrow();
    }

    public void eliminarProceso(Long id) {
        procesoRepository.deleteById(id);
    }

    public Proceso editarProceso(Proceso proceso) {
        Proceso procesoExistente = obtenerProcesoPorId(proceso.getId());
        procesoExistente.setFechaVencimiento(proceso.getFechaVencimiento());
        procesoExistente.setDescripcion(proceso.getDescripcion());
        return procesoRepository.save(procesoExistente);
    }
    
    public List<Proceso> obtenerProcesosProximosAVencerse() {
        LocalDate fechaLimite = LocalDate.now().plusDays(3);
        return procesoRepository.findProcesosProximosAVencerse(fechaLimite);
    }

}
