package com.crud.demo.repository;

import com.crud.demo.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository <DoctorEntity, Long> {

}
