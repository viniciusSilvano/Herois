package com.stefanini.heroi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import com.stefanini.heroi.bo.partida.Partida;

//Tell Spring to automatically inject any dependencies that are marked in
//our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring that this object represents a Configuration for the
// application
@Configuration
// SpringBootWebLogicLegacyApplication is a SpringBootServletInitializer subclass and override its configure method.
@ComponentScan(basePackages = "com.stefanini.heroi.*")
public class HeroisStefaniniApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	// Tell Spring to launch our app!
	public static void main(String[] args) {
		Partida partida = new Partida();
		partida.IniciarPartidas(10);
		SpringApplication.run(HeroisStefaniniApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HeroisStefaniniApplication.class).showBanner(false);
	}
}