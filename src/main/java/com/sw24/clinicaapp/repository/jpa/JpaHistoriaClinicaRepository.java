package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.HistoriaClinica;
import com.sw24.clinicaapp.repository.HistoriaClinicaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaHistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer>, HistoriaClinicaRepository {
    //Optional<HistoriaClinica> findByPacienteDni(String dni);
}
