package com.sw24.clinicaapp.repository.jpa;

import com.sw24.clinicaapp.entity.PedidoLaboratorio;
import com.sw24.clinicaapp.repository.PedidoLaboratorioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPedidoLaboratorioRepository extends JpaRepository<PedidoLaboratorio, Integer>, PedidoLaboratorioRepository {
}
