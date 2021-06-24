package com.colfondos.pruebatecnicacol.services.implement;

import com.colfondos.pruebatecnicacol.dtos.Audit;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.repository.AuditRepository;
import com.colfondos.pruebatecnicacol.repository.ClientRepository;
import com.colfondos.pruebatecnicacol.services.AuditSrv;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditSrvImpl implements AuditSrv {

    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void guardarAudit(Audit audit) throws CustomApplicationException {
        try {


            auditRepository.save(audit);
        } catch (Exception e) {
            throw new CustomApplicationException("Ha fallado la consulta de parametros");
        }
    }

}
