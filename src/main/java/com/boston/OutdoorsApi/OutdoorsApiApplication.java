package com.boston.OutdoorsApi;

import com.boston.OutdoorsApi.service.impl.IndexingService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class OutdoorsApiApplication {



	public static void main(String[] args) throws Exception {

		SpringApplication.run(OutdoorsApiApplication.class, args);

	}


	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}

}


