package com.colfondos.pruebatecnicacol.services.implement;

import com.colfondos.pruebatecnicacol.dtos.Parameter;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.repository.ParameterRepository;
import com.colfondos.pruebatecnicacol.services.ParameterSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterSrvImpl implements ParameterSrv {

    @Autowired
    private ParameterRepository parameterRepository;


    @Override
    public List<Parameter> ListadoParam() throws CustomApplicationException {
        try{
            return parameterRepository.findAll();
        } catch (Exception e) {
            throw new CustomApplicationException("Ha fallado la consulta de parametros");
        }
    }
}
