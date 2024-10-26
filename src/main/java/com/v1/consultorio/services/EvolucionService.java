package com.v1.consultorio.services;

import com.v1.consultorio.DAO.EvolucionDAO;
import com.v1.consultorio.models.Evolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvolucionService {

    private final EvolucionDAO evolucionDAO;
    @Autowired
    public EvolucionService(EvolucionDAO evolucionDAO){this.evolucionDAO=evolucionDAO;}

    public List<Evolucion> getEvoluciones(int idDiagnostico){
        return evolucionDAO.getEvoluciones(idDiagnostico);
    }
}
