package com.colfondos.pruebatecnicacol.controller;

import com.colfondos.pruebatecnicacol.dtos.Client;
import com.colfondos.pruebatecnicacol.dtos.Parameter;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.services.ClientSrv;
import com.colfondos.pruebatecnicacol.utilitarios.ResponseValorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/colfondos/clients")
public class ClientController {

    @Autowired
    private ClientSrv clientSrv;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/guardar")
    public ResponseEntity<?>  guardarClient(@RequestBody Client client) throws CustomApplicationException {

        try {
            clientSrv.guardarCliente(client);
            return new ResponseValorBuilder<Client>().buildRespuestaPositiva(client);
        } catch (NullPointerException e) {
            return new ResponseValorBuilder<Client>().respuestaNoControlada(e);
        } catch (CustomApplicationException e) {
            return new ResponseValorBuilder<Client>().respuestaNoControlada(e);
        }
    }
}
