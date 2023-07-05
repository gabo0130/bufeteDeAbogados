package com.bufete.bufete.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bufete.bufete.entity.Proceso;

public interface ProcesoRepository extends JpaRepository<Proceso, Long> {
    @Query("SELECT p FROM Proceso p WHERE p.fechaVencimiento BETWEEN CURRENT_DATE AND :fechaLimite")
    List<Proceso> findProcesosProximosAVencerse(@Param("fechaLimite") LocalDate fechaLimite);
}