package com.sw24.clinicaapp.mapper;

import com.sw24.clinicaapp.dto.response.HistoriaClinicaResDTO;
import com.sw24.clinicaapp.entity.Diagnostico;
import com.sw24.clinicaapp.entity.HistoriaClinica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoriaClinicaMapper {
    HistoriaClinicaMapper INSTANCE = Mappers.getMapper(HistoriaClinicaMapper.class);

    HistoriaClinicaResDTO toHistoriaClinicaDTO(HistoriaClinica historiaClinica);
}
