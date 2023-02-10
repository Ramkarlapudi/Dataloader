package com.mustread.dataloader;

import java.nio.file.Path;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.mustread.dataloader.config.DataStaxProperties;
import com.mustread.dataloader.entity.Author;
import com.mustread.dataloader.repository.AuthorRepository;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxProperties.class)
public class DataloaderApplication {
	
	@Autowired AuthorRepository authorRepository;
	
	

	public static void main(String[] args) {
		
		
		SpringApplication.run(DataloaderApplication.class, args);
		
		  
	}
	
	@Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }
	
	@PostConstruct
	public void start() {
		/* loading the data */
		System.out.println("Calling cassandra Instance");
		Author author =  new Author();
		author.setId("id");
		author.setName("Ram");
		author.setPersonalName("Ram Karlapudi");
		
		authorRepository.save(author);
		
	}

}
