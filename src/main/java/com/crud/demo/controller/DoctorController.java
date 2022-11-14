package com.crud.demo.controller;

import com.crud.demo.dto.DoctorDto;
import com.crud.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService service;

    @GetMapping
    public List<DoctorDto> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public DoctorDto listarDoctorPorId(@PathVariable("id") Long id){

        return service.obtenerDoctorPorId(id);
    }

    @PostMapping
    public DoctorDto guardarDoctor(@RequestBody DoctorDto request){
        return service.guardarDoctor(request);
    }

    @PutMapping
    public DoctorDto actualizarDoctor(@RequestBody DoctorDto request){
        return service.guardarDoctor(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarDoctor(@PathVariable("id") Long id){
        service.eliminarDoctor(id);

    }


}
