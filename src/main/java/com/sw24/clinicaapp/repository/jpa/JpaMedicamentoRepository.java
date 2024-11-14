package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Medicamento;
import com.sw24.clinicaapp.repository.MedicamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMedicamentoRepository extends JpaRepository<Medicamento, Integer>, MedicamentoRepository {
}
