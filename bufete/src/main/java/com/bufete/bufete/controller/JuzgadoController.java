package com.bufete.bufete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bufete.bufete.entity.Juzgado;
import com.bufete.bufete.service.JuzgadoService;
@RestController
@RequestMapping("/juzgados")
public class JuzgadoController {

    @Autowired
    private JuzgadoService juzgadoService;

    @PostMapping
    public Juzgado guardarJuzgado(@RequestBody Juzgado juzgado) {
        return juzgadoService.guardarJuzgado(juzgado);
    }

    @GetMapping
    public List<Juzgado> obtenerTodosLosJuzgados() {
        return juzgadoService.obtenerTodosLosJuzgados();
    }

    @GetMapping("/{id}")
    public Juzgado obtenerJuzgadoPorId(@PathVariable Long id) {
        return juzgadoService.obtenerJuzgadoPorId(id);
    }

    @GetMapping("/buscar")
    public List<Juzgado> obtenerJuzgadosPorNombre(@RequestParam String nombre) {
        return juzgadoService.obtenerJuzgadosPorNombre(nombre);
    }

    @GetMapping("/ordenar")
    public List<Juzgado> obtenerJuzgadosOrdenadosPorNombre() {
        return juzgadoService.obtenerJuzgadosOrdenadosPorNombre();
    }

    @DeleteMapping("/{id}")
    public void eliminarJuzgado(@PathVariable Long id) {
        juzgadoService.eliminarJuzgado(id);
    }
}