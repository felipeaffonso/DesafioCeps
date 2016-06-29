package br.com.felipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.felipe.controller", "br.com.felipe.service"})
@EntityScan(basePackages = {"br.com.felipe.model"})
@EnableJpaRepositories(basePackages = {"br.com.felipe.repository"})
public class DesafioCepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCepsApplication.class, args);
	}
}
