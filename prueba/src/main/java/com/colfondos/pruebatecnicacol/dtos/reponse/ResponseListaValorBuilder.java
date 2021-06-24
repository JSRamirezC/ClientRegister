package com.colfondos.pruebatecnicacol.dtos.reponse;

import java.util.ArrayList;
import java.util.List;

import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import com.colfondos.pruebatecnicacol.exception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class ResponseListaValorBuilder<T> {

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaPositiva(
			List<T> responseListaValor) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(responseListaValor), HttpStatus.OK);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaControlada(
			CustomApplicationException crtEX) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(new ArrayList<T>(), crtEX.getMessage()),
				HttpStatus.PARTIAL_CONTENT);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaNoControlada(Exception crtEX) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto> buildRespuestaNoControlada2(Exception crtEX)
			throws CustomRuntimeException {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseConsultarDto>(
				(new ResponseGenericoDto<T>()).responseConsultarDto(new ArrayList<T>(), crtEX.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}