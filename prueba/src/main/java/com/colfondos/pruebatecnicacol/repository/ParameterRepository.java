package com.colfondos.pruebatecnicacol.repository;


import com.colfondos.pruebatecnicacol.dtos.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParameterRepository extends JpaRepository<Parameter,String> {

    Optional<Parameter> findById(String id);

}
