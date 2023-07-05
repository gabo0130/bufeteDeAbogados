package com.bufete.bufete.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bufete.bufete.entity.Caso;


public interface CasoRepository extends JpaRepository<Caso, Long> {
    List<Caso> findByFechaVencimientoLessThanEqual(LocalDate fecha);
}