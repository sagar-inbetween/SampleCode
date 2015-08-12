package com.sample.neo4j.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.neo4j.entity.Klass;
import com.sample.neo4j.repository.IKlassRepositories;

@Component
public class KlassConnector  
{
	@Autowired
	private IKlassRepositories klassRepository;
	

	public Klass create(Klass klass)
	{
		return klassRepository.save(klass);
	}
	
	
	

}
