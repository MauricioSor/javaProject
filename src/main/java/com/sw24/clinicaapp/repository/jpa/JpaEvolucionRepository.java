package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Evolucion;
import com.sw24.clinicaapp.repository.EvolucionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEvolucionRepository extends JpaRepository<Evolucion, Integer>, EvolucionRepository {
}
