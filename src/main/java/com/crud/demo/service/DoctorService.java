package com.crud.demo.service;

import com.crud.demo.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> listar();

    DoctorDto obtenerDoctorPorId(Long id);

    DoctorDto guardarDoctor(DoctorDto request);

    void eliminarDoctor(Long id);

}
