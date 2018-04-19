package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topics 
{
 
     @Id
     @Column(name="id")
	private int id;

	@Column(name="name")
	 private String name;
	  
	@Column(name="description")
	  private String description;
	  
	  public Topics()
	  {
		  
	  }
	  
	  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Topics(String name, String description, int id) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString()
	{
		return "ID-"+id+" Name-"+name+" Description-"+description;
	}

}
