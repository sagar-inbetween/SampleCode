package com.sample.neo4j.connector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.neo4j.entity.Attributes;
import com.sample.neo4j.entity.Klass;
import com.sample.neo4j.repository.IAttributeRepositories;


@Component
public class AttributesConnector
{
	@Autowired
	private IAttributeRepositories attributeRepository;
	
	
	public Attributes create(Attributes attributes)
	{
		return attributeRepository.save(attributes);
	}
	

}
