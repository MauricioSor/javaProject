package com.v1.consultorio.services;

import com.v1.consultorio.DAO.DiagnosticosDAO;
import com.v1.consultorio.models.Diagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoService {
    private final DiagnosticosDAO diagnosticosDAO;
    @Autowired
    public DiagnosticoService(DiagnosticosDAO diagnosticosDAO) {this.diagnosticosDAO = diagnosticosDAO;}

    public List<Diagnostico> getDiagnostico(int idHistoriaClinica){return diagnosticosDAO.getDiagnostico(idHistoriaClinica);}



}
