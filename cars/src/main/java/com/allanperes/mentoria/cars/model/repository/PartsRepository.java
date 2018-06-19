package com.allanperes.mentoria.cars.model.repository;

import com.allanperes.mentoria.cars.model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long> {
}
