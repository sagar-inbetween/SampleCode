package com.sample.neo4j.application;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

import com.sample.neo4j.connector.AttributesConnector;
import com.sample.neo4j.connector.KlassConnector;
import com.sample.neo4j.entity.Attributes;
import com.sample.neo4j.entity.Klass;

@SpringBootApplication
public class ApplicationTest implements CommandLineRunner {
	
	@Configuration
	@ComponentScan("com.sample.neo4j.*")
	@EnableNeo4jRepositories(basePackages = "com.sample.neo4j.repository")
	static class ApplicationConfig extends Neo4jConfiguration {

		public ApplicationConfig() {
			setBasePackage("com.sample.neo4j.*");
		}

		@Bean
		GraphDatabaseService graphDatabaseService() {
			return new GraphDatabaseFactory()
					.newEmbeddedDatabase("accessingdataneo4j.db");
		}
	}

	@Autowired
	KlassConnector klassconnector;
	
	@Autowired 
	AttributesConnector attributeConnector;

	public static void main(String[] args) throws Exception {
		FileUtils.deleteRecursively(new File("accessingdataneo4j.db"));
		System.out.println("Starting Application");
		SpringApplication.run(ApplicationTest.class, args);
		System.out.println("Starting Application sjkdcbjsdhbc");
		System.out.println("Stoping Application");
	}

	public void run(String... args) {
		
		Klass klass = new Klass();
		klass.setName("Shoes");
		

		Klass klass1 = new Klass();
		klass1.setName("Mobiles");
		
		
		
		
		
		
		Attributes attribute= new Attributes();
		attribute.setName("Brand");
		Attributes savedattribute=attributeConnector.create(attribute);
		
		
		Attributes attribute1= new Attributes();
		attribute1.setName("Model");
		Attributes savedattribute1=attributeConnector.create(attribute1);
		
		Attributes attribute2= new Attributes();
		attribute2.setName("Price");
		Attributes savedattribute2=attributeConnector.create(attribute2);
		
		
		
		
		klass.addProperty(savedattribute, "Nike");
		klass.addProperty(savedattribute1, "Zigtech");
		klass.addProperty(savedattribute2, "5000");
		Klass savedKlassNode = klassconnector.create(klass);
		
		
		klass1.addProperty(savedattribute, "Sony");
		klass1.addProperty(savedattribute1, "Xperia-Z");
		klass1.addProperty(savedattribute2, "45000");
		Klass savedKlassNode1 = klassconnector.create(klass1);
		
		
		System.out.println("klass:    "+savedKlassNode);
		System.out.println("klass:    "+savedKlassNode1);
		System.out.println("Attribute:    "+savedattribute);
		System.out.println("Attribute:    "+savedattribute1);
		System.out.println("Attribute:    "+savedattribute2);
		
		
		
		
		
		
		
		
	}

}
