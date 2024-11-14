package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Medico;
import com.sw24.clinicaapp.repository.MedicoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaMedicoRepository extends JpaRepository<Medico, Integer>, MedicoRepository {
    Optional<Medico> findByDni(String dni);
    Optional<Medico> findByMatricula(String matricula);
    void deleteByDni(String dni);
    void deleteByMatricula(String matricula);
}
