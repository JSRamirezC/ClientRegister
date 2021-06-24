package com.colfondos.pruebatecnicacol.services;

import com.colfondos.pruebatecnicacol.dtos.Parameter;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;

import java.util.List;

public interface ParameterSrv  {

    public List<Parameter> ListadoParam() throws CustomApplicationException;

}
