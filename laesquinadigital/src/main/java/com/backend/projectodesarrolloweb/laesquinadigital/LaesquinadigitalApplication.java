package com.backend.projectodesarrolloweb.laesquinadigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan("com.backend.projectodesarrolloweb.laesquinadigital")
@EntityScan("com.backend.projectodesarrolloweb.laesquinadigital")
@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootApplication
public class LaesquinadigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaesquinadigitalApplication.class, args);
	}

}
