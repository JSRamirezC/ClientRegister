package com.colfondos.pruebatecnicacol.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnValorDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String cdato = "";

	public UnValorDto() {
		super();
	}

	public UnValorDto(String cdato) {
		super();
		this.cdato = cdato;
	}

	/**
	 * @return the cdato
	 */
	@JsonProperty("mensaje")
	public String getCdato() {
		return cdato;
	}

	/**
	 * @param cdato
	 *            the cdato to set
	 */
	public void setCdato(String cdato) {
		this.cdato = cdato;
	}

}
