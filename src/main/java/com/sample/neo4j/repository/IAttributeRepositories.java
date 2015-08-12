package com.sample.neo4j.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.sample.neo4j.entity.Attributes;

public interface IAttributeRepositories extends GraphRepository<Attributes>
{

}
