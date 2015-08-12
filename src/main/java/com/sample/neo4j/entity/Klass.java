package com.sample.neo4j.entity;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
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
	
	public Set<Attributes> getAttributes() {
		return attributes;
	}
	public void setAttributes(Set<Attributes> attributes) {
		this.attributes = attributes;
	}
	
	@RelatedTo(type="has",direction=Direction.OUTGOING)
	private Set<Attributes> attributes= new HashSet<Attributes>();
	
	
	@RelatedToVia(type="has",direction=Direction.OUTGOING)
	Iterable<RelationshipProperties> properties;
	
	
	
	
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
