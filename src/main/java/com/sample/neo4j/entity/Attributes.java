package com.sample.neo4j.entity;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;


@NodeEntity
public class Attributes
{
	@GraphId
	private Long id;
	
	private String name;
	
	
	
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
	@Override
	public String toString() {
		return "Attributes [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
