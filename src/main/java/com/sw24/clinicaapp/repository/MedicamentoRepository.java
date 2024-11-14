package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Medicamento;

import java.util.Optional;

public interface MedicamentoRepository {
    Medicamento save(Medicamento medicamento);
    Optional<Medicamento> findByCodigo(String codigo);
}
