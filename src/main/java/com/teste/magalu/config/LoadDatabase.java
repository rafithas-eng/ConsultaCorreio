package com.teste.magalu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.teste.magalu.entity.Correio;
import com.teste.magalu.repository.CorreioRepository;

class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	 @Bean
	  CommandLineRunner initDatabase(CorreioRepository repository) {

	    return args -> {
	      log.info("CEP " + repository.save(new Correio("Avenida Paulista", "Bela Vista", "São Paulo", "SP") ));//01310-940
	      log.info("CEP " + repository.save(new Correio("Avenida Nazareth", "Ipiranga", "São Paulo", "SP") ));//04263-000
	      log.info("CEP " + repository.save(new Correio("Rua Brigadeiro Jordão", "Ipiranga", "São Paulo", "SP") ));//04210-000
	      log.info("CEP " + repository.save(new Correio("Praça Pateo do Collegio", "Centro", "São Paulo", "SP") ));//01016-040
	      log.info("CEP " + repository.save(new Correio("Praça do Patriarca", "Sé", "São Paulo", "SP") ));//01002010
	      log.info("CEP " + repository.save(new Correio("Praça da Luz", "Bom Retiro", "São Paulo", "SP") ));//01120-010
	      log.info("CEP " + repository.save(new Correio("Avenida Pedro Álvares Cabral", "Vila Mariana", "São Paulo", "SP") ));//04094-050
	      log.info("CEP " + repository.save(new Correio("Avenida Senador Teotônio Vilela", "Interlagos", "São Paulo", "SP") ));//04801-010
	      log.info("CEP " + repository.save(new Correio("Rua Adirso Alves Ferreira", "Solo Sagrado", "São Paulo", "SP") ));//15044-280
	      log.info("CEP " + repository.save(new Correio("Avenida Guarapiranga", "Parque Alves de Lima", "São Paulo", "SP") ));//04902-900
	    };
	 }
	
}
