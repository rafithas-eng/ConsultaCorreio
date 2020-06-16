package com.teste.magalu.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.teste.magalu.entity.BuscaCep;
import com.teste.magalu.entity.Correio;
import com.teste.magalu.entity.ResponseCorreio;


@RestController 
public class CorreioController {
	
	static final String  BUSCA_WS = "https://viacep.com.br/ws/";
	static final String  JSON = "/json/";
	public Correio correio;

	
	public CorreioController(){

	}
	
	@PostMapping("/correios")
	public ResponseCorreio getCorreio(@RequestBody(required = true) BuscaCep buscaCep){
		ResponseCorreio retorno = new ResponseCorreio(); 
		retorno.setMessage("CEP inválido");

		if (buscaCep != null) {
			verificaCep(buscaCep.getCep());
			if (correio != null) {
				if (correio.getLogradouro() != null){
					retorno.setMessage(correio.toString());
				}
				
			}
		}else {
			retorno.setMessage("Json não informado");
		}
		
		
		return retorno;
	}
	
	
	private Correio getCep(String cep) {
		Correio result = null;
		final String uri = new StringBuilder()
				.append(BUSCA_WS)
				.append(cep)
				.append(JSON)
				.toString();
		
	    RestTemplate restTemplate = new RestTemplate();
	    
	    try {
	    	result = restTemplate.getForObject(uri, Correio.class);
	    } catch (HttpClientErrorException  ex)   {
	        if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
	        	result = null;
	        }
	    }

	    return result;
	}
	private Correio verificaCep(String cep) {
		correio = null;
		int tamanho = cep.length();
		if (tamanho <= 8 ) {
			for(int i = 1;i<=8;i++) {
				correio = getCep(cep);
				if (correio == null) {
					cep = StringUtils.rightPad(cep, tamanho+i, "0");
				}else {
					break;
				}
			}
		}
		
		return correio;
		
	}
}
