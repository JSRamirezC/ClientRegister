package com.alianza.ofv.core.utilitarios;

import java.util.Arrays;
import java.util.Objects;

import com.colfondos.pruebatecnicacol.dtos.reponse.ResponseGenericoDto;
import com.colfondos.pruebatecnicacol.exception.CustomApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseNoValorBuilder<T> {

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaPositiva(String mensaje) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(mensaje), HttpStatus.OK);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaControlada(
			CustomApplicationException crtEX) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(crtEX.getMessage()), HttpStatus.PARTIAL_CONTENT);
	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaNoControlada(
			Exception crtEX) {
		String exception = null;
		if(Objects.nonNull(crtEX.getCause())) {
			exception = crtEX.getCause().toString();
		} else {
			exception = crtEX.getMessage();
		}
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>(
				(new ResponseGenericoDto<T>()).responseGuardarDto(crtEX.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaControlada(String mensaje) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>((new ResponseGenericoDto<T>()).responseGuardarDto(mensaje),
				HttpStatus.PARTIAL_CONTENT);
	}
	
	public ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto> buildRespuestaControladaForbidden(String mensaje) {
		return new ResponseEntity<ResponseGenericoDto<T>.ResponseGuardarDto>((new ResponseGenericoDto<T>()).responseGuardarDto(mensaje),
				HttpStatus.FORBIDDEN);
	}

}