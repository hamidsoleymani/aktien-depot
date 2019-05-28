package com.boostmedia.aktiendepot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

//@EnableJpaRepositories("com.boostmedia.aktiendepot.repository")
public class AktienDepotModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(AktienDepotModelApplication.class, args);
	}

}
