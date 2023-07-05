package com.bufete.bufete.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bufete.bufete.entity.Caso;
import com.bufete.bufete.entity.Proceso;

public interface ProcesoRepository extends JpaRepository<Proceso, Long> {
    List<Proceso> findByCasoIn(List<Caso> casos);
}