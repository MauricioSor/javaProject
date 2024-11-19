package com.sw24.clinicaapp.repository.memory;

import com.sw24.clinicaapp.entity.Evolucion;
import com.sw24.clinicaapp.repository.EvolucionRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
@Profile("memory")
public class MemoryEvolucionRepository implements EvolucionRepository {
    private final ConcurrentHashMap<Integer, Evolucion> storage = new ConcurrentHashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public Evolucion save(Evolucion evolucion) {
        if (evolucion.getId() == null) {
            int id = idGenerator.incrementAndGet();
            evolucion.setId(id);
        }
        storage.put(evolucion.getId(), evolucion);
        return evolucion;
    }

    @Override
    public Optional<Evolucion> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Evolucion> findAll() {
        return storage.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        storage.remove(id);
    }
}