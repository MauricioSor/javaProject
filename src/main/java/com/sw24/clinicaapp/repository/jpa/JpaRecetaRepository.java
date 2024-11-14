package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Receta;
import com.sw24.clinicaapp.repository.RecetaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRecetaRepository extends JpaRepository<Receta, Integer>, RecetaRepository {
}
