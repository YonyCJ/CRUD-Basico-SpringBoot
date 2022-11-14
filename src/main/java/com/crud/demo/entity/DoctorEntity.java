package com.crud.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorId")
    private Long id;
    @Column(name = "nombres",length = 100)
    private String nombres;
    @Column(name = "apellidos",length = 200)
    private String apellidos;
}
