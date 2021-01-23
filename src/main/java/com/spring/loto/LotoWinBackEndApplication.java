package com.spring.loto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.loto.services.StatistiqueService;

@SpringBootApplication
public class LotoWinBackEndApplication implements CommandLineRunner{

	@Autowired
	StatistiqueService service;
	
	public static void main(String[] args) {
		
		SpringApplication.run(LotoWinBackEndApplication.class, args);
		new StatistiqueService();
		
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
