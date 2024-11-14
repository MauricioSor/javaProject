package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Paciente;
import com.sw24.clinicaapp.repository.PacienteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPacienteRepository extends JpaRepository<Paciente, String>, PacienteRepository {
    Paciente findByDni(String dni);
}
