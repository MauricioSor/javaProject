package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.repository.DiagnosticoRespository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDiagnisticoRepository extends JpaRepository<Diagnostico, Integer>, DiagnosticoRespository {
}
