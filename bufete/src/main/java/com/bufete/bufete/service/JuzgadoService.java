package com.bufete.bufete.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bufete.bufete.entity.Juzgado;
import com.bufete.bufete.repository.JuzgadoRepository;

import java.util.List;

@Service
public class JuzgadoService {

    @Autowired
    private JuzgadoRepository juzgadoRepository;

    public Juzgado guardarJuzgado(Juzgado juzgado) {
        return juzgadoRepository.save(juzgado);
    }

    public List<Juzgado> obtenerTodosLosJuzgados() {
        return juzgadoRepository.findAll();
    }
    public List<Juzgado> obtenerJuzgadosPorNombre(String nombre) {
        return juzgadoRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Juzgado> obtenerJuzgadosOrdenadosPorNombre() {
        return juzgadoRepository.findAllByOrderByNombreAsc();
    }

    public Juzgado obtenerJuzgadoPorId(Long id) {
        return juzgadoRepository.findById(id)
                .orElseThrow();
    }

    public void eliminarJuzgado(Long id) {
        juzgadoRepository.deleteById(id);
    }
}
