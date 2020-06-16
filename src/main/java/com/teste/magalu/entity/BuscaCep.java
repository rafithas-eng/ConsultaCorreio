package com.teste.magalu.entity;

import org.springframework.lang.NonNull;


public class BuscaCep {
	
	@NonNull
	private String cep;

	public BuscaCep(String cep) {
		this.cep = cep;
	}
	
	public BuscaCep() {
		
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
