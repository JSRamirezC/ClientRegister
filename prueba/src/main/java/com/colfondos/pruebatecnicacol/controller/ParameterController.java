package com.colfondos.pruebatecnicacol.controller;

import com.colfondos.pruebatecnicacol.dtos.Parameter;
import com.colfondos.pruebatecnicacol.dtos.reponse.ResponseGenericoDto;
import com.colfondos.pruebatecnicacol.dtos.reponse.ResponseListaValorBuilder;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.services.ParameterSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/colfondos/param")
public class ParameterController {

    @Autowired
    private ParameterSrv parameterSrv;

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/listadoParam")
    public ResponseEntity<ResponseGenericoDto<Parameter>.ResponseConsultarDto> listadoParam() {
        try {
            return new ResponseListaValorBuilder<Parameter>().buildRespuestaPositiva(parameterSrv.ListadoParam());
        }catch (CustomApplicationException gEX) {
            return new ResponseListaValorBuilder<Parameter>().buildRespuestaControlada(gEX);
        } catch (Exception ex) {
            return new ResponseListaValorBuilder<Parameter>().buildRespuestaNoControlada2(ex);
        }

    }

}
