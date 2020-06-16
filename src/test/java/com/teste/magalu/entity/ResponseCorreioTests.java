package com.teste.magalu.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.magalu.controller.CorreioController;

@SpringBootTest
public class ResponseCorreioTests {
	
	@Mock
	private CorreioController correioController;
	
	@Mock
	private ResponseCorreio responseCorreio;
	
	@Mock
	private Correio correio;
	
	private BuscaCep buscaCep;
	
	@Test
	public void testResponseCorreio() {
		
		buscaCep = new BuscaCep();
		
		buscaCep.setCep("01310940");
		
		correio = new Correio("Avenida Paulista", "Bela Vista", "São Paulo", "SP");
		responseCorreio.setMessage(correio.toString());
		
		correioController = new CorreioController();
		
		ResponseCorreio responseCorreioRecived = correioController.getCorreio(buscaCep);
		
		
		Assert.assertEquals(responseCorreioRecived, responseCorreio);
	}
}
