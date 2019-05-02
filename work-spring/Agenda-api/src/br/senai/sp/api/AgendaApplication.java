package br.senai.sp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//← dizendo para spring que ele pode cuidar  dessa classe com seus metodos 
public class AgendaApplication {

	public static void main(String[] args) {
		 SpringApplication.run(AgendaApplication.class, args);

	}

}
