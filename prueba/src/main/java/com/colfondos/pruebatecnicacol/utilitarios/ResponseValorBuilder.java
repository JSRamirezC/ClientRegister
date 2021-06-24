package com.colfondos.pruebatecnicacol.utilitarios;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.colfondos.pruebatecnicacol.dtos.EmptyJsonResponse;
import com.colfondos.pruebatecnicacol.dtos.reponse.ResponseGenericoDto;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.exception.CustomSecurityException;

    public class ResponseValorBuilder<T extends Object> {

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaPositiva(T responseValor) {
            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>((new ResponseGenericoDto<T>()).responseConsultar2Dto(responseValor),
                    HttpStatus.OK);

        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaPositiva(T responseValor, String mess) {
            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
                    (new ResponseGenericoDto<T>()).responseConsultar2Dto(responseValor,mess), HttpStatus.OK);

        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaControlada(String mensaje) {


            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
                    (new ResponseGenericoDto<T>()).responseConsultar2Dto(new EmptyJsonResponse(), mensaje), HttpStatus.PARTIAL_CONTENT);


        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaControlada(CustomApplicationException crtEX) {


            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
                    (new ResponseGenericoDto<T>()).responseConsultar2Dto(new EmptyJsonResponse(), crtEX.getMessage()), HttpStatus.PARTIAL_CONTENT);

        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaControlada(CustomSecurityException crtEX) {

            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>(
                    (new ResponseGenericoDto<T>()).responseConsultar2Dto(new EmptyJsonResponse(), crtEX.getMessage()), HttpStatus.FORBIDDEN);
        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaNoControlada(Exception crtEX) {
            String exception = null;
            if(Objects.nonNull(crtEX.getCause())) {
                exception = crtEX.getCause().toString();
            } else {
                exception = crtEX.getMessage();
            }
            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>((new ResponseGenericoDto<T>())
                    .responseConsultar2Dto(new EmptyJsonResponse(), crtEX.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> buildRespuestaNoControlada(String stackTrace) {

            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>((new ResponseGenericoDto<T>())
                    .responseConsultar2Dto(new EmptyJsonResponse(), stackTrace), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto> respuestaNoControlada(Exception e) {
            String exception = null;
            if(Objects.nonNull(e.getCause())) {
                exception = e.getCause().toString();
            } else {
                exception = e.getMessage();
            }

            return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultar2Dto>((new ResponseGenericoDto<T>())
                    .responseConsultar2Dto(new EmptyJsonResponse(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }



