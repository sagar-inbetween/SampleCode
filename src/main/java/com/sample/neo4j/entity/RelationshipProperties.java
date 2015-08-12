package com.sample.neo4j.entity;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;



@RelationshipEntity
public class RelationshipProperties
{
	@GraphId
	Long id;
	
	@StartNode
	Klass klass;
	
	@EndNode
	Attributes attributes;
	
	String value;

}
