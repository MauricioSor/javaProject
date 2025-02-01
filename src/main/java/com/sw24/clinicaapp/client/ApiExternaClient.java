package com.sw24.clinicaapp.client;

import com.sw24.clinicaapp.dto.ObraSocialResDTO;
import com.sw24.clinicaapp.entity.Medicamento;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// Archivo: ApiExternaClient.java
@Component
public class ApiExternaClient {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ApiExternaClient(
            RestTemplate restTemplate,
            @Value("${api.externa.url}") String baseUrl
    ) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public ObraSocialResDTO obtenerObraSocial(String codigo) {
        String url = String.format("%s/obras-sociales/%s", baseUrl, codigo);
        return restTemplate.getForObject(url, ObraSocialResDTO.class);
    }

    public Medicamento obtenerMedicamento(Integer codigo) {
        String url = String.format("%s/medicamentos/%d", baseUrl, codigo);
        return restTemplate.getForObject(url, Medicamento.class);
    }
}