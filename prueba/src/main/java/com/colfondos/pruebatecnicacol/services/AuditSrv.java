package com.colfondos.pruebatecnicacol.services;

import com.colfondos.pruebatecnicacol.dtos.Audit;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;

public interface AuditSrv {

    public void guardarAudit(Audit audit) throws CustomApplicationException;

}
