package com.example.springbootbackend;

import com.example.springbootbackend.model.Faktura;
import com.example.springbootbackend.repository.FakturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	@Autowired
	private FakturaRepository fakturaRepository;
	@Override
	public void run(String... args) throws Exception {

	}
}
