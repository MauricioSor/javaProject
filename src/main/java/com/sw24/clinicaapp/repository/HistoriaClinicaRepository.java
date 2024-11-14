package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.HistoriaClinica;

import java.util.List;
import java.util.Optional;

public interface HistoriaClinicaRepository {
    HistoriaClinica save(HistoriaClinica historiaClinica);
    Optional<HistoriaClinica> findById(Integer id);
    Optional<HistoriaClinica> findByPacienteDni(String dni);
    List<HistoriaClinica> findAll();
    void deleteById(Integer id);
}
