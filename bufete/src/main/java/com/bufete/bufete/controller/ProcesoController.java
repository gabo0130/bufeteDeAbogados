package com.bufete.bufete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bufete.bufete.entity.Proceso;
import com.bufete.bufete.service.ProcesoService;

@RestController
@RequestMapping("/procesos")
public class ProcesoController {

    @Autowired
    private ProcesoService procesoService;

    @PostMapping
    public Proceso guardarProceso(@RequestBody Proceso proceso) {
        return procesoService.guardarProceso(proceso);
    }

    @GetMapping
    public List<Proceso> obtenerTodosLosProcesos() {
        return procesoService.obtenerTodosLosProcesos();
    }

    @GetMapping("/{id}")
    public Proceso obtenerProcesoPorId(@PathVariable Long id) {
        return procesoService.obtenerProcesoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarProceso(@PathVariable Long id) {
        procesoService.eliminarProceso(id);
    }

    @PutMapping
    public Proceso editarProceso(@RequestBody Proceso proceso) {
        return procesoService.editarProceso(proceso);
    }
    
    @GetMapping("/proximos-a-vencerse")
    public List<Proceso> obtenerProcesosProximosAVencerse() {
        return procesoService.obtenerProcesosProximosAVencerse();
    }
}
