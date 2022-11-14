package com.crud.demo.service.impl;

import com.crud.demo.dto.DoctorDto;
import com.crud.demo.entity.DoctorEntity;
import com.crud.demo.repository.DoctorRepository;
import com.crud.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DoctorDto> listar() {
    List<DoctorEntity> listaEntity = doctorRepository.findAll();

    List<DoctorDto> listaDto = new ArrayList<>();
        for (DoctorEntity doctorEntity: listaEntity) {
            DoctorDto doctorDto = new DoctorDto();
            doctorDto.setId(doctorEntity.getId());
            doctorDto.setNombres(doctorEntity.getNombres());
            doctorDto.setApellidos(doctorEntity.getApellidos());

            listaDto.add(doctorDto);
        }

        return listaDto;
    }

    @Override
    public DoctorDto obtenerDoctorPorId(Long id) {
        Optional<DoctorEntity> doctorEntity =doctorRepository.findById(id);
        DoctorDto doctorDTO = new DoctorDto();
        if(doctorEntity.isPresent()){
            doctorDTO.setId(doctorEntity.get().getId());
            doctorDTO.setNombres(doctorEntity.get().getNombres());
            doctorDTO.setApellidos(doctorEntity.get().getApellidos());
        }else {
            return new DoctorDto();
        }
        return doctorDTO;
    }

    @Override
    public DoctorDto guardarDoctor(DoctorDto request) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(request.getId());
        doctorEntity.setNombres(request.getNombres());
        doctorEntity.setApellidos(request.getApellidos());

        DoctorEntity doctorGuardado=doctorRepository.save(doctorEntity);
        /*Mostrar datos*/
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setNombres(doctorGuardado.getNombres());
        doctorDto.setApellidos(doctorGuardado.getApellidos());


        return doctorDto;
    }

    @Override
    public void eliminarDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
