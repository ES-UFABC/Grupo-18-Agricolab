package br.com.agricolab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.agricolab", "br.com.agricolab.produtor.controller.ProdutorController", "br.com.agricolab.consumidor.controller.ConsumidorController"})
public class AgricolabApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgricolabApplication.class, args);
	}

}
