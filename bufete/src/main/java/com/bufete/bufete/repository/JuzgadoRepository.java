package com.bufete.bufete.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bufete.bufete.entity.Juzgado;

public interface JuzgadoRepository extends JpaRepository<Juzgado, Long> {
    List<Juzgado> findByNombreContainingIgnoreCase(String nombre);

    List<Juzgado> findAllByOrderByNombreAsc();
}
