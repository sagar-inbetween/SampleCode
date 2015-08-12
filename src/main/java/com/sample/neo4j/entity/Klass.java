package com.sample.neo4j.entity;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Klass
{
	@Override
	public String toString() {
		return "Klass [id=" + id + ", name=" + name + "]";
	}
	@GraphId
	private Long id;
	
	private String name;
	
	
	
	/*@RelatedTo(type="has",direction=Direction.OUTGOING)
	private Set<Attributes> attributes= new HashSet<Attributes>();
	*/
	
	@RelatedToVia(type="has",direction=Direction.INCOMING)
	Set<RelationshipProperties> properties=new HashSet<RelationshipProperties>();
	
	
	
	public RelationshipProperties addProperty(Attributes attribute,String value)
	{
		RelationshipProperties relationshipProperty= new RelationshipProperties(this,attribute,value);
		
		properties.add(relationshipProperty);
		return relationshipProperty; 
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
