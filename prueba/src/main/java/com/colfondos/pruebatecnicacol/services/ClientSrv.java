package com.colfondos.pruebatecnicacol.services;

import com.colfondos.pruebatecnicacol.dtos.Client;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;

public interface ClientSrv {

    public void guardarCliente(Client client) throws CustomApplicationException;
}
