package com.teste.magalu.entity;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.magalu.repository.CorreioRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CorreioTests {
	@Mock
	private static CorreioRepository correioRepository;
	
	private Correio correio;
	
	@Test
	public void testCep() {
		
		Long  correiotId = new Long (1);
		
		correio = new Correio();
	
		correio.setLogradouro("Avenida Paulista");
		correio.setBairro("Bela Vista");
		correio.setLocalidade("São Paulo");
		correio.setUf( "SP");
			
		Optional<Correio> correioRecebido = correioRepository.findById(correiotId);
		
		Assert.assertNotEquals(correio, correioRecebido);
		
	}
}
