package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.MedicamentoGenerico;
import com.sw24.clinicaapp.repository.MedicamentoGenericoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMedicamentoGenericoRepository extends JpaRepository<MedicamentoGenerico, Integer>, MedicamentoGenericoRepository {
}
