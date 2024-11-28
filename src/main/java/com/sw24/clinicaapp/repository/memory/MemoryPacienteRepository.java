package com.sw24.clinicaapp.repository.memory;

import com.sw24.clinicaapp.entity.Paciente;
import com.sw24.clinicaapp.repository.PacienteRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("memory")
public class MemoryPacienteRepository implements PacienteRepository {
    private final ConcurrentHashMap<String, Paciente> storage = new ConcurrentHashMap<>();

    @Override
    public Paciente save(Paciente paciente) {
        storage.putIfAbsent(paciente.getDni(), paciente);
        return paciente;
    }

    @Override
    public Optional<Paciente> findByDni(String dni) {
        return Optional.ofNullable(storage.get(dni));
    }

    @Override
    public List<Paciente> findAll() {
        return new ArrayList<>(storage.values());
    }
}