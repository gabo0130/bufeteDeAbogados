package com.bufete.bufete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bufete.bufete.entity.Caso;


public interface CasoRepository extends JpaRepository<Caso, Long> {
}