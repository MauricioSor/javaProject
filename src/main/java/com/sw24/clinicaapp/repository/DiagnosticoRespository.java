package com.sw24.clinicaapp.repository;

import com.sw24.clinicaapp.entity.Diagnostico;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoRespository {
    Diagnostico save(Diagnostico diagnostico);
    Optional<Diagnostico> findById(Integer id);
    void deleteById(Integer id);
    List<Diagnostico> findAll();
}