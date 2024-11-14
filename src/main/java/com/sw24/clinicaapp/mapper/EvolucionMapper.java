package com.sw24.clinicaapp.mapper;

import com.sw24.clinicaapp.dto.response.EvolucionResDTO;
import com.sw24.clinicaapp.entity.Evolucion;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EvolucionMapper {
    EvolucionMapper INSTANCE = Mappers.getMapper(EvolucionMapper.class);

    EvolucionResDTO toEvolucionResDTO(Evolucion evolucion);
}
