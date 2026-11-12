package br.com.eduardo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Conta conta = new Conta("001", "Eduardo");
	System.out.println("Titular: " + conta.getTitular());
	System.out.println("Saldo inicial: " + conta.getSaldoEmCentavos() + " centavos");
	}

}
