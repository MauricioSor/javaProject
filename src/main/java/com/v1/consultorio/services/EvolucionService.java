package com.v1.consultorio.services;

import com.v1.consultorio.DAO.EvolucionDAO;
import com.v1.consultorio.models.Evolucion;
import com.v1.consultorio.models.PedidoLaboratorio;
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
    public String create_evolucion(Evolucion evolucion,int idDiagnostico){return evolucionDAO.createEvolucion(evolucion,idDiagnostico);}
    public String createPedido(PedidoLaboratorio pedidoLaboratorio,int idEvolucion){return evolucionDAO.createPedidoLaboratorio(pedidoLaboratorio,idEvolucion);}
}
