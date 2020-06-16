package com.teste.magalu.entity;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class BuscaCepTests {
	
	@Mock
	private BuscaCep cep;
	
	@Test
	public void testCepNull() {
		
		
		cep = new BuscaCep();
		Mockito.when(cep.getCep()).thenReturn(null);
	}
	
	@Test
	public void testCepNotNull() {
		
		cep = new BuscaCep();
		cep.setCep("01310-940");
		Mockito.when(cep.getCep()).thenReturn("01310-940");
		
	}
}
