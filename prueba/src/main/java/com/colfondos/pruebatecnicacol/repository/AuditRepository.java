package com.colfondos.pruebatecnicacol.repository;

import com.colfondos.pruebatecnicacol.dtos.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuditRepository extends JpaRepository<Audit,Integer> {

    Optional<Audit> findById(Integer id);

}